/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 * @param <T>
 */
public interface PrefixTree<T>
{
	//
	//	modifiers
	//
	void clear();
	void insert(String key, T value);
	boolean remove(String key, T value);
	//
	//	status
	//
	boolean contains(String key, T candidate);
	boolean isEmpty();
}
