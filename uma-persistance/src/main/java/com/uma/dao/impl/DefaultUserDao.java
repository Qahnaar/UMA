package com.uma.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;

import com.uma.dao.UserDao;
import com.uma.domain.User;

public class DefaultUserDao implements UserDao {

	private SessionFactory sessionFactory;

	@Override
	public void create(User object) {
		sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public User read(String key) {
		return (User) sessionFactory.getCurrentSession().get(User.class, key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<User> readAll() {
		return new HashSet<>(sessionFactory.getCurrentSession().createCriteria(User.class).list());
	}

	@Override
	public void update(User object) {
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void delete(User object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
