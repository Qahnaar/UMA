package com.uma.dao.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.uma.dao.UserGroupDao;
import com.uma.domain.UserGroup;

public class DefaultUserGroupDao implements UserGroupDao {

	private Set<UserGroup> cachedUserGroups;

	@Override
	public void create(UserGroup object) {
		cachedUserGroups.add(object);
	}

	@Override
	public UserGroup read(Long key) {
		return cachedUserGroups.parallelStream()
				.filter(userGroup -> key.equals(userGroup.getId()))
				.collect(Collectors.toSet()).iterator().next();
	}

	@Override
	public Collection<UserGroup> readAll() {
		return cachedUserGroups;
	}

	@Override
	public void update(UserGroup object) {
		delete(object);
		create(object);
	}

	@Override
	public void delete(UserGroup object) {
		Optional<UserGroup> objectOpt = Optional.ofNullable(object);
		cachedUserGroups.removeIf(userGroup -> userGroup.getId() == objectOpt
				.get().getId());
	}
}
