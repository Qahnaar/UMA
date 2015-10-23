package com.uma.dao;

import org.hibernate.SessionFactory;

import com.uma.domain.UserGroup;

public interface UserGroupDao extends GenericFacade<UserGroup, Long> {

	void setSessionFactory(SessionFactory sessionFactory);
}
