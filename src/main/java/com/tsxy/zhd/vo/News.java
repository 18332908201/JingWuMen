package com.tsxy.zhd.vo;
//新闻
public class News {
	private String id;//主键
	private String development;//发展
	private String scale;//规模
	private String now;//现状
	private String fitnessKnowledge;//健身知识
	private String createTime;//创建时间
	public News() {
		super();
	}
	
	public News(String id, String development, String scale, String now, String fitnessKnowledge, String createTime) {
		super();
		this.id = id;
		this.development = development;
		this.scale = scale;
		this.now = now;
		this.fitnessKnowledge = fitnessKnowledge;
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDevelopment() {
		return development;
	}
	public void setDevelopment(String development) {
		this.development = development;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}
	public String getFitnessKnowledge() {
		return fitnessKnowledge;
	}
	public void setFitnessKnowledge(String fitnessKnowledge) {
		this.fitnessKnowledge = fitnessKnowledge;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
