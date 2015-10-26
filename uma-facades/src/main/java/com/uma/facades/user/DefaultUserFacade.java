package com.uma.facades.user;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uma.domain.user.User;
import com.uma.facades.annotation.Facade;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.populators.GenericPopulator;
import com.uma.services.user.UserService;

@Facade
@Transactional
public class DefaultUserFacade implements UserFacade {

	private final static Logger LOG = LoggerFactory.getLogger(DefaultUserFacade.class);

	private UserService userService;

	private GenericPopulator<User, DefaultUserDto> userPopulator;

	private GenericPopulator<DefaultUserDto, User> inverseUserPopulator;

	@Override
	public void save(DefaultUserDto object) {
		LOG.debug("Saving user with email " + object.getEmail());
		userService.create(inverseUserPopulator.populate(object));
	}

	@Override
	public DefaultUserDto find(Long object) {
		LOG.debug("Finding user with email " + object);
		return userPopulator.populate(userService.read(object));
	}

	@Override
	public Set<DefaultUserDto> findAll() {
		LOG.debug("Finding all users");
		return userPopulator.populateAll(userService.readAll());
	}

	@Override
	public void merge(DefaultUserDto object) {
		LOG.debug("Merging user with email " + object.getEmail());
		userService.update(inverseUserPopulator.populate(object));
	}

	@Override
	public void remove(DefaultUserDto object) {
		LOG.debug("Removing user with email " + object.getEmail());
		userService.delete(inverseUserPopulator.populate(object));
	}

	@Override
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setUserPopulator(GenericPopulator<User, DefaultUserDto> userPopulator) {
		this.userPopulator = userPopulator;
	}

	@Override
	public void setInverseUserPopulator(GenericPopulator<DefaultUserDto, User> inverseUserPopulator) {
		this.inverseUserPopulator = inverseUserPopulator;
	}
}
