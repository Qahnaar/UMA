package com.uma.dao.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.uma.dao.PermissionDao;
import com.uma.domain.Permission;

public class DefaultPermissionDao implements PermissionDao {

	private Set<Permission> cachedPermissions;

	@Override
	public void create(Permission object) {
		cachedPermissions.add(object);
	}

	@Override
	public Permission read(Long key) {
		return cachedPermissions.parallelStream()
				.filter(permission -> key.equals(permission.getId()))
				.collect(Collectors.toSet()).iterator().next();
	}

	@Override
	public Collection<Permission> readAll() {
		return cachedPermissions;
	}

	@Override
	public void update(Permission object) {
		delete(object);
		create(object);
	}

	@Override
	public void delete(Permission object) {
		Optional<Permission> objectOpt = Optional.ofNullable(object);
		cachedPermissions
				.removeIf(permission -> permission.getId() == objectOpt.get()
						.getId());
	}
}
