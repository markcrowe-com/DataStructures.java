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
	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 * @return the head of this queue, or null if this queue is empty
	 */
	T peek();
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
