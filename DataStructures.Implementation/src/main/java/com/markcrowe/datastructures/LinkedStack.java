/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import com.markcrowe.algorithms.ChainLinkMethods;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Linked implementation of Stack
 *
 * @param <T>
 */
public class LinkedStack<T> implements Stack<T>
{
	public LinkedStack()
	{
		this.initialize();
	}
	//
	//	Public Methods - Status
	//
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
	@Override
	public T peek()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException();
		}
		return this.firstLinkInChain.getValue();
	}
	@Override
	public int size()
	{
		return this.size;
	}
	@Override
	public String toString()
	{
		return ChainLinkMethods.toListString(this.firstLinkInChain);
	}	//
	//	Public Methods
	//
	@Override
	public void clear()
	{
		this.initialize();
	}
	@Override
	public T pop()
	{
		T firstItem = this.peek();
		this.removeFirstLinkInChain();
		return firstItem;
	}
	@Override
	public void push(T item)
	{
		this.insertChainLink(new ChainLinkClass<>(item));
	}
	@Override
	public Iterator<T> iterator()
	{
		return new ChainLinkIteratorClass<>(this.firstLinkInChain);
	}
	//
	//	Private Methods
	//
	private void insertChainLink(ChainLinkClass<T> chainLink)
	{
		chainLink.setNextNodeInList(this.firstLinkInChain);
		this.firstLinkInChain = chainLink;
		this.size++;
	}
	private ChainLinkClass<T> ReturnAndRemoveFirstLinkInChain()
	{
		ChainLinkClass<T> chainLink = this.firstLinkInChain;
		this.removeFirstLinkInChain();
		return chainLink;
	}
	private void removeFirstLinkInChain()
	{
		this.firstLinkInChain = firstLinkInChain.getNextNodeInList();
		this.size--;
	}
	//
	//	Private Methods
	//
	private void initialize()
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
