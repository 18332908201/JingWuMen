package com.tsxy.zhd.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tsxy.zhd.service.UserService;
import com.tsxy.zhd.service.permissionService;
import com.tsxy.zhd.vo.Permission;
import com.tsxy.zhd.vo.Role;
import com.tsxy.zhd.vo.RolePermission;
import com.tsxy.zhd.vo.User;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService UserService;
	@Autowired
	private permissionService permissionService;
	
	//去登录页面
	@RequestMapping("/tologin")
	public ModelAndView login(){
		ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("login");
        return view;
	}
	//去主页面
	@RequestMapping("/toindex")
	public ModelAndView index(HttpSession session){
		ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        String permissionStr = (String) session.getAttribute("permissionStr");
        System.out.println(permissionStr);
        User user=(User) session.getAttribute("user");
        view.addObject("permissionStr", permissionStr);
        view.addObject("user", user);
        return view;
	}
	//登陆
	@ResponseBody
	@RequestMapping("/login")
	public String login(@RequestBody User user,HttpSession session){
		String status="fail";
		//去数据库查询用户
		User findUserByName = UserService.findUserByName(user.getUsername());
		if(findUserByName!=null) {
			if(findUserByName.getPassword().equals(user.getPassword())) {
				status="success";
				List<Role> roles = UserService.findRoleByUserId(findUserByName.getId());
				//将权限信息放到session字符串中，以#相隔
				String permissionStr="";
				for (Role role : roles) {
					List<Permission> permissions = permissionService.findPermissionByRoleId(role.getId());
					for (Permission permission : permissions) {
						permissionStr=permissionStr+permission.getName()+"#";
					}
				}
				permissionStr=permissionStr.substring(0, permissionStr.length()-1);
				session.setAttribute("permissionStr", permissionStr);
				session.setAttribute("user", findUserByName);
			}else {
				status="fail";
			}
		}else {
			status="fail";
		}
		return status;
	}
	//去用户管理页面
	@RequestMapping("/toUserMain")
	public ModelAndView toUserMain(HttpSession session){
		ModelAndView view = new ModelAndView();
		User user = (User) session.getAttribute("user");
		view.addObject("user", user);
        view.setViewName("user/userMain");
        return view;
	}
	//用户管理页面数据
	@RequestMapping(value="/userMainData",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String noticeMainData(@RequestParam int page, @RequestParam int limit, User user) {
		int before = limit * (page - 1);
		int after = page * limit;
		List<User> users = UserService.selectAll(before, after, user);
		int count = UserService.count(); 
		 JSONArray json = JSONArray.fromObject(users);
		 String js = json.toString();
		 String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";//转为layui需要的json格式
		 return jso;
	}
	//去用户管理添加页面
	@RequestMapping("/toUserAdd")
	public ModelAndView toNoticeAdd(){
		ModelAndView view = new ModelAndView();
		System.out.println("添加页面");
        view.setViewName("user/userAdd");
        return view;
	}
	//添加
	@ResponseBody
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody User user){
		//保存人员表
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String time = dateFormat.format(now);
		user.setTag("会员");
		user.setInTime(time);
		UserService.saveUser(user);
		//添加用户角色表
		UserService.saveUserRole(user.getId(), 3);//普通用户角色id为3
		return "success";
	}
	//删除
	@ResponseBody
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestBody int id){
		//删除用户表用户
		UserService.deleteByID(id);
		//删除级联表 用户角色表
		UserService.delByUserRoleId(id);
		return "success";
	}
	//去用户管理修改页面
	@RequestMapping("/toUserUpdate")
	public ModelAndView toUserUpdate(int id){
		ModelAndView view = new ModelAndView();
		System.out.println("修改页面");
		User user = UserService.selectByID(id);
		view.addObject("user", user);
        view.setViewName("user/userUpdate");
        return view;
	}
	//修改
	@ResponseBody
	@RequestMapping("/updateUser")
	public String updateUser(@RequestBody User user){
		UserService.updateByID(user);
		return "success";
	}
	//去角色管理页面
	@RequestMapping("/toUserRole")
	public ModelAndView toUserRole(){
		ModelAndView view = new ModelAndView();
        view.setViewName("user/userRole");
        return view;
	}
	//修改角色
	@ResponseBody
	@RequestMapping("/updateRole")
	public String updateRole(@RequestBody User user){
		//更改用户表
		UserService.updateTagById(user.getTag(),user.getId());
		//更改角色表
		int roleId=3;
		if(user.getTag().equals("管理员")) {
			roleId=2;
		}
		UserService.updateUserRoleById(roleId, user.getId());
		return "success";
	}
	//去权限管理页面
	@RequestMapping("/toRolePerssion")
	public ModelAndView toRolePerssion(){
		ModelAndView view = new ModelAndView();
		List<RolePermission> rolePermissions = UserService.selectRolePermission();
		view.addObject("rolePermissions", rolePermissions);
        view.setViewName("user/rolePerssion");
        return view;
	}
	//修改角色权限信息
	@ResponseBody
	@RequestMapping("/updateRolePermission")
	public String updateRolePermission(@RequestBody RolePermission rolePermission){
		//删除角色的权限信息
		UserService.deletePermissionByRoleId(rolePermission.getRoleId());
		//添加权限
		String[] strs = rolePermission.getPermissionIds().split(",");
		for (int i = 0; i < strs.length; i++) {
			int permissionId = Integer.parseInt( strs[i] );
			System.out.println(permissionId);
			UserService.savePermission(rolePermission.getRoleId(), permissionId);
		}
		return "success";
	}
	//退出
	@RequestMapping("/toExit")
	public ModelAndView toExit(HttpSession session){
		ModelAndView view = new ModelAndView();
		session.setAttribute("permissionStr", "");
		session.setAttribute("user", "");
        view.setViewName("login");
        return view;
	}
}
