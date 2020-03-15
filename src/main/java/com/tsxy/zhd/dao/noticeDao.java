package com.tsxy.zhd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.tsxy.zhd.vo.Notice;

@Mapper
@Component
public interface noticeDao {
	//查询对象（默认只有一个）
	@Select("<script>"
			+ "SELECT o.* FROM (select * from notice where 1=1"
			+ "<if test=\"notice.title!=null and notice.title!=''\">"
			+ "and LOCATE(#{notice.title},title)>0"
			+ "</if>"
			+ ")o limit  #{before} , #{after}"
			+ "</script>")
	List<Notice> selectAll(@Param("before")int before, @Param("after")int after,@Param("notice")Notice notice);
	
	//保存数据
	@Insert("INSERT INTO notice VALUES (null,#{title},#{body},#{createTime})")
	void saveNotice(Notice notice);
	
	//数据个数
	@Select("select count(1) from notice")
	int count();
	
	//根据id查询对象
	@Select("select * from notice where id=#{id}")
	Notice selectById(@Param("id")int id);
	
	//根据主键id修改对象
	@Update("UPDATE notice set title=#{title},body=#{body},"
			+ "createTime=#{createTime} where id=#{id}")
	void updateNoticeById(Notice notice);
	
	//根据id删除对象
	@Delete("DELETE from notice where id=#{id}")
	void deleteNoticeById(@Param("id")int id);
	
	//查询所有对象
	@Select("select * from notice order by createTime desc")
	List<Notice> selectNotices();
}
