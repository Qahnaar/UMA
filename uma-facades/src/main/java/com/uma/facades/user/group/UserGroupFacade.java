package com.uma.facades.user.group;

import com.uma.domain.user.group.UserGroup;
import com.uma.facades.GenericFacade;
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;
import com.uma.facades.mappers.GenericMapper;
import com.uma.services.user.group.UserGroupService;

public interface UserGroupFacade extends GenericFacade<DefaultUserGroupDto, Long> {

	void setUserGroupService(UserGroupService userGroupService);

	void setUserGroupMapper(GenericMapper<UserGroup, DefaultUserGroupDto> userGroupMapper);

	void setInverseUserGroupMapper(GenericMapper<DefaultUserGroupDto, UserGroup> inverseUserGroupMapper);
}
