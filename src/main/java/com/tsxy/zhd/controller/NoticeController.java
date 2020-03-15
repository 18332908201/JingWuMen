package com.tsxy.zhd.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tsxy.zhd.service.noticeService;
import com.tsxy.zhd.vo.Notice;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private noticeService noticeService;
	
	
	//去活动公告管理页面
	@RequestMapping("/toNoticeMain")
	public ModelAndView toNoticeMain(){
		ModelAndView view = new ModelAndView();
        view.setViewName("notice/noticeMain");
        return view;
	}
	//活动公告管理页面数据
	@RequestMapping(value="/noticeMainData",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String noticeMainData(@RequestParam int page, @RequestParam int limit, Notice notice) {
		System.out.println("进来了");
		int before = limit * (page - 1);
		int after = page * limit;
		List<Notice> notices = noticeService.selectAll(before, after, notice);
		int count = noticeService.count(); 
		 JSONArray json = JSONArray.fromObject(notices);
		 String js = json.toString();
		 String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+js+"}";//转为layui需要的json格式
		 return jso;
	}
	//去活动公告管理添加页面
	@RequestMapping("/toNoticeAdd")
	public ModelAndView toNoticeAdd(){
		ModelAndView view = new ModelAndView();
		System.out.println("添加页面");
        view.setViewName("notice/noticeAdd");
        return view;
	}
	//添加
	@ResponseBody
	@RequestMapping("/saveNotice")
	public String saveNotice(@RequestBody Notice notice){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String time = dateFormat.format(now); 
		notice.setCreateTime(time);
		noticeService.saveNotice(notice);
		return "success";
	}
	//去活动公告管理修改页面
	@RequestMapping("/toNoticeUpdate")
	public ModelAndView toNoticeUpdate(int id){
		ModelAndView view = new ModelAndView();
		System.out.println("修改页面");
		Notice notice = noticeService.selectByID(id);
		view.addObject("notice", notice);
        view.setViewName("notice/noticeUpdate");
        return view;
	}
	//修改
	@ResponseBody
	@RequestMapping("/updateNotice")
	public String updateNotice(@RequestBody Notice notice){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String time = dateFormat.format(now); 
		notice.setCreateTime(time);
		noticeService.updateByID(notice);
		return "success";
	}
	//删除
	@ResponseBody
	@RequestMapping("/deleteNotice")
	public String deleteNotice(@RequestBody int id){
		noticeService.deleteByID(id);
		return "success";
	}
	//去活动公告展示页面
	@RequestMapping("/toNoticeShow")
	public ModelAndView toNoticeShow(){
		ModelAndView view = new ModelAndView();
		List<Notice> list = noticeService.selectNotices();
		view.addObject("list", list);
        view.setViewName("notice/noticeShow");
        return view;
	}
}
