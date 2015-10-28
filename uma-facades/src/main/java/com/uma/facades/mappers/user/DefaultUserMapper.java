package com.uma.facades.mappers.user;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.user.User;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.mappers.GenericMapper;

public class DefaultUserMapper implements GenericMapper<User, DefaultUserDto> {

	private DefaultConverter<User, DefaultUserDto> defaultUserConverter;

	@Override
	public DefaultUserDto map(User source) {
		return defaultUserConverter.convert(source);
	}

	@Override
	public Set<DefaultUserDto> mapAll(Set<User> source) {
		return source.parallelStream().map(user -> map(user)).collect(Collectors.toSet());
	}

	public void setDefaultUserConverter(DefaultConverter<User, DefaultUserDto> defaultUserConverter) {
		this.defaultUserConverter = defaultUserConverter;
	}

}
