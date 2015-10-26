package com.uma.facades.converters.user.group;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.user.group.UserGroup;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;

public class DefaultInverseUserGroupConverter implements DefaultConverter<DefaultUserGroupDto, UserGroup> {

	@Override
	public UserGroup convert(DefaultUserGroupDto userGroupDto) {
		UserGroup userGroup = new UserGroup();

		userGroup.setId(userGroupDto.getId());

		return userGroup;
	}

	@Override
	public Set<UserGroup> convertAll(Collection<DefaultUserGroupDto> userGroups) {
		return userGroups.parallelStream().map(userGroupDto -> convert(userGroupDto)).collect(Collectors.toSet());
	}
}
