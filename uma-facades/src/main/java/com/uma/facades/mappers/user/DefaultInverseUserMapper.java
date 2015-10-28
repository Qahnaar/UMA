package com.uma.facades.mappers.user;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.user.User;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.mappers.GenericMapper;

public class DefaultInverseUserMapper implements GenericMapper<DefaultUserDto, User> {

	private DefaultConverter<DefaultUserDto, User> defaultInverseUserConverter;

	@Override
	public User map(DefaultUserDto source) {
		return defaultInverseUserConverter.convert(source);
	}

	@Override
	public Set<User> mapAll(Set<DefaultUserDto> source) {
		return source.parallelStream().map(user -> map(user)).collect(Collectors.toSet());
	}

	public void setDefaultInverseUserConverter(DefaultConverter<DefaultUserDto, User> defaultInverseUserConverter) {
		this.defaultInverseUserConverter = defaultInverseUserConverter;
	}
}
