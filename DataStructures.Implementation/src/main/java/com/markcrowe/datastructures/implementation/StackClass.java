/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.implementation;

import com.markcrowe.datastructures.Stack;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 *
 * @param <T>
 */
public class StackClass<T> implements Stack<T>
{
	public StackClass()
	{
		this.Initialize();
	}
	//
	//	Public Methods - Status
	//
	@Override
	public int Size()
	{
		return this.size;
	}
	@Override
	public Boolean IsEmpty()
	{
		//return (this.size == 0);
		return this.firstLinkInChain == null;
	}
	//
	//	Public Methods
	//
	@Override
	public T Peek()
	{
		if(this.IsEmpty())
		{
			throw new EmptyStackException();
		}
		return this.firstLinkInChain.Item();
	}
	@Override
	public T Pop()
	{
		T firstItem = this.Peek();
		ChainLinkClass<T> chainLink = this.ReturnAndRemoveFirstLinkInChain();
		//RemoveFirstLinkInChain
		//	Delete chainLink
		return firstItem;
	}
	@Override
	public void Push(T item)
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
	public void Clear()
	{
		this.Initialize();
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
