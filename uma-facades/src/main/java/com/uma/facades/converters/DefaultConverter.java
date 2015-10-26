package com.uma.facades.converters;

import java.util.Collection;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;

public interface DefaultConverter<S, T> extends Converter<S, T> {

	Set<T> convertAll(Collection<S> sourceCollection);
}
