package com.tsxy.zhd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.tsxy.zhd.vo.Permission;

@Mapper
@Component
public interface permissionDao {
	//通过角色id查找权限
	@Select("SELECT * FROM permission where id in (select permissionId from role_permission where roleId=#{roleId})")
	List<Permission> findPermissionByRoleId(int roleId);
}
