package com.tsxy.zhd.service;

import java.util.List;

import com.tsxy.zhd.vo.Class;
import com.tsxy.zhd.vo.ClassOrder;

public interface classService{
	//查询所有课程（分页）
	List<Class> selectAll(int before, int after,Class cla);
	//查询所有课程
	List<Class> findAll();
	//保存数据
	void saveClass(Class cla);
	//课程   数据个数
	int count();
	//根据主键id查询对象
	Class selectByID(int id);
	//根据主键id修改对象
	void updateByID(Class cla);
	//根据主键id删除对象
	void deleteByID(int id);
	//预定课程
	void saveClassOrder(ClassOrder classOrder);
	//查询用户是否预定过课程
	ClassOrder isHave(String userName,String className);
	//根据课程名更改已预定人数
	void updateNuberByName(String className);
	//查询所有预定课程（分页）
	List<ClassOrder> selectOderAll(int before, int after,ClassOrder classOrder);
	//预定课程      数据个数
	int orderCount();
}
