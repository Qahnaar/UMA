package com.uma.facades.mappers.permission;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.permission.Permission;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.mappers.GenericMapper;

public class DefaultPermissionMapper implements GenericMapper<Permission, DefaultPermissionDto> {

	private DefaultConverter<Permission, DefaultPermissionDto> defaultPermissionConverter;

	@Override
	public DefaultPermissionDto map(Permission source) {
		return defaultPermissionConverter.convert(source);
	}

	@Override
	public Set<DefaultPermissionDto> mapAll(Set<Permission> source) {
		return source.parallelStream().map(permission -> map(permission)).collect(Collectors.toSet());
	}

	public void setPermissionConverter(DefaultConverter<Permission, DefaultPermissionDto> permissionConverter) {
		this.defaultPermissionConverter = permissionConverter;
	}
}
