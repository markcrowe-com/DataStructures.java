/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import com.markcrowe.datastructures.BinarySearchTreeClass;

/**
 * Integer Binary Search Tree
 */
public final class IntegerBinarySearchTreeClass extends BinarySearchTreeClass<Integer, IntegerComparator>
{
	public IntegerBinarySearchTreeClass()
	{
		super(new IntegerComparator());
	}
}
