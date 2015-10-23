package com.uma.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;

import com.uma.dao.UserGroupDao;
import com.uma.domain.UserGroup;

public class DefaultUserGroupDao implements UserGroupDao {

	private SessionFactory sessionFactory;

	@Override
	public void create(UserGroup object) {
		sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public UserGroup read(Long key) {
		return (UserGroup) sessionFactory.getCurrentSession().get(UserGroup.class, key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<UserGroup> readAll() {
		return new HashSet<>(sessionFactory.getCurrentSession().createCriteria(UserGroup.class).list());
	}

	@Override
	public void update(UserGroup object) {
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void delete(UserGroup object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
