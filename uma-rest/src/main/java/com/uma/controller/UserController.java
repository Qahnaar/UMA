package com.uma.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uma.controller.util.ControllerConstants;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.user.UserFacade;

@RestController
@RequestMapping(value = ControllerConstants.Mappings.USERS)
public class UserController {

	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.GET)
	public Set<DefaultUserDto> getUsers() {
		return userFacade.findAll();
	}

	@RequestMapping(value = ControllerConstants.Mappings.USER, method = RequestMethod.GET)
	public DefaultUserDto getUser(@PathVariable("id") Long id) {
		return userFacade.find(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveUser(@RequestBody DefaultUserDto user) {
		userFacade.save(user);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateUser(@RequestBody DefaultUserDto user) {
		userFacade.merge(user);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody DefaultUserDto user) {
		userFacade.remove(user);
	}
}
