package com.tsxy.zhd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsxy.zhd.dao.userDao;
import com.tsxy.zhd.service.UserService;
import com.tsxy.zhd.vo.Role;
import com.tsxy.zhd.vo.User;
@ Service
public class UserServiceImpl implements UserService{
	@Autowired
	private userDao userDao;
	@Override
	public User findUserByName(String username) {
		return userDao.findUserByName(username);
	}
	@Override
	public List<Role> findRoleByUserId(int userId) {
		return userDao.findRoleByUserId(userId);
	}

}
