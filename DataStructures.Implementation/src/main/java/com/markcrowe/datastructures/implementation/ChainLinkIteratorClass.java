/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.implementation;

import java.util.Iterator;

/**
 *
 * @param <T>
 */
public class ChainLinkIteratorClass<T> implements Iterator<T>
{
	public ChainLinkIteratorClass(ChainLinkClass<T> firstLinkInChain)
	{
		this.firstLinkInChain = firstLinkInChain;
		this.Reset();
	}
	//
	//	Public Methods - Status
	//
	public T Current()
	{
		return current.Item();
	}
	@Override
	public boolean hasNext()
	{
		return (current != null);
	}
	//
	//	Public Methods
	//
	@Override
	public T next()
	{
		T item = current.Item();
		current = current.NextNodeInList();
		return item;

	}
	public final void Reset()
	{
		this.current = this.firstLinkInChain;
	}
	//
	//	Private Fields
	//
	private ChainLinkClass<T> current;
	private final ChainLinkClass<T> firstLinkInChain;
}
