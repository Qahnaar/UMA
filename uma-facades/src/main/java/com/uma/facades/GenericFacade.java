package com.uma.facades;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GenericFacade<T, V> {

	void save(T object);

	T find(V object);

	Set<T> findAll();

	void merge(T object);

	void remove(T object);
}
