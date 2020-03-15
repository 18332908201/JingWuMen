package com.tsxy.zhd.service;

import java.util.List;

import com.tsxy.zhd.vo.Notice;

public interface noticeService{
	//查询所有公告
	List<Notice> selectAll(int before, int after,Notice notice);
	//保存数据
	void saveNotice(Notice notice);
	//数据个数
	int count();
	//根据主键id查询对象
	Notice selectByID(int id);
	//根据主键id修改对象
	void updateByID(Notice notice);
	//根据主键id删除对象
	void deleteByID(int id);
	//查询所有对象
	List<Notice> selectNotices();
}
