package com.uma.facades;

import com.uma.domain.UserGroup;
import com.uma.services.UserGroupService;

public interface UserGroupFacade extends GenericFacade<UserGroup> {

	void setUserGroupService(UserGroupService userGroupService);
}
