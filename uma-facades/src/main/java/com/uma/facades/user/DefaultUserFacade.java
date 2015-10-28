package com.uma.facades.user;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uma.domain.user.User;
import com.uma.facades.annotation.Facade;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.mappers.GenericMapper;
import com.uma.services.user.UserService;

@Facade
@Transactional
public class DefaultUserFacade implements UserFacade {

	private final static Logger LOG = LoggerFactory.getLogger(DefaultUserFacade.class);

	private UserService userService;

	private GenericMapper<User, DefaultUserDto> userMapper;

	private GenericMapper<DefaultUserDto, User> inverseUserMapper;

	@Override
	public void save(DefaultUserDto object) {
		LOG.debug("Saving user with email " + object.getEmail());
		userService.create(inverseUserMapper.map(object));
	}

	@Override
	public DefaultUserDto find(Long object) {
		LOG.debug("Finding user with email " + object);
		return userMapper.map(userService.read(object));
	}

	@Override
	public Set<DefaultUserDto> findAll() {
		LOG.debug("Finding all users");
		return userMapper.mapAll(userService.readAll());
	}

	@Override
	public void merge(DefaultUserDto object) {
		LOG.debug("Merging user with email " + object.getEmail());
		userService.update(inverseUserMapper.map(object));
	}

	@Override
	public void remove(DefaultUserDto object) {
		LOG.debug("Removing user with email " + object.getEmail());
		userService.delete(inverseUserMapper.map(object));
	}

	@Override
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setUserMapper(GenericMapper<User, DefaultUserDto> userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void setInverseUserMapper(GenericMapper<DefaultUserDto, User> inverseUserMapper) {
		this.inverseUserMapper = inverseUserMapper;
	}
}
