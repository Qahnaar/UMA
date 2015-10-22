package com.uma.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uma.controller.util.ControllerConstants;
import com.uma.domain.User;
import com.uma.facades.UserFacade;

@RestController
@RequestMapping()
public class UserController {

	@Autowired
	private UserFacade userFacade;

	@RequestMapping(value = ControllerConstants.Mappings.USERS, method = RequestMethod.GET)
	public Set<User> getUsers() {
		return userFacade.findAll();
	}
}
