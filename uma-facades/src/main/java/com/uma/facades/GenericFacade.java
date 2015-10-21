package com.uma.facades;

import java.util.Set;

public interface GenericFacade<T> {

	void save(T object);

	T find(T object);

	Set<T> findAll();

	void merge(T object);

	void remove(T object);
}
