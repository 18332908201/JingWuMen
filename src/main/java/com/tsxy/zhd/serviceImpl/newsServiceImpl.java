package com.tsxy.zhd.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsxy.zhd.dao.newsDao;
import com.tsxy.zhd.service.newsService;
import com.tsxy.zhd.vo.News;
import com.tsxy.zhd.vo.Notice;

@Service
public class newsServiceImpl implements newsService{
	@Autowired
	private newsDao newsDao;

	@Override
	public News findNews() {
		return newsDao.findnews();
	}

	@Override
	public void updateNewsById(News news) {
		newsDao.updateNewsById(news);
	}

	
	
	

}
