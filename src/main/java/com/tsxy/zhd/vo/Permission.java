package com.tsxy.zhd.vo;
//权限信息

import java.util.List;

public class Permission {
	private Integer id;//主键
	private String name;//权限名称
	private List<Role> roles;//角色集合
	public Permission() {
		super();
	}
	public Permission(Integer id, String name, List<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
					
}
