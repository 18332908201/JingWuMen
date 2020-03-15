package com.tsxy.zhd.service;

import com.tsxy.zhd.vo.News;


public interface newsService{
	//查询新闻管理的概况（默认只有一个对象）
	News findNews();
	//根据主键id修改对象
	void updateNewsById(News news);
	
}
