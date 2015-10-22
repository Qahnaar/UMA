package com.uma.facades.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uma.facades.PermissionFacade;
import com.uma.facades.UserFacade;
import com.uma.facades.UserGroupFacade;
import com.uma.facades.impl.DefaultPermissionFacade;
import com.uma.facades.impl.DefaultUserFacade;
import com.uma.facades.impl.DefaultUserGroupFacade;
import com.uma.services.PermissionService;
import com.uma.services.UserGroupService;
import com.uma.services.UserService;

@Configuration
public class UmaFacadesConfig {

	@Inject
	private UserService userService;

	@Inject
	private PermissionService permissionService;

	@Inject
	private UserGroupService userGroupService;

	@Bean
	public UserFacade getUserFacade() {
		UserFacade userFacade = new DefaultUserFacade();
		userFacade.setUserService(userService);
		return userFacade;
	}

	@Bean
	public PermissionFacade getPermissionFacade() {
		PermissionFacade permissionFacade = new DefaultPermissionFacade();
		permissionFacade.setPermissionService(permissionService);
		return permissionFacade;
	}

	@Bean
	public UserGroupFacade getUserGroupFacade() {
		UserGroupFacade userGroupFacade = new DefaultUserGroupFacade();
		userGroupFacade.setUserGroupService(userGroupService);
		return userGroupFacade;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}
}
