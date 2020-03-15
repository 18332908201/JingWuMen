package com.tsxy.zhd.vo;
//公告
public class Notice {
	private Integer id;//主键id
	private String title;//标题
	private String body;//内容主体
	private String createTime;//创建时间
	public Notice() {
		super();
	}
	public Notice(Integer id, String title, String body, String createTime) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
