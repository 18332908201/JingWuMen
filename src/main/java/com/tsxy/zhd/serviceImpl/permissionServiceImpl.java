package com.tsxy.zhd.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsxy.zhd.dao.permissionDao;
import com.tsxy.zhd.service.permissionService;
import com.tsxy.zhd.vo.Permission;

@Service
public class permissionServiceImpl implements permissionService{
	@Autowired
	private permissionDao permissionDao;
	
	@Override
	public List<Permission> findPermissionByRoleId(int roleId) {
		return permissionDao.findPermissionByRoleId(roleId);
	}
	

}
