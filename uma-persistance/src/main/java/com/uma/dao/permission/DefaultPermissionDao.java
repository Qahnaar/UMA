package com.uma.dao.permission;

import com.uma.dao.DefaultGenericDao;
import com.uma.domain.permission.Permission;

public class DefaultPermissionDao extends DefaultGenericDao<Permission, Long> implements PermissionDao {

	@Override
	protected Class<Permission> getEntityClass() {
		return Permission.class;
	}
}
