package com.markcrowe.algorithms;

import java.util.Comparator;

/**
 *
 */
public class PathManagerComparator<T> implements Comparator<PathManager<T>>
{
	@Override
	public int compare(PathManager<T> lhs, PathManager<T> rhs)
	{
		return new IntegerComparator().compare(lhs.distance, rhs.distance);
	}
}

class IntegerComparator implements Comparator<Integer>
{
	@Override
	public int compare(Integer lhs, Integer rhs)
	{
		return lhs.compareTo(rhs);
	}
}
