package com.uma.facades.converters.user.group;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.user.group.UserGroup;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;

public class DefaultUserGroupConverter implements DefaultConverter<UserGroup, DefaultUserGroupDto> {

	@Override
	public DefaultUserGroupDto convert(UserGroup userGroup) {
		DefaultUserGroupDto userGroupDto = new DefaultUserGroupDto();

		userGroupDto.setId(userGroup.getId());

		return userGroupDto;
	}

	@Override
	public Set<DefaultUserGroupDto> convertAll(Collection<UserGroup> userGroups) {
		return userGroups.parallelStream().map(userGroup -> convert(userGroup)).collect(Collectors.toSet());
	}
}
