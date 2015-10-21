package com.uma.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uma.controller.util.ControllerConstants;

@RestController
@RequestMapping(ControllerConstants.Mappings.USERS)
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public String getUsers() {
		return "Hello World!";
	}
}
