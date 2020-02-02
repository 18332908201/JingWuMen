package com.tsxy.zhd.service;

import java.util.List;

import com.tsxy.zhd.vo.Permission;


public interface permissionService{
	//通过角色id查找权限
	List<Permission> findPermissionByRoleId(int roleId);
}
