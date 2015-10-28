package com.uma.facades.user.group;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uma.domain.user.group.UserGroup;
import com.uma.facades.annotation.Facade;
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;
import com.uma.facades.mappers.GenericMapper;
import com.uma.services.user.group.UserGroupService;

@Facade
@Transactional
public class DefaultUserGroupFacade implements UserGroupFacade {

	private final static Logger LOG = LoggerFactory.getLogger(DefaultUserGroupFacade.class);

	private UserGroupService userGroupService;

	private GenericMapper<UserGroup, DefaultUserGroupDto> userGroupMapper;

	private GenericMapper<DefaultUserGroupDto, UserGroup> inverseUserGroupMapper;

	@Override
	public void save(DefaultUserGroupDto object) {
		LOG.debug("Saving userGroup with id " + object.getId());
		userGroupService.create(inverseUserGroupMapper.map(object));
	}

	@Override
	public DefaultUserGroupDto find(Long object) {
		LOG.debug("Finding userGroup with id " + object);
		return userGroupMapper.map(userGroupService.read(object));
	}

	@Override
	public Set<DefaultUserGroupDto> findAll() {
		LOG.debug("Finding all userGroups");
		return userGroupMapper.mapAll(userGroupService.readAll());
	}

	@Override
	public void merge(DefaultUserGroupDto object) {
		LOG.debug("Merging userGroup with id " + object.getId());
		userGroupService.update(inverseUserGroupMapper.map(object));
	}

	@Override
	public void remove(DefaultUserGroupDto object) {
		LOG.debug("Removing userGroup with id " + object.getId());
		userGroupService.delete(inverseUserGroupMapper.map(object));
	}

	@Override
	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}

	@Override
	public void setUserGroupMapper(GenericMapper<UserGroup, DefaultUserGroupDto> userGroupMapper) {
		this.userGroupMapper = userGroupMapper;
	}

	@Override
	public void setInverseUserGroupMapper(
			GenericMapper<DefaultUserGroupDto, UserGroup> inverseUserGroupMapper) {
		this.inverseUserGroupMapper = inverseUserGroupMapper;
	}
}
