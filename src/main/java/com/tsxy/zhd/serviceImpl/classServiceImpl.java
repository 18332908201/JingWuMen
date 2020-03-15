package com.tsxy.zhd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsxy.zhd.dao.classDao;
import com.tsxy.zhd.service.classService;
import com.tsxy.zhd.vo.Class;
import com.tsxy.zhd.vo.ClassOrder;

@Service
public class classServiceImpl implements classService{
	@Autowired
	private classDao classDao;

	@Override
	public List<Class> selectAll(int before, int after, Class cla) {
		return classDao.selectAll(before, after, cla);
	}

	@Override
	public void saveClass(Class cla) {
		classDao.saveClass(cla);
	}

	@Override
	public int count() {
		return classDao.count();
	}

	@Override
	public Class selectByID(int id) {
		return classDao.selectById(id);
	}

	@Override
	public void updateByID(Class cla) {
		classDao.updateClassById(cla);
	}

	@Override
	public void deleteByID(int id) {
		classDao.deleteClassById(id);
	}

	@Override
	public void saveClassOrder(ClassOrder classOrder) {
		classDao.saveClassOrder(classOrder);
	}

	@Override
	public ClassOrder isHave(String userName, String className) {
		return classDao.isHave(userName, className);
	}

	@Override
	public void updateNuberByName(String className) {
		classDao.updateNuberByName(className);
	}

	@Override
	public List<Class> findAll() {
		return classDao.findAll();
	}

	@Override
	public List<ClassOrder> selectOderAll(int before, int after, ClassOrder classOrder) {
		return classDao.selectOderAll(before, after, classOrder);
	}

	@Override
	public int orderCount() {
		return classDao.orderCount();
	}

	
}
