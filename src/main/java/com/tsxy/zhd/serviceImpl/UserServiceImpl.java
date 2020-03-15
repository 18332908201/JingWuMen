package com.tsxy.zhd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsxy.zhd.dao.userDao;
import com.tsxy.zhd.service.UserService;
import com.tsxy.zhd.vo.Role;
import com.tsxy.zhd.vo.RolePermission;
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
	@Override
	public List<User> selectAll(int before, int after, User user) {
		return userDao.selectAll(before, after, user);
	}
	@Override
	public int count() {
		return userDao.count();
	}
	@Override
	public User selectByID(int id) {
		return userDao.selectById(id);
	}
	@Override
	public void updateByID(User user) {
		userDao.updateUserById(user);
	}
	@Override
	public void deleteByID(int id) {
		userDao.deleteUserById(id);
	}
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	@Override
	public void saveUserRole(int userId, int roleId) {
		userDao.saveUserRole(userId, roleId);
	}
	@Override
	public void delByUserRoleId(int userId) {
		userDao.delByUserRoleId(userId);
	}
	@Override
	public void updateTagById(String tag, int id) {
		userDao.updateTagById(tag, id);
	}
	@Override
	public void updateUserRoleById(int roleId, int userId) {
		userDao.updateUserRoleById(roleId, userId);
	}
	@Override
	public List<RolePermission> selectRolePermission() {
		return userDao.selectRolePermission();
	}
	@Override
	public void deletePermissionByRoleId(int roleId) {
		userDao.deletePermissionByRoleId(roleId);
	}
	@Override
	public void savePermission(int roleId, int permissionId) {
		userDao.savePermission(roleId, permissionId);
	}

}
