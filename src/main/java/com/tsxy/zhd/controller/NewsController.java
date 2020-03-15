package com.tsxy.zhd.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tsxy.zhd.service.newsService;
import com.tsxy.zhd.vo.News;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private newsService newsService;
	
	
	//去新闻管理页面
	@RequestMapping("/toNewsUpdate")
	public ModelAndView toNewsUpdate(){
		ModelAndView view = new ModelAndView();
		News news = newsService.findNews();
		System.err.println(news.getDevelopment());
		view.addObject("news", news);
        view.setViewName("news/newUpdate");
        return view;
	}
	
	//修改
	@ResponseBody
	@RequestMapping("/updateNews")
	public String updateNews(@RequestBody News news){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String time = dateFormat.format(now); 
		news.setCreateTime(time);
		System.err.println("ll"+news.getCreateTime());
		newsService.updateNewsById(news);
		return "success";
	}
	
	//去俱乐部概况展示页面
	@RequestMapping("/toNewsShow")
	public ModelAndView toNewsShow(){
		ModelAndView view = new ModelAndView();
		News news = newsService.findNews();
		System.err.println(news.getDevelopment());
		view.addObject("news", news);
        view.setViewName("news/newShow");
        return view;
	}
}
