package com.uma.facades;

import com.uma.domain.UserGroup;
import com.uma.services.UserGroupService;

public interface UserGroupFacade extends GenericFacade<UserGroup, Long> {

	void setUserGroupService(UserGroupService userGroupService);
}
