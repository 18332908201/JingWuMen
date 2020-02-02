package com.tsxy.zhd.vo;

import java.util.List;

//角色信息
public class Role {
	private Integer id;//主键
	private String role;//角色
	private List<User> users;//用户集合
	private List<Permission> permissions;//权限集合
	public Role() {
		super();
	}
	public Role(Integer id, String role, List<User> users, List<Permission> permissions) {
		super();
		this.id = id;
		this.role = role;
		this.users = users;
		this.permissions = permissions;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
