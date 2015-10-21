package com.uma.facades.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uma.facades.PermissionFacade;
import com.uma.facades.UserFacade;
import com.uma.facades.UserGroupFacade;
import com.uma.facades.impl.DefaultPermissionFacade;
import com.uma.facades.impl.DefaultUserFacade;
import com.uma.facades.impl.DefaultUserGroupFacade;
import com.uma.services.impl.DefaultPermissionService;
import com.uma.services.impl.DefaultUserGroupService;
import com.uma.services.impl.DefaultUserService;

@Configuration
public class UmaFacadesConfig {

	@Bean
	public UserFacade getUserFacade() {
		UserFacade userFacade = new DefaultUserFacade();
		userFacade.setUserService(new DefaultUserService());
		return userFacade;
	}

	@Bean
	public PermissionFacade getPermissionFacade() {
		PermissionFacade permissionFacade = new DefaultPermissionFacade();
		permissionFacade.setPermissionService(new DefaultPermissionService());
		return permissionFacade;
	}

	@Bean
	public UserGroupFacade getUserGroupFacade() {
		UserGroupFacade userGroupFacade = new DefaultUserGroupFacade();
		userGroupFacade.setUserGroupService(new DefaultUserGroupService());
		return userGroupFacade;
	}
}
