/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 *
 * @param <T>
 */
public interface PriorityQueue<T>
{
	void ClearItems();
	T Dequeue();
	void Enqueue(T newItem);
	boolean IsEmpty();
	boolean IsFull();
	//
	//	Methods
	//
	Object[] Items();
	int ItemsCount();
}
