package com.uma.facades.mappers.permission;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.permission.Permission;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.mappers.GenericMapper;

public class DefaultInversePermissionMapper implements GenericMapper<DefaultPermissionDto, Permission> {

	private DefaultConverter<DefaultPermissionDto, Permission> defaultInversePermissionConverter;

	@Override
	public Permission map(DefaultPermissionDto source) {
		return defaultInversePermissionConverter.convert(source);
	}

	@Override
	public Set<Permission> mapAll(Set<DefaultPermissionDto> source) {
		return source.parallelStream().map(permission -> map(permission)).collect(Collectors.toSet());
	}

	public void setDefaultInversePermissionConverter(
			DefaultConverter<DefaultPermissionDto, Permission> defaultInversePermissionConverter) {
		this.defaultInversePermissionConverter = defaultInversePermissionConverter;
	}
}
