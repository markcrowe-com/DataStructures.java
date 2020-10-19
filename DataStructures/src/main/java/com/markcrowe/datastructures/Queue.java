/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.Iterator;

/**
 *
 * @param <T>
 */
public interface Queue<T> extends Iterable<T>
{
	//
	//	Public Methods
	//
	void clear();
	T Dequeue();
	/**
	 *
	 * @return
	 */
	Boolean isEmpty();
	T PeekAtFirstItem();
	T PeekAtLastItem();
	void QueueItem(T item);

	/**
	 *
	 * @param items
	 */
	@SuppressWarnings("unchecked")
	void QueueItems(T... items);
	//
	//	Public Methods - Status
	//
	int size();
	@Override
	Iterator<T> iterator();
	@Override
	String toString();
}
