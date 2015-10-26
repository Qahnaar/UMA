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
import com.uma.facades.dtos.user.group.DefaultUserGroupDto;
import com.uma.facades.user.group.UserGroupFacade;

@RestController
@RequestMapping(value = ControllerConstants.Mappings.GROUPS, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserGroupController {

	@Autowired
	private UserGroupFacade userGroupFacade;

	@RequestMapping(method = RequestMethod.GET)
	public Set<DefaultUserGroupDto> getUserGroups() {
		return userGroupFacade.findAll();
	}

	@RequestMapping(value = ControllerConstants.Mappings.GROUP, method = RequestMethod.GET)
	public DefaultUserGroupDto getUserGroup(@PathVariable("id") String id) {
		return userGroupFacade.find(Long.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveUserGroup(@RequestBody DefaultUserGroupDto userGroup) {
		userGroupFacade.save(userGroup);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateUserGroup(@RequestBody DefaultUserGroupDto userGroup) {
		userGroupFacade.merge(userGroup);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteUserGroup(@RequestBody DefaultUserGroupDto userGroup) {
		userGroupFacade.remove(userGroup);
	}
}
