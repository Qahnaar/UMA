package com.uma.dao.impl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.uma.dao.UserDao;
import com.uma.domain.User;

public class DefaultUserDao implements UserDao {

	private Set<User> cachedUsers;

	@Override
	public void create(User object) {
		cachedUsers.add(object);
	}

	@Override
	public User read(String key) {
		return cachedUsers.parallelStream().filter(user -> key.equals(user.getEmail())).collect(Collectors.toSet())
				.iterator().next();
	}

	@Override
	public Set<User> readAll() {
		return cachedUsers;
	}

	@Override
	public void update(User object) {
		delete(object);
		create(object);
	}

	@Override
	public void delete(User object) {
		Optional<User> objectOpt = Optional.ofNullable(object);
		cachedUsers.removeIf(user -> user.getEmail().equals(objectOpt.get().getEmail()));
	}
}
