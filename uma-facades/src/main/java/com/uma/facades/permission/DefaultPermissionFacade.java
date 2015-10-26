package com.uma.facades.permission;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uma.domain.permission.Permission;
import com.uma.facades.annotation.Facade;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.populators.GenericPopulator;
import com.uma.services.permission.PermissionService;

@Facade
@Transactional
public class DefaultPermissionFacade implements PermissionFacade {

	private final static Logger LOG = LoggerFactory.getLogger(DefaultPermissionFacade.class);

	private PermissionService permissionService;

	private GenericPopulator<Permission, DefaultPermissionDto> permissionPopulator;

	private GenericPopulator<DefaultPermissionDto, Permission> inversePermissionPopulator;

	@Override
	public void save(DefaultPermissionDto object) {
		LOG.debug("Saving permission with id " + object.getId());
		permissionService.create(inversePermissionPopulator.populate(object));
	}

	@Override
	public DefaultPermissionDto find(Long object) {
		LOG.debug("Finding permission with id " + object);
		return permissionPopulator.populate(permissionService.read(object));
	}

	@Override
	public Set<DefaultPermissionDto> findAll() {
		LOG.debug("Finding all permissions");
		return permissionPopulator.populateAll(permissionService.readAll());
	}

	@Override
	public void merge(DefaultPermissionDto object) {
		LOG.debug("Merging permission with id " + object.getId());
		permissionService.update(inversePermissionPopulator.populate(object));
	}

	@Override
	public void remove(DefaultPermissionDto object) {
		LOG.debug("Removing permission with id " + object.getId());
		permissionService.delete(inversePermissionPopulator.populate(object));
	}

	@Override
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Override
	public void setPermissionPopulator(GenericPopulator<Permission, DefaultPermissionDto> permissionPopulator) {
		this.permissionPopulator = permissionPopulator;
	}

	@Override
	public void setInversePermissionPopulator(
			GenericPopulator<DefaultPermissionDto, Permission> inversePermissionPopulator) {
		this.inversePermissionPopulator = inversePermissionPopulator;
	}

}
