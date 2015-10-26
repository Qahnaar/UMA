package com.uma.services.permission;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uma.dao.permission.PermissionDao;
import com.uma.domain.permission.Permission;

@Service("permissionService")
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
