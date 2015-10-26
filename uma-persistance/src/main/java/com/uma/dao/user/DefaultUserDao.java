package com.uma.dao.user;

import com.uma.dao.DefaultGenericDao;
import com.uma.domain.user.User;

public class DefaultUserDao extends DefaultGenericDao<User, Long> implements UserDao {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}
}
