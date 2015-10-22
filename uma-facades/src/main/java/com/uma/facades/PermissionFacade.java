package com.uma.facades;

import com.uma.domain.Permission;
import com.uma.services.PermissionService;

public interface PermissionFacade extends GenericFacade<Permission, Long> {

	void setPermissionService(PermissionService permissionService);
}
