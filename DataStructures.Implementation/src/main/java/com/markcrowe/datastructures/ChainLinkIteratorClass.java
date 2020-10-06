/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.Iterator;

/**
 *
 * @param <T>
 */
class ChainLinkIteratorClass<T> implements Iterator<T>
{
	ChainLinkIteratorClass(ChainLinkClass<T> firstLinkInChain)
	{
		this.firstLinkInChain = firstLinkInChain;
		this.Reset();
	}
	//
	//	Public Methods - Status
	//
	public T Current()
	{
		return current.getValue();
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
		T item = current.getValue();
		current = current.getNextNodeInList();
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
