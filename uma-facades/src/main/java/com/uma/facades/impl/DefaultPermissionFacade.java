package com.uma.facades.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uma.domain.Permission;
import com.uma.facades.PermissionFacade;
import com.uma.facades.annotation.Facade;
import com.uma.services.PermissionService;

@Facade
public class DefaultPermissionFacade implements PermissionFacade {

	private final static Logger LOG = LoggerFactory
			.getLogger(DefaultPermissionFacade.class);

	private PermissionService permissionService;

	@Override
	public void save(Permission object) {
		LOG.debug("Saving permission with id " + object.getId());
		permissionService.create(object);
	}

	@Override
	public Permission find(Long object) {
		LOG.debug("Finding permission with id " + object);
		return permissionService.read(object);
	}

	@Override
	public Set<Permission> findAll() {
		LOG.debug("Finding all permissions");
		return permissionService.readAll();
	}

	@Override
	public void merge(Permission object) {
		LOG.debug("Merging permission with id " + object.getId());
		permissionService.update(object);
	}

	@Override
	public void remove(Permission object) {
		LOG.debug("Removing permission with id " + object.getId());
		permissionService.delete(object);
	}

	@Override
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
}
