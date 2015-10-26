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
import com.uma.facades.dtos.permission.DefaultPermissionDto;
import com.uma.facades.permission.PermissionFacade;

@RestController
@RequestMapping(value = ControllerConstants.Mappings.PERMISSIONS, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PermissionController {

	@Autowired
	private PermissionFacade permissionFacade;

	@RequestMapping(method = RequestMethod.GET)
	public Set<DefaultPermissionDto> getPermissions() {
		return permissionFacade.findAll();
	}

	@RequestMapping(value = ControllerConstants.Mappings.PERMISSION, method = RequestMethod.GET)
	public DefaultPermissionDto getPermission(@PathVariable("id") String id) {
		return permissionFacade.find(Long.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public void savePermission(@RequestBody DefaultPermissionDto permission) {
		permissionFacade.save(permission);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updatePermission(@RequestBody DefaultPermissionDto permission) {
		permissionFacade.merge(permission);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deletePermission(@RequestBody DefaultPermissionDto permission) {
		permissionFacade.remove(permission);
	}
}
