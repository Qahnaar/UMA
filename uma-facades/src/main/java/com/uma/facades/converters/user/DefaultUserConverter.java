package com.uma.facades.converters.user;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.user.User;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.user.DefaultUserDto;

public class DefaultUserConverter implements DefaultConverter<User, DefaultUserDto> {

	@Override
	public DefaultUserDto convert(User user) {
		DefaultUserDto userDto = new DefaultUserDto();

		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setNickname(user.getNickname());

		return userDto;
	}

	@Override
	public Set<DefaultUserDto> convertAll(Collection<User> sourceCollection) {
		return sourceCollection.parallelStream().map(user -> convert(user)).collect(Collectors.toSet());
	}
}
