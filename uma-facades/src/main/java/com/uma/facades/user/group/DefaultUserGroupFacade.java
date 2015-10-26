package com.uma.facades.user.group;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uma.domain.user.group.UserGroup;
import com.uma.facades.annotation.Facade;
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;
import com.uma.facades.populators.GenericPopulator;
import com.uma.services.user.group.UserGroupService;

@Facade
@Transactional
public class DefaultUserGroupFacade implements UserGroupFacade {

	private final static Logger LOG = LoggerFactory.getLogger(DefaultUserGroupFacade.class);

	private UserGroupService userGroupService;

	private GenericPopulator<UserGroup, DefaultUserGroupDto> userGroupPopulator;

	private GenericPopulator<DefaultUserGroupDto, UserGroup> inverseUserGroupPopulator;

	@Override
	public void save(DefaultUserGroupDto object) {
		LOG.debug("Saving userGroup with id " + object.getId());
		userGroupService.create(inverseUserGroupPopulator.populate(object));
	}

	@Override
	public DefaultUserGroupDto find(Long object) {
		LOG.debug("Finding userGroup with id " + object);
		return userGroupPopulator.populate(userGroupService.read(object));
	}

	@Override
	public Set<DefaultUserGroupDto> findAll() {
		LOG.debug("Finding all userGroups");
		return userGroupPopulator.populateAll(userGroupService.readAll());
	}

	@Override
	public void merge(DefaultUserGroupDto object) {
		LOG.debug("Merging userGroup with id " + object.getId());
		userGroupService.update(inverseUserGroupPopulator.populate(object));
	}

	@Override
	public void remove(DefaultUserGroupDto object) {
		LOG.debug("Removing userGroup with id " + object.getId());
		userGroupService.delete(inverseUserGroupPopulator.populate(object));
	}

	@Override
	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}

	@Override
	public void setUserGroupPopulator(GenericPopulator<UserGroup, DefaultUserGroupDto> userGroupPopulator) {
		this.userGroupPopulator = userGroupPopulator;
	}

	@Override
	public void setInverseUserGroupPopulator(
			GenericPopulator<DefaultUserGroupDto, UserGroup> inverseUserGroupPopulator) {
		this.inverseUserGroupPopulator = inverseUserGroupPopulator;
	}
}
