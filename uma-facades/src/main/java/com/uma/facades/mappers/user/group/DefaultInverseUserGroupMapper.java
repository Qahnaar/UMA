package com.uma.facades.mappers.user.group;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.permission.Permission;
import com.uma.domain.user.User;
import com.uma.domain.user.group.UserGroup;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;
import com.uma.facades.mappers.GenericMapper;

public class DefaultInverseUserGroupMapper implements GenericMapper<DefaultUserGroupDto, UserGroup> {

	private DefaultConverter<DefaultUserGroupDto, UserGroup> inverseUserGroupConverter;

	private DefaultConverter<DefaultUserDto, User> inverseUserConverter;

	private DefaultConverter<DefaultPermissionDto, Permission> inversePermissionConverter;

	@Override
	public UserGroup map(DefaultUserGroupDto source) {
		UserGroup userGroup = inverseUserGroupConverter.convert(source);
		userGroup.setPermissions(inversePermissionConverter.convertAll(source.getPermissions()));
		userGroup.setUsers(inverseUserConverter.convertAll(source.getUsers()));
		return userGroup;
	}

	@Override
	public Set<UserGroup> mapAll(Set<DefaultUserGroupDto> source) {
		return source.parallelStream().map(userGroup -> map(userGroup)).collect(Collectors.toSet());
	}

	public void setInverseUserGroupConverter(
			DefaultConverter<DefaultUserGroupDto, UserGroup> inverseUserGroupConverter) {
		this.inverseUserGroupConverter = inverseUserGroupConverter;
	}

	public void setInverseUserConverter(DefaultConverter<DefaultUserDto, User> inverseUserConverter) {
		this.inverseUserConverter = inverseUserConverter;
	}

	public void setInversePermissionConverter(
			DefaultConverter<DefaultPermissionDto, Permission> inversePermissionConverter) {
		this.inversePermissionConverter = inversePermissionConverter;
	}
}
