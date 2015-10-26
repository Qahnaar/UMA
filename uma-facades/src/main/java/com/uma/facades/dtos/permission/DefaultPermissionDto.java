package com.uma.facades.dtos.permission;

import com.uma.facades.dtos.GenericDto;
import com.uma.facades.util.FacadesConstants;

public class DefaultPermissionDto extends GenericDto {

	private Long id;

	private String permissionType;

	private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String getUri() {
		return FacadesConstants.URI.PERMISSIONS_URI + id;
	}
}
