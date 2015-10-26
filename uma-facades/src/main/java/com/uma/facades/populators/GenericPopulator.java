package com.uma.facades.populators;

import java.util.Set;

public interface GenericPopulator<S, T> {
	
	T populate(S source);
	
	Set<T> populateAll(Set<S> source);
}
