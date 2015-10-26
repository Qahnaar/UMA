package com.uma.facades.converters.user;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.user.User;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.user.DefaultUserDto;

public class DefaultInverseUserConverter implements DefaultConverter<DefaultUserDto, User> {

	@Override
	public User convert(DefaultUserDto userDto) {
		User user = new User();

		user.setId(userDto.getId());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setNickname(userDto.getPassword());

		return user;
	}

	@Override
	public Set<User> convertAll(Collection<DefaultUserDto> sourceCollection) {
		return sourceCollection.parallelStream().map(userDto -> convert(userDto)).collect(Collectors.toSet());
	}
}
