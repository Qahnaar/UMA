package com.uma.services.impl;

import java.util.Set;

import javax.inject.Inject;

import com.uma.dao.PermissionDao;
import com.uma.domain.Permission;
import com.uma.services.PermissionService;

public class DefaultPermissionService implements PermissionService {

	@Inject
	private PermissionDao permissionDao;

	@Override
	public void create(Permission object) {
		permissionDao.create(object);
	}

	@Override
	public Permission read(Long key) {
		return permissionDao.read(key);
	}

	@Override
	public Set<Permission> readAll() {
		return permissionDao.readAll();
	}

	@Override
	public void update(Permission object) {
		permissionDao.update(object);
	}

	@Override
	public void delete(Permission object) {
		permissionDao.delete(object);
	}
}
