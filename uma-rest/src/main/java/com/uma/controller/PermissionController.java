package com.uma.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uma.controller.util.ControllerConstants;
import com.uma.domain.Permission;
import com.uma.facades.PermissionFacade;

@RestController
@RequestMapping(value = ControllerConstants.Mappings.PERMISSIONS, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PermissionController {

	@Autowired
	private PermissionFacade permissionFacade;

	@RequestMapping(method = RequestMethod.GET)
	public Set<Permission> getPermissions() {
		return permissionFacade.findAll();
	}

	@RequestMapping(value = ControllerConstants.Mappings.PERMISSION, method = RequestMethod.GET)
	public Permission getPermission(@PathVariable("id") String id) {
		return permissionFacade.find(Long.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public void savePermission(@RequestBody Permission permission) {
		permissionFacade.save(permission);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updatePermission(@RequestBody Permission permission) {
		permissionFacade.merge(permission);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deletePermission(@RequestBody Permission permission) {
		permissionFacade.remove(permission);
	}
}
