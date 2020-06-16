package com.markcrowe.datastructures.support;

import java.util.Comparator;
import java.util.Date;

/**
 *
 */
public class DateComparator implements Comparator<Date>
{
	@Override
	public int compare(Date lhs, Date rhs)
	{
		return lhs.compareTo(rhs);
	}
}
