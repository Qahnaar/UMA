package com.uma.facades.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uma.domain.User;
import com.uma.facades.UserFacade;
import com.uma.facades.annotation.Facade;
import com.uma.services.UserService;

@Facade
public class DefaultUserFacade implements UserFacade {

	private final static Logger LOG = LoggerFactory.getLogger(DefaultUserFacade.class);

	private UserService userService;

	@Override
	public void save(User object) {
		LOG.debug("Saving user with email " + object.getEmail());
		userService.create(object);
	}

	@Override
	public User find(User object) {
		LOG.debug("Finding user with email " + object.getEmail());
		return userService.read(object.getEmail());
	}

	@Override
	public Set<User> findAll() {
		LOG.debug("Finding all users");
		return userService.readAll();
	}

	@Override
	public void merge(User object) {
		LOG.debug("Merging user with email " + object.getEmail());
		userService.update(object);
	}

	@Override
	public void remove(User object) {
		LOG.debug("Removing user with email " + object.getEmail());
		userService.delete(object);
	}

	@Override
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
