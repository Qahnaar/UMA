package com.uma.facades.permission;

import com.uma.domain.permission.Permission;
import com.uma.facades.GenericFacade;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.mappers.GenericMapper;
import com.uma.services.permission.PermissionService;

public interface PermissionFacade extends GenericFacade<DefaultPermissionDto, Long> {

	void setPermissionService(PermissionService permissionService);

	void setPermissionMapper(GenericMapper<Permission, DefaultPermissionDto> permissionMapper);

	void setInversePermissionMapper(GenericMapper<DefaultPermissionDto, Permission> inversePermissionMapper);
}
