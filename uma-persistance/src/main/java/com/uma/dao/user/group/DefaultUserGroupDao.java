package com.uma.dao.user.group;

import com.uma.dao.DefaultGenericDao;
import com.uma.domain.user.group.UserGroup;

public class DefaultUserGroupDao extends DefaultGenericDao<UserGroup, Long> implements UserGroupDao {

	@Override
	protected Class<UserGroup> getEntityClass() {
		return UserGroup.class;
	}
}
