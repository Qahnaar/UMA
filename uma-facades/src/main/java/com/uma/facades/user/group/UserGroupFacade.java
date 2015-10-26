package com.uma.facades.user.group;

import com.uma.domain.user.group.UserGroup;
import com.uma.facades.GenericFacade;
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;
import com.uma.facades.populators.GenericPopulator;
import com.uma.services.user.group.UserGroupService;

public interface UserGroupFacade extends GenericFacade<DefaultUserGroupDto, Long> {

	void setUserGroupService(UserGroupService userGroupService);

	void setUserGroupPopulator(GenericPopulator<UserGroup, DefaultUserGroupDto> userGroupPopulator);

	void setInverseUserGroupPopulator(GenericPopulator<DefaultUserGroupDto, UserGroup> inverseUserGroupPopulator);
}
