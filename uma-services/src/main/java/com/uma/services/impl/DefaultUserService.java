package com.uma.services.impl;

import java.util.Set;

import javax.inject.Inject;

import com.uma.dao.UserDao;
import com.uma.domain.User;
import com.uma.services.UserService;

public class DefaultUserService implements UserService {

	@Inject
	private UserDao userDao;

	@Override
	public void create(User object) {
		userDao.create(object);
	}

	@Override
	public User read(String key) {
		return userDao.read(key);
	}

	@Override
	public Set<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public void update(User object) {
		userDao.update(object);
	}

	@Override
	public void delete(User object) {
		userDao.delete(object);
	}
}
