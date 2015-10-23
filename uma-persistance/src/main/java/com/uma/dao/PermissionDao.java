package com.uma.dao;

import org.hibernate.SessionFactory;

import com.uma.domain.Permission;

public interface PermissionDao extends GenericFacade<Permission, Long> {

	void setSessionFactory(SessionFactory sessionFactory);
}
