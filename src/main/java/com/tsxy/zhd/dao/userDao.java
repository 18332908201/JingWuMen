package com.tsxy.zhd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.tsxy.zhd.vo.Role;
import com.tsxy.zhd.vo.User;

@Mapper
@Component
public interface userDao {
	//通过账号用户名找到对象
	@Select("SELECT * FROM User where username = #{username}")
    User findUserByName(String username);
	//通过用户id查找用户角色
	@Select("SELECT * FROM role where id = (select roleId from user_role where userId=#{userId})")
	List<Role> findRoleByUserId(int userId);
}
