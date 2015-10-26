package com.uma.dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;

public abstract class DefaultGenericDao<T, V extends Serializable> implements GenericDao<T, V> {

	private SessionFactory sessionFactory;

	@Override
	public void create(T object) {
		sessionFactory.getCurrentSession().save(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T read(V key) {
		return (T) sessionFactory.getCurrentSession().get(getEntityClass(), key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<T> readAll() {
		return new HashSet<>(sessionFactory.getCurrentSession().createCriteria(getEntityClass()).list());
	}

	@Override
	public void update(T object) {
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void delete(T object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected abstract Class<T> getEntityClass();
}
