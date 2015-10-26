package com.uma.facades.populators.user.group;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.permission.Permission;
import com.uma.domain.user.User;
import com.uma.domain.user.group.UserGroup;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;
import com.uma.facades.populators.GenericPopulator;

public class DefaultUserGroupPopulator implements GenericPopulator<UserGroup, DefaultUserGroupDto> {

	private DefaultConverter<UserGroup, DefaultUserGroupDto> userGroupConverter;

	private DefaultConverter<User, DefaultUserDto> userConverter;

	private DefaultConverter<Permission, DefaultPermissionDto> permissionConverter;

	@Override
	public DefaultUserGroupDto populate(UserGroup source) {
		DefaultUserGroupDto userGroupDto = userGroupConverter.convert(source);
		userGroupDto.setPermissions(permissionConverter.convertAll(source.getPermissions()));
		userGroupDto.setUsers(userConverter.convertAll(source.getUsers()));

		return userGroupDto;
	}

	@Override
	public Set<DefaultUserGroupDto> populateAll(Set<UserGroup> source) {
		return source.parallelStream().map(userGroup -> populate(userGroup)).collect(Collectors.toSet());
	}

	public void setUserConverter(DefaultConverter<User, DefaultUserDto> userConverter) {
		this.userConverter = userConverter;
	}

	public void setPermissionConverter(DefaultConverter<Permission, DefaultPermissionDto> permissionConverter) {
		this.permissionConverter = permissionConverter;
	}

	public void setUserGroupConverter(DefaultConverter<UserGroup, DefaultUserGroupDto> userGroupConverter) {
		this.userGroupConverter = userGroupConverter;
	}
}
