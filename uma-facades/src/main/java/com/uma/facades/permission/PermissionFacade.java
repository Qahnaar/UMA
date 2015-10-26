package com.uma.facades.permission;

import com.uma.domain.permission.Permission;
import com.uma.facades.GenericFacade;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.populators.GenericPopulator;
import com.uma.services.permission.PermissionService;

public interface PermissionFacade extends GenericFacade<DefaultPermissionDto, Long> {

	void setPermissionService(PermissionService permissionService);

	void setPermissionPopulator(GenericPopulator<Permission, DefaultPermissionDto> permissionPopulator);

	void setInversePermissionPopulator(GenericPopulator<DefaultPermissionDto, Permission> inversePermissionPopulator);
}
