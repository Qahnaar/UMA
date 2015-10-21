package com.uma.dao;

import java.util.Set;

public interface GenericFacade<T, V> {

	void create(T object);

	T read(V key);

	Set<T> readAll();

	void update(T object);

	void delete(T object);
}
