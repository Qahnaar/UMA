package com.uma.facades.populators.user;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.user.User;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.populators.GenericPopulator;

public class DefaultInverseUserPopulator implements GenericPopulator<DefaultUserDto, User> {

	private DefaultConverter<DefaultUserDto, User> defaultInverseUserConverter;

	@Override
	public User populate(DefaultUserDto source) {
		return defaultInverseUserConverter.convert(source);
	}

	@Override
	public Set<User> populateAll(Set<DefaultUserDto> source) {
		return source.parallelStream().map(user -> populate(user)).collect(Collectors.toSet());
	}

	public void setDefaultInverseUserConverter(DefaultConverter<DefaultUserDto, User> defaultInverseUserConverter) {
		this.defaultInverseUserConverter = defaultInverseUserConverter;
	}
}
