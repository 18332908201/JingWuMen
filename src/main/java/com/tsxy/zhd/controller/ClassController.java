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
import com.tsxy.zhd.service.classService;
import com.tsxy.zhd.vo.Class;
import com.tsxy.zhd.vo.ClassOrder;
import com.tsxy.zhd.vo.User;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/class")
public class ClassController {
	@Autowired
	private classService classService;
	@Autowired
	private UserService userService;
	
	
	//去课程管理页面
	@RequestMapping("/toClassMain")
	public ModelAndView toNoticeMain(){
		ModelAndView view = new ModelAndView();
        view.setViewName("class/classMain");
        return view;
	}
	//课程管理页面数据
	@RequestMapping(value="/classMainData",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String classMainData(@RequestParam int page, @RequestParam int limit, Class cls) {
		System.out.println("进来了");
		int before = limit * (page - 1);
		int after = page * limit;
		List<Class> classs = classService.selectAll(before, after, cls);
		int count = classService.count(); 
		 JSONArray json = JSONArray.fromObject(classs);
		 String js = json.toString();
		 String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";//转为layui需要的json格式
		 return jso;
	}
	//去课程管理添加页面
	@RequestMapping("/toClassAdd")
	public ModelAndView toClassAdd(){
		ModelAndView view = new ModelAndView();
		System.out.println("添加页面");
        view.setViewName("class/classAdd");
        return view;
	}
	//添加
	@ResponseBody
	@RequestMapping("/saveClass")
	public String saveClass(@RequestBody Class cla){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String time = dateFormat.format(now); 
		cla.setUpdateTime(time);
		classService.saveClass(cla);
		return "success";
	}
	//去课程管理修改页面
	@RequestMapping("/toClassUpdate")
	public ModelAndView toNoticeUpdate(int id){
		ModelAndView view = new ModelAndView();
		System.out.println("修改页面");
		Class cla= classService.selectByID(id);
		view.addObject("cla", cla);
        view.setViewName("class/classUpdate");
        return view;
	}
	//修改
	@ResponseBody
	@RequestMapping("/updateClass")
	public String updateNotice(@RequestBody Class cla){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String time = dateFormat.format(now); 
		cla.setUpdateTime(time);
		classService.updateByID(cla);
		return "success";
	}
	//删除
	@ResponseBody
	@RequestMapping("/deleteClass")
	public String deleteClass(@RequestBody int id){
		classService.deleteByID(id);
		return "success";
	}
	
	//去预定页面
	@RequestMapping("/toClassOrder")
	public ModelAndView toClassOrder(HttpSession session){
		ModelAndView view = new ModelAndView();
		User user=(User) session.getAttribute("user");
		view.addObject("user", user);
        //查询所有的课程
        List<Class> list = classService.findAll();
        view.addObject("list", list);
        view.setViewName("class/classOrder");
        return view;
	}
	
	//预定课程
	@ResponseBody
	@RequestMapping("/saveClassOrder")
	public String saveClassOrder(@RequestBody ClassOrder classOrder){
		//判断用户名是否存在
		User findUserByName = userService.findUserByName(classOrder.getUserName());
		if(findUserByName==null) {
			return "fail1";//用户不存在
		}
		//判断是否预定过课程
		ClassOrder order = classService.isHave(findUserByName.getUsername(), classOrder.getClassName());
		if(order!=null) {
			return "fail2";//已预定过该课程
		}
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String time = dateFormat.format(now); 
		classOrder.setCreateTime(time);
		classService.saveClassOrder(classOrder);
		//更改课程已预定人数
		classService.updateNuberByName(classOrder.getClassName());
		return "success";
	}
	
	//去课程预定列表页面
	@RequestMapping("/toClassOrderShow")
	public ModelAndView toClassOrderShow(){
		ModelAndView view = new ModelAndView();
        view.setViewName("class/classOrderShow");
        return view;
	}
	//课程管理页面数据
	@RequestMapping(value="/classOrderShowData",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String classOrderShowData(@RequestParam int page, @RequestParam int limit, ClassOrder classOrder) {
		int before = limit * (page - 1);
		int after = page * limit;
		List<ClassOrder> classOrders = classService.selectOderAll(before, after, classOrder);
		int count = classService.count(); 
		 JSONArray json = JSONArray.fromObject(classOrders);
		 String js = json.toString();
		 String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";//转为layui需要的json格式
		 return jso;
	}
}
