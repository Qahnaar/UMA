package com.uma.facades.user;

import com.uma.domain.user.User;
import com.uma.facades.GenericFacade;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.populators.GenericPopulator;
import com.uma.services.user.UserService;

public interface UserFacade extends GenericFacade<DefaultUserDto, Long> {

	void setUserService(UserService userService);

	void setUserPopulator(GenericPopulator<User, DefaultUserDto> userPopulator);

	void setInverseUserPopulator(GenericPopulator<DefaultUserDto, User> inverseUserPopulator);
}
