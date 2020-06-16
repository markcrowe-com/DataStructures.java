/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.implementation;

/**
 *
 * @param <T>
 */
class ChainLinkClass<T>
{
	public ChainLinkClass(T item, ChainLinkClass<T> nextLinkInChain)
	{
		this.item = item;
		this.nextLinkInChain = nextLinkInChain;
	}
	public ChainLinkClass(T item)
	{
		this(item, null);
	}
	public ChainLinkClass()
	{
		this(null, null);
	}
	//
	//	Public Methods
	//
	public T Item()
	{
		return item;
	}
	public void Item(T item)
	{
		this.item = item;
	}
	public ChainLinkClass<T> NextNodeInList()
	{
		return nextLinkInChain;
	}
	public void NextNodeInList(ChainLinkClass<T> nexLinkInTheChain)
	{
		this.nextLinkInChain = nexLinkInTheChain;
	}
	//
	//	Private Fields
	//
	private T item;
	private ChainLinkClass<T> nextLinkInChain;
}
