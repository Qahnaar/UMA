package com.uma.facades.populators.permission;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.permission.Permission;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.populators.GenericPopulator;

public class DefaultPermissionPopulator implements GenericPopulator<Permission, DefaultPermissionDto> {

	private DefaultConverter<Permission, DefaultPermissionDto> defaultPermissionConverter;

	@Override
	public DefaultPermissionDto populate(Permission source) {
		return defaultPermissionConverter.convert(source);
	}

	@Override
	public Set<DefaultPermissionDto> populateAll(Set<Permission> source) {
		return source.parallelStream().map(permission -> populate(permission)).collect(Collectors.toSet());
	}

	public void setPermissionConverter(DefaultConverter<Permission, DefaultPermissionDto> permissionConverter) {
		this.defaultPermissionConverter = permissionConverter;
	}
}
