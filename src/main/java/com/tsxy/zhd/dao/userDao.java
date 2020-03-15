package com.tsxy.zhd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.tsxy.zhd.vo.Role;
import com.tsxy.zhd.vo.RolePermission;
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
	
	//查询对象
	@Select("<script>"
			+ "SELECT o.* FROM (select * from user where tag!='0'"
			+ "<if test=\"user.username!=null and user.username!=''\">"
			+ "and LOCATE(#{user.username},username)>0"
			+ "</if>"
			+ "<if test=\"user.phoneNumber!=null and user.phoneNumber!=''\">"
			+ "and LOCATE(#{user.phoneNumber},phoneNumber)>0"
			+ "</if>"
			+ "<if test=\"user.idNumber!=null and user.idNumber!=''\">"
			+ "and LOCATE(#{user.idNumber},idNumber)>0"
			+ "</if>"
			+ ")o limit  #{before} , #{after}"
			+ "</script>")
	List<User> selectAll(@Param("before")int before, @Param("after")int after,@Param("user")User user);
	
	//数据个数
	@Select("select count(1) from user")
	int count();
	
	//根据id查询对象
	@Select("select * from user where id=#{id}")
	User selectById(@Param("id")int id);
	
	//根据主键id修改对象
	@Update("UPDATE user set password=#{password},sex=#{sex},phoneNumber=#{phoneNumber},birthday=#{birthday},idNumber=#{idNumber},career=#{career},"
			+ "address=#{address},remarks=#{remarks} where id=#{id}")
	void updateUserById(User user);
	
	//根据id删除对象
	@Delete("DELETE from user where id=#{id}")
	void deleteUserById(@Param("id")int id);
	
	//保存用户表数据
	@Insert("INSERT INTO user VALUES (null,#{username},#{password},#{sex},#{phoneNumber},#{birthday},#{idNumber},#{career},#{inTime},#{address},#{remarks},#{tag})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	void saveUser(User user);
	
	//保存用户角色表
	@Insert("INSERT INTO user_role VALUES (#{userId},#{roleId})")
	void saveUserRole(@Param("userId")int userId,@Param("roleId")int roleId);
	
	//根据用户id删除对象（用户角色表）
	@Delete("DELETE from user_role where userId=#{userId}")
	void delByUserRoleId(@Param("userId")int userId);
	
	//根据userId修改tag
	@Update("update user set tag=#{tag} where id=#{id}")
	void updateTagById(@Param("tag")String tag,@Param("id")int id);
	
	//根据userId修改角色表
	@Update("update user_role set roleId=#{roleId} where userId=#{userId}")
	void updateUserRoleById(@Param("roleId")int roleId,@Param("userId")int userId);
	
	//查询所有角色权限表信息
	@Select("SELECT * FROM role_permission")
	List<RolePermission> selectRolePermission();
	
	//根据角色id删除权限信息
	@Delete("DELETE from role_permission where roleId=#{roleId}")
	void deletePermissionByRoleId(@Param("roleId")int roleId);
	
	//保存权限信息
	@Insert("INSERT INTO role_permission VALUES (#{roleId},#{permissionId})")
	void savePermission(@Param("roleId")int roleId,@Param("permissionId")int permissionId);
}
