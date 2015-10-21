package com.uma.facades;

import com.uma.domain.User;
import com.uma.services.UserService;

public interface UserFacade extends GenericFacade<User> {
	
	void setUserService(UserService userService);
}
