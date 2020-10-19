/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 *
 * @param <T>
 */
public class ChainLinkClass<T>
{
	public ChainLinkClass(T value, ChainLinkClass<T> nextLinkInChain)
	{
		this.value = value;
		this.nextLinkInChain = nextLinkInChain;
	}
	public ChainLinkClass(T value)
	{
		this(value, null);
	}
	public ChainLinkClass()
	{
		this(null, null);
	}
	//
	//	Public Methods
	//
	public T getValue()
	{
		return value;
	}
	public void setValue(T value)
	{
		this.value = value;
	}
	public ChainLinkClass<T> getNextNodeInList()
	{
		return nextLinkInChain;
	}
	public void setNextNodeInList(ChainLinkClass<T> nexLinkInTheChain)
	{
		this.nextLinkInChain = nexLinkInTheChain;
	}
	//
	//	Private Fields
	//
	private ChainLinkClass<T> nextLinkInChain;
	private T value;
}
