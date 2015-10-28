package com.uma.facades.mappers;

import java.util.Set;

public interface GenericMapper<S, T> {
	
	T map(S source);
	
	Set<T> mapAll(Set<S> source);
}
