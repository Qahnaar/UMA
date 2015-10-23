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
import com.uma.domain.User;
import com.uma.facades.UserFacade;

@RestController
@RequestMapping(value = ControllerConstants.Mappings.USERS, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.GET)
	public Set<User> getUsers() {
		return userFacade.findAll();
	}

	@RequestMapping(value = ControllerConstants.Mappings.USER, method = RequestMethod.GET)
	public User getUser(@PathVariable("email") String email) {
		return userFacade.find(email);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void saveUser(@RequestBody User user) {
		userFacade.save(user);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		userFacade.merge(user);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody User user) {
		userFacade.remove(user);
	}
}
