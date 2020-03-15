package com.tsxy.zhd.vo;
//课程预定
public class ClassOrder {
	private Integer id;//主键
	private int userId;//用户id
	private String userName;//用户名
	private int classId;//课程id
	private String className;//课程名称
	private String createTime;//创建时间
	public ClassOrder() {
		super();
	}
	
	public ClassOrder(Integer id, int userId, String userName, int classId, String className, String createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.classId = classId;
		this.className = className;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
