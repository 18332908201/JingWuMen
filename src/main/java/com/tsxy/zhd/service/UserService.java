package com.tsxy.zhd.service;

import java.util.List;

import com.tsxy.zhd.vo.Role;
import com.tsxy.zhd.vo.User;

public interface UserService{
	//通过账号用户名找到对象
	User findUserByName(String username);
	//通过用户id查找用户权限
	List<Role> findRoleByUserId(int userId);
}
