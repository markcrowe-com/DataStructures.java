/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import java.util.Comparator;

/**
 *
 */
public class StringComparator implements Comparator<String>
{
	@Override
	public int compare(String lhs, String rhs)
	{
		return lhs.compareTo(rhs);
	}
}
