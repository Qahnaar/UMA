package com.uma.dao;

import org.hibernate.SessionFactory;

import com.uma.domain.User;

public interface UserDao extends GenericFacade<User, String> {
	
	void setSessionFactory(SessionFactory sessionFactory);
}
