package com.uma.services.impl;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uma.dao.UserGroupDao;
import com.uma.domain.UserGroup;
import com.uma.services.UserGroupService;

@Service("userGroupService")
public class DefaultUserGroupService implements UserGroupService {

	@Inject
	private UserGroupDao userGroupDao;

	@Override
	public void create(UserGroup object) {
		userGroupDao.create(object);
	}

	@Override
	public UserGroup read(Long key) {
		return userGroupDao.read(key);
	}

	@Override
	public Set<UserGroup> readAll() {
		return userGroupDao.readAll();
	}

	@Override
	public void update(UserGroup object) {
		userGroupDao.update(object);
	}

	@Override
	public void delete(UserGroup object) {
		userGroupDao.delete(object);
	}
}
