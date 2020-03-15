package com.tsxy.zhd.service;

import java.util.List;

import com.tsxy.zhd.vo.Role;
import com.tsxy.zhd.vo.RolePermission;
import com.tsxy.zhd.vo.User;

public interface UserService{
	//通过账号用户名找到对象
	User findUserByName(String username);
	//通过用户id查找用户权限
	List<Role> findRoleByUserId(int userId);
	//查询所有用户
	List<User> selectAll(int before, int after,User user);
	//数据个数
	int count();
	//根据主键id查询对象
	User selectByID(int id);
	//根据主键id修改对象
	void updateByID(User user);
	//根据主键id删除对象
	void deleteByID(int id);
	//保存数据
	void saveUser(User user);
	//保存用户角色表
	void saveUserRole(int userId,int roleId);
	//通过用户id删除  用户角色表
	void delByUserRoleId(int userId);
	//根据userId修改tag
	void updateTagById(String tag,int id);
	//根据userId修改角色表
	void updateUserRoleById(int roleId,int userId);
	//查询所有角色权限表信息
	List<RolePermission> selectRolePermission();
	//根据角色id删除权限信息
	void deletePermissionByRoleId(int roleId);
	//保存权限信息
	void savePermission(int roleId,int permissionId);
}
