/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Linked Stack implementation of Stack
 *
 * @param <T>
 */
public class LinkedStack<T> implements Stack<T>
{
	public LinkedStack()
	{
		this.Initialize();
	}
	//
	//	Public Methods - Status
	//
	@Override
	public int size()
	{
		return this.size;
	}
	@Override
	public boolean isEmpty()
	{
		//return (this.size == 0);
		return this.firstLinkInChain == null;
	}
	@Override
	public boolean isFull()
	{
		return size == Integer.MAX_VALUE;
	}
	//
	//	Public Methods
	//
	@Override
	public void clear()
	{
		this.Initialize();
	}
	@Override
	public T peek()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException();
		}
		return this.firstLinkInChain.Item();
	}
	@Override
	public T pop()
	{
		T firstItem = this.peek();
		ChainLinkClass<T> chainLink = this.ReturnAndRemoveFirstLinkInChain();
		//RemoveFirstLinkInChain
		//	Delete chainLink
		return firstItem;
	}
	@Override
	public void push(T item)
	{
		//
		//	Step 1
		//
		ChainLinkClass<T> chainLink = new ChainLinkClass<>(item);
		//
		//	Step 2
		//
		this.Push(chainLink);
	}
	@Override
	public Iterator<T> iterator()
	{
		return new ChainLinkIteratorClass<>(this.firstLinkInChain);
	}
	//
	//	Private Methods
	//
	private void Push(ChainLinkClass<T> chainLink)
	{
		chainLink.NextNodeInList(this.firstLinkInChain);
		this.firstLinkInChain = chainLink;
		this.size++;
	}
	private ChainLinkClass<T> ReturnAndRemoveFirstLinkInChain()
	{
		ChainLinkClass<T> chainLink = this.firstLinkInChain;
		this.RemoveFirstLinkInChain();
		return chainLink;
	}
	private void RemoveFirstLinkInChain()
	{
		this.firstLinkInChain = firstLinkInChain.NextNodeInList();
		this.size--;
	}
	//
	//	Private Methods
	//
	private void Initialize()
	{
		this.firstLinkInChain = null;
		this.size = 0;
	}
	//
	//	Private Fields
	//
	private ChainLinkClass<T> firstLinkInChain;
	private int size;
}
