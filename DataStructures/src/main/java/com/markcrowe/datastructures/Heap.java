/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 *
 */
public interface Heap
{
	//
	//	Accessors
	//
	Object[] Items();
	int ItemsSize();
	void ItemsSize(int numElements);
	void ReheapDown(int rootIndex, int bottomIndex);
	void ReheapUp(int rootIndex, int bottomIndex);
}
