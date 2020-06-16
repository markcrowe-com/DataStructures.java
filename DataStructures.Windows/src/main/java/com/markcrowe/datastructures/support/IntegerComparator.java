/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import java.util.Comparator;

/**
 *
 */
public class IntegerComparator implements Comparator<Integer>
{
	@Override
	public int compare(Integer lhs, Integer rhs)
	{
		return lhs.compareTo(rhs);
	}
}
