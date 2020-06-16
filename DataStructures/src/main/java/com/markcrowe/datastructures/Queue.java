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
	void Clear();
	T Dequeue();
	Boolean IsEmpty();
	T PeekAtFirstItem();
	T PeekAtLastItem();
	void QueueItem(T item);
	//
	//	Public Methods - Status
	//
	int Size();
	@Override
	Iterator<T> iterator();
	@Override
	String toString();

}
