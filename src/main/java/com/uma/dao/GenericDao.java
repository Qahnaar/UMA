package com.uma.dao;

import java.util.Collection;

public interface GenericDao<T, V> {
	
	void create(T object);
	
	T read(V key);
	
	Collection<T> readAll();
	
	void update(T object);
	
	void delete(T object);
}
