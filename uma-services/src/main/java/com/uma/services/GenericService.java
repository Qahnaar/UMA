package com.uma.services;

import java.util.Set;

public interface GenericService<T, V> {

	void create(T object);

	T read(V key);

	Set<T> readAll();

	void update(T object);

	void delete(T object);
}
