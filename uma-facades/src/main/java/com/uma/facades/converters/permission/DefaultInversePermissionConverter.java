package com.uma.facades.converters.permission;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.permission.Permission;
import com.uma.domain.permission.PermissionType;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.permission.DefaultPermissionDto;

public class DefaultInversePermissionConverter implements DefaultConverter<DefaultPermissionDto, Permission> {

	@Override
	public Permission convert(DefaultPermissionDto permissionDto) {
		Permission permission = new Permission();

		permission.setId(permissionDto.getId());
		permission.setLocation(permissionDto.getLocation());
		permission.setPermissionType(PermissionType.valueOf(permissionDto.getPermissionType()));

		return permission;
	}

	@Override
	public Set<Permission> convertAll(Collection<DefaultPermissionDto> sourceCollection) {
		return sourceCollection.parallelStream().map(permissionDto -> convert(permissionDto))
				.collect(Collectors.toSet());
	}
}
