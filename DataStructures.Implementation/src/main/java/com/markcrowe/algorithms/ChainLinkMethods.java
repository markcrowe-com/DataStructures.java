/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

import com.markcrowe.datastructures.ChainLinkClass;

public class ChainLinkMethods
{
	public static <T> String toListString(ChainLinkClass<T> firstLinkInChain)
	{
		return toListString(firstLinkInChain, ", ");
	}
	/**
	 *
	 * @param <T>
	 * @param firstLinkInChain
	 * @param seperator
	 * @return
	 */
	public static <T> String toListString(ChainLinkClass<T> firstLinkInChain, String seperator)
	{
		ChainLinkClass<T> i = firstLinkInChain;
		if(i != null)
		{
			String output = i.getValue().toString();
			for(i = i.getNextNodeInList(); i != null; i = i.getNextNodeInList())
			{
				output += seperator + i.getValue().toString();
			}
			return output;
		}
		return "";
	}
}
