package com.uma.services.user;

import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.uma.dao.user.UserDao;
import com.uma.domain.user.User;

@Service("userService")
public class DefaultUserService implements UserService {

	@Inject
	private UserDao userDao;

	@Override
	public void create(User object) {
		userDao.create(object);
	}

	@Override
	public User read(Long key) {
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
