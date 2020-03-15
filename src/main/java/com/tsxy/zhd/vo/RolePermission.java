package com.tsxy.zhd.vo;


//角色权限信息
public class RolePermission {
	private Integer roleId;//角色id
	private int permissionId;//权限id

	private String permissionIds;//权限id
	public RolePermission() {
		super();
	}
	
	public RolePermission(Integer roleId, int permissionId, String permissionIds) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
		this.permissionIds = permissionIds;
	}

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}
	
}
