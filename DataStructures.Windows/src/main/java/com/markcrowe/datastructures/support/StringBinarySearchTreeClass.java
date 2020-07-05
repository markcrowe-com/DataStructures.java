/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import com.markcrowe.datastructures.BinarySearchTreeClass;

/**
 *
 */
public final class StringBinarySearchTreeClass extends BinarySearchTreeClass<String, StringComparator>
{
	public StringBinarySearchTreeClass()
	{
		super(new StringComparator());
	}
}
