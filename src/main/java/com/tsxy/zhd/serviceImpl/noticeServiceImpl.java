package com.tsxy.zhd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsxy.zhd.dao.noticeDao;
import com.tsxy.zhd.service.noticeService;
import com.tsxy.zhd.vo.Notice;

@Service
public class noticeServiceImpl implements noticeService{
	@Autowired
	private noticeDao noticeDao;

	@Override
	public List<Notice> selectAll(int before, int after,Notice notice) {
		return noticeDao.selectAll(before, after, notice);
	}

	@Override
	public void saveNotice(Notice notice) {
		 noticeDao.saveNotice(notice);
	}

	@Override
	public int count() {
		return noticeDao.count();
	}

	@Override
	public Notice selectByID(int id) {
		return noticeDao.selectById(id);
	}

	@Override
	public void updateByID(Notice notice) {
		noticeDao.updateNoticeById(notice);
	}

	@Override
	public void deleteByID(int id) {
		noticeDao.deleteNoticeById(id);
	}

	@Override
	public List<Notice> selectNotices() {
		return noticeDao.selectNotices();
	}

	
	
	

}
