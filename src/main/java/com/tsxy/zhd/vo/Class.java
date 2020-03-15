package com.tsxy.zhd.vo;
//课程
public class Class {
	private Integer id;//主键
	private String className;//课程名称
	private String classIntroduction;//课程介绍
	private String classPrice;//课程价格
	private String classStart;//课程开始时间
	private int classNumber;//课程人数
	private int orderNumber;//已预定课程人数
	private String updateTime;//修改时间
	public Class() {
		super();
	}
	public Class(Integer id, String className, String classIntroduction, String classPrice, String classStart,
			int classNumber, int orderNumber, String updateTime) {
		super();
		this.id = id;
		this.className = className;
		this.classIntroduction = classIntroduction;
		this.classPrice = classPrice;
		this.classStart = classStart;
		this.classNumber = classNumber;
		this.orderNumber = orderNumber;
		this.updateTime = updateTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassIntroduction() {
		return classIntroduction;
	}
	public void setClassIntroduction(String classIntroduction) {
		this.classIntroduction = classIntroduction;
	}
	public String getClassPrice() {
		return classPrice;
	}
	public void setClassPrice(String classPrice) {
		this.classPrice = classPrice;
	}
	public String getClassStart() {
		return classStart;
	}
	public void setClassStart(String classStart) {
		this.classStart = classStart;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
