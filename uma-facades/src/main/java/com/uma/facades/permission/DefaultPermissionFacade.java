package com.uma.facades.permission;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uma.domain.permission.Permission;
import com.uma.facades.annotation.Facade;
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.mappers.GenericMapper;
import com.uma.services.permission.PermissionService;

@Facade
@Transactional
public class DefaultPermissionFacade implements PermissionFacade {

	private final static Logger LOG = LoggerFactory.getLogger(DefaultPermissionFacade.class);

	private PermissionService permissionService;

	private GenericMapper<Permission, DefaultPermissionDto> permissionMapper;

	private GenericMapper<DefaultPermissionDto, Permission> inversePermissionMapper;

	@Override
	public void save(DefaultPermissionDto object) {
		LOG.debug("Saving permission with id " + object.getId());
		permissionService.create(inversePermissionMapper.map(object));
	}

	@Override
	public DefaultPermissionDto find(Long object) {
		LOG.debug("Finding permission with id " + object);
		return permissionMapper.map(permissionService.read(object));
	}

	@Override
	public Set<DefaultPermissionDto> findAll() {
		LOG.debug("Finding all permissions");
		return permissionMapper.mapAll(permissionService.readAll());
	}

	@Override
	public void merge(DefaultPermissionDto object) {
		LOG.debug("Merging permission with id " + object.getId());
		permissionService.update(inversePermissionMapper.map(object));
	}

	@Override
	public void remove(DefaultPermissionDto object) {
		LOG.debug("Removing permission with id " + object.getId());
		permissionService.delete(inversePermissionMapper.map(object));
	}

	@Override
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Override
	public void setPermissionMapper(GenericMapper<Permission, DefaultPermissionDto> permissionMapper) {
		this.permissionMapper = permissionMapper;
	}

	@Override
	public void setInversePermissionMapper(
			GenericMapper<DefaultPermissionDto, Permission> inversePermissionMapper) {
		this.inversePermissionMapper = inversePermissionMapper;
	}

}
