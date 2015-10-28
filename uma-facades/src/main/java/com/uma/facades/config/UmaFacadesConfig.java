package com.uma.facades.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uma.domain.permission.Permission;
import com.uma.domain.user.User;
import com.uma.domain.user.group.UserGroup;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.converters.permission.DefaultInversePermissionConverter;
import com.uma.facades.converters.permission.DefaultPermissionConverter;
import com.uma.facades.converters.user.DefaultInverseUserConverter;
import com.uma.facades.converters.user.DefaultUserConverter;
import com.uma.facades.converters.user.group.DefaultInverseUserGroupConverter;
import com.uma.facades.converters.user.group.DefaultUserGroupConverter;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;
import com.uma.facades.mappers.permission.DefaultInversePermissionMapper;
import com.uma.facades.mappers.permission.DefaultPermissionMapper;
import com.uma.facades.mappers.user.DefaultInverseUserMapper;
import com.uma.facades.mappers.user.DefaultUserMapper;
import com.uma.facades.mappers.user.group.DefaultInverseUserGroupMapper;
import com.uma.facades.mappers.user.group.DefaultUserGroupMapper;
import com.uma.facades.permission.DefaultPermissionFacade;
import com.uma.facades.permission.PermissionFacade;
import com.uma.facades.user.DefaultUserFacade;
import com.uma.facades.user.UserFacade;
import com.uma.facades.user.group.DefaultUserGroupFacade;
import com.uma.facades.user.group.UserGroupFacade;
import com.uma.services.permission.PermissionService;
import com.uma.services.user.UserService;
import com.uma.services.user.group.UserGroupService;

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
		userFacade.setUserMapper(getUserPopulator());
		userFacade.setInverseUserMapper(getInverseUserPopulator());
		return userFacade;
	}

	@Bean
	public PermissionFacade getPermissionFacade() {
		PermissionFacade permissionFacade = new DefaultPermissionFacade();
		permissionFacade.setPermissionService(permissionService);
		permissionFacade.setPermissionMapper(getPermissionPopulator());
		permissionFacade.setInversePermissionMapper(getInversePermissionPopulator());
		return permissionFacade;
	}

	@Bean
	public UserGroupFacade getUserGroupFacade() {
		UserGroupFacade userGroupFacade = new DefaultUserGroupFacade();
		userGroupFacade.setUserGroupService(userGroupService);
		userGroupFacade.setUserGroupMapper(getUserGroupPopulator());
		userGroupFacade.setInverseUserGroupMapper(getInverseUserGroupPopulator());
		return userGroupFacade;
	}

	@Bean
	public DefaultConverter<UserGroup, DefaultUserGroupDto> getDefaultUserGroupConverter() {
		return new DefaultUserGroupConverter();
	}

	@Bean
	public DefaultConverter<DefaultUserGroupDto, UserGroup> getDefaultInverseUserGroupConverter() {
		return new DefaultInverseUserGroupConverter();
	}

	@Bean
	public DefaultConverter<User, DefaultUserDto> getDefaultUserConverter() {
		return new DefaultUserConverter();
	}

	@Bean
	public DefaultConverter<DefaultUserDto, User> getDefaultInverseUserConverter() {
		return new DefaultInverseUserConverter();
	}

	@Bean
	public DefaultConverter<Permission, DefaultPermissionDto> getDefaultPermissionConverter() {
		return new DefaultPermissionConverter();
	}

	@Bean
	public DefaultConverter<DefaultPermissionDto, Permission> getDefaultInversePermissionConverter() {
		return new DefaultInversePermissionConverter();
	}

	@Bean
	public DefaultUserMapper getUserPopulator() {
		DefaultUserMapper userPopulator = new DefaultUserMapper();
		userPopulator.setDefaultUserConverter(getDefaultUserConverter());
		return userPopulator;
	}

	@Bean
	public DefaultPermissionMapper getPermissionPopulator() {
		DefaultPermissionMapper userPopulator = new DefaultPermissionMapper();
		userPopulator.setPermissionConverter(getDefaultPermissionConverter());
		return userPopulator;
	}

	@Bean
	public DefaultUserGroupMapper getUserGroupPopulator() {
		DefaultUserGroupMapper userGroupPopulator = new DefaultUserGroupMapper();
		userGroupPopulator.setUserGroupConverter(getDefaultUserGroupConverter());
		userGroupPopulator.setUserConverter(getDefaultUserConverter());
		userGroupPopulator.setPermissionConverter(getDefaultPermissionConverter());
		return userGroupPopulator;
	}

	@Bean
	public DefaultInverseUserMapper getInverseUserPopulator() {
		DefaultInverseUserMapper userPopulator = new DefaultInverseUserMapper();
		userPopulator.setDefaultInverseUserConverter(getDefaultInverseUserConverter());
		return userPopulator;
	}

	@Bean
	public DefaultInversePermissionMapper getInversePermissionPopulator() {
		DefaultInversePermissionMapper userPopulator = new DefaultInversePermissionMapper();
		userPopulator.setDefaultInversePermissionConverter(getDefaultInversePermissionConverter());
		return userPopulator;
	}

	@Bean
	public DefaultInverseUserGroupMapper getInverseUserGroupPopulator() {
		DefaultInverseUserGroupMapper userGroupPopulator = new DefaultInverseUserGroupMapper();
		userGroupPopulator.setInverseUserGroupConverter(getDefaultInverseUserGroupConverter());
		userGroupPopulator.setInverseUserConverter(getDefaultInverseUserConverter());
		userGroupPopulator.setInversePermissionConverter(getDefaultInversePermissionConverter());
		return userGroupPopulator;
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
