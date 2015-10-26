package com.uma.facades.dtos.user.group;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.uma.facades.dtos.GenericDto;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.util.FacadesConstants;

@Component
public class DefaultUserGroupDto extends GenericDto {

	private Long id;

	private Set<DefaultUserDto> users;

	private Set<DefaultPermissionDto> permissions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<DefaultUserDto> getUsers() {
		return users;
	}

	public void setUsers(Set<DefaultUserDto> users) {
		this.users = users;
	}

	public Set<DefaultPermissionDto> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<DefaultPermissionDto> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String getUri() {
		return FacadesConstants.URI.GROUPS_URI + id;
	}
}
