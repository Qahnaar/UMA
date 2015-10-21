package com.uma.domain;

public class Permission {

	private long id;
	
	private PermissionType permissionType;
	
	private String location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public PermissionType getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(PermissionType permissionType) {
		this.permissionType = permissionType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
