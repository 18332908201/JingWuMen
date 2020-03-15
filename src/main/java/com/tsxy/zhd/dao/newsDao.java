package com.tsxy.zhd.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.tsxy.zhd.vo.News;

@Mapper
@Component
public interface newsDao {
	//查询对象（默认只有一个）
	@Select("SELECT * FROM news")
	News findnews();
	@Update("UPDATE news set development=#{development},scale=#{scale},now=#{now},fitnessKnowledge=#{fitnessKnowledge},"
			+ "createTime=#{createTime} where id=#{id}")
	//根据主键id修改对象
	void updateNewsById(News news);
}
