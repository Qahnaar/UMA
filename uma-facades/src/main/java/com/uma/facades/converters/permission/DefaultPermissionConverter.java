package com.uma.facades.converters.permission;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.permission.Permission;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.permission.DefaultPermissionDto;

public class DefaultPermissionConverter implements DefaultConverter<Permission, DefaultPermissionDto> {

	@Override
	public DefaultPermissionDto convert(Permission permission) {
		DefaultPermissionDto permissionDto = new DefaultPermissionDto();

		permissionDto.setId(permission.getId());
		permissionDto.setLocation(permission.getLocation());
		permissionDto.setPermissionType(permission.getPermissionType().toString());

		return permissionDto;
	}

	@Override
	public Set<DefaultPermissionDto> convertAll(Collection<Permission> sourceCollection) {
		return sourceCollection.parallelStream().map(permission -> convert(permission)).collect(Collectors.toSet());
	}
}
