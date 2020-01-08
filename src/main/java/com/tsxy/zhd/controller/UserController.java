package com.tsxy.zhd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tsxy.zhd.vo.User;

@Controller
@RequestMapping
public class UserController {
	@RequestMapping("/hi")
	public ModelAndView hi(){
		ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        // 设置属性
        view.addObject("title", "我的templates页面");
        view.addObject("desc", "欢迎进入我的csdn博客");
        User user=new User();
        user.setUsername("wdk");
        user.setPassword("111");
        user.setAge(20);
        view.addObject("user", user);
        return view;
	}

}
