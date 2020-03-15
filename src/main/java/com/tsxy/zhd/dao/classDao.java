package com.tsxy.zhd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.tsxy.zhd.vo.Class;
import com.tsxy.zhd.vo.ClassOrder;


@Mapper
@Component
public interface classDao {
	//查询对象（分页）
	@Select("<script>"
			+ "SELECT o.* FROM (select * from class where 1=1"
			+ "<if test=\"cla.className!=null and cla.className!=''\">"
			+ "and LOCATE(#{cla.className},className)>0"
			+ "</if>"
			+ ")o limit  #{before} , #{after}"
			+ "</script>")
	List<Class> selectAll(@Param("before")int before, @Param("after")int after,@Param("cla")Class cla);
	
	//查询对象
	@Select("select * from class")
	List<Class> findAll();
	
	//保存数据
	@Insert("INSERT INTO class VALUES (null,#{className},#{classIntroduction},#{classPrice},#{classStart},#{classNumber},#{orderNumber},#{updateTime})")
	void saveClass(Class cla);
	
	//数据个数
	@Select("select count(1) from class")
	int count();
	
	//根据id查询对象
	@Select("select * from class where id=#{id}")
	Class selectById(@Param("id")int id);
	
	//根据主键id修改对象
	@Update("UPDATE class set className=#{className},classIntroduction=#{classIntroduction},classPrice=#{classPrice},classStart=#{classStart},classNumber=#{classNumber},orderNumber=#{orderNumber},"
			+ "updateTime=#{updateTime} where id=#{id}")
	void updateClassById(Class clas);
	
	//根据id删除对象
	@Delete("DELETE from class where id=#{id}")
	void deleteClassById(@Param("id")int id);
	
	//保存数据
	@Insert("INSERT INTO classOrder (id,userId,classId,userName,className,createTime) VALUES (null,null,null,#{userName},#{className},#{createTime})")
	void saveClassOrder(ClassOrder  classOrder);
	
	//根据用户名、课程名查询对象
	@Select("select * from classOrder where userName=#{userName} and className=#{className}")
	ClassOrder isHave(@Param("userName")String userName,@Param("className")String className);
	
	//根据主键id修改对象
	@Update("UPDATE class set orderNumber=orderNumber+1 where className=#{className}")
	void updateNuberByName(@Param("className")String className);
	
	//查询所有预定课程（分页）
	@Select("<script>"
			+ "SELECT o.* FROM (select * from classOrder where 1=1"
			+ "<if test=\"classOrder.className!=null and classOrder.className!=''\">"
			+ "and LOCATE(#{classOrder.className},className)>0"
			+ "</if>"
			+ "<if test=\"classOrder.userName!=null and classOrder.userName!=''\">"
			+ "and LOCATE(#{classOrder.userName},userName)>0"
			+ "</if>"
			+ ")o limit  #{before} , #{after}"
			+ "</script>")
	List<ClassOrder> selectOderAll(@Param("before")int before, @Param("after")int after,@Param("classOrder")ClassOrder classOrder);
	
	//数据个数
	@Select("select count(1) from classOrder")
	int orderCount();
}

