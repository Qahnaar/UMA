package com.uma.facades.populators.permission;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.permission.Permission;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.populators.GenericPopulator;

public class DefaultInversePermissionPopulator implements GenericPopulator<DefaultPermissionDto, Permission> {

	private DefaultConverter<DefaultPermissionDto, Permission> defaultInversePermissionConverter;

	@Override
	public Permission populate(DefaultPermissionDto source) {
		return defaultInversePermissionConverter.convert(source);
	}

	@Override
	public Set<Permission> populateAll(Set<DefaultPermissionDto> source) {
		return source.parallelStream().map(permission -> populate(permission)).collect(Collectors.toSet());
	}

	public void setDefaultInversePermissionConverter(
			DefaultConverter<DefaultPermissionDto, Permission> defaultInversePermissionConverter) {
		this.defaultInversePermissionConverter = defaultInversePermissionConverter;
	}
}
