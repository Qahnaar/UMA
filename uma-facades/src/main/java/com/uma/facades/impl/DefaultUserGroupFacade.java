package com.uma.facades.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uma.domain.UserGroup;
import com.uma.facades.UserGroupFacade;
import com.uma.facades.annotation.Facade;
import com.uma.services.UserGroupService;

@Facade
public class DefaultUserGroupFacade implements UserGroupFacade {

	private final static Logger LOG = LoggerFactory.getLogger(DefaultUserGroupFacade.class);

	private UserGroupService userGroupService;

	@Override
	public void save(UserGroup object) {
		LOG.debug("Saving userGroup with id " + object.getId());
		userGroupService.create(object);
	}

	@Override
	public UserGroup find(Long object) {
		LOG.debug("Finding userGroup with id " + object);
		return userGroupService.read(object);
	}

	@Override
	public Set<UserGroup> findAll() {
		LOG.debug("Finding all userGroups");
		return userGroupService.readAll();
	}

	@Override
	public void merge(UserGroup object) {
		LOG.debug("Merging userGroup with id " + object.getId());
		userGroupService.update(object);
	}

	@Override
	public void remove(UserGroup object) {
		LOG.debug("Removing userGroup with id " + object.getId());
		userGroupService.delete(object);
	}

	@Override
	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}
}
