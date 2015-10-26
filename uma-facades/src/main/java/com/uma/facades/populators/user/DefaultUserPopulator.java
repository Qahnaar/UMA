package com.uma.facades.populators.user;

import java.util.Set;
import java.util.stream.Collectors;

import com.uma.domain.user.User;
import com.uma.facades.converters.DefaultConverter;
import com.uma.facades.dtos.user.DefaultUserDto;
import com.uma.facades.populators.GenericPopulator;

public class DefaultUserPopulator implements GenericPopulator<User, DefaultUserDto> {

	private DefaultConverter<User, DefaultUserDto> defaultUserConverter;

	@Override
	public DefaultUserDto populate(User source) {
		return defaultUserConverter.convert(source);
	}

	@Override
	public Set<DefaultUserDto> populateAll(Set<User> source) {
		return source.parallelStream().map(user -> populate(user)).collect(Collectors.toSet());
	}

	public void setDefaultUserConverter(DefaultConverter<User, DefaultUserDto> defaultUserConverter) {
		this.defaultUserConverter = defaultUserConverter;
	}

}
