package com.tsxy.zhd.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tsxy.zhd.service.UserService;
import com.tsxy.zhd.service.permissionService;
import com.tsxy.zhd.vo.Permission;
import com.tsxy.zhd.vo.Role;
import com.tsxy.zhd.vo.User;

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
        System.err.println("12ww");
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

}
