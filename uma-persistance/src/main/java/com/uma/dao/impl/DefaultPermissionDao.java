package com.uma.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;

import com.uma.dao.PermissionDao;
import com.uma.domain.Permission;

public class DefaultPermissionDao implements PermissionDao {

	private SessionFactory sessionFactory;

	@Override
	public void create(Permission object) {
		sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public Permission read(Long key) {
		return (Permission) sessionFactory.getCurrentSession().get(Permission.class, key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Permission> readAll() {
		return new HashSet<>(sessionFactory.getCurrentSession().createCriteria(Permission.class).list());
	}

	@Override
	public void update(Permission object) {
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void delete(Permission object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
