/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import com.markcrowe.algorithms.ChainLinkMethods;
import java.util.Iterator;

/**
 * Linked implementation of Queue
 *
 * @param <T>
 */
public class LinkedQueue<T> implements Queue<T>
{
	public LinkedQueue()
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
	public Boolean isEmpty()
	{
		//return this.firstLinkInChain == null;
		return this.lastLinkInChain == null;
		//return (this.size == 0);
	}
	@Override
	public T peek()
	{
		return this.firstLinkInChain == null ? null : this.firstLinkInChain.getValue();
	}
	@Override
	public T PeekAtLastItem()
	{
		return this.lastLinkInChain.getValue();
	}
	@Override
	public String toString()
	{
		return ChainLinkMethods.toListString(this.firstLinkInChain);
	}
	//
	//	Public Methods
	//
	@Override
	public void clear()
	{
		//this.ClearItems();
		this.Initialize();
	}
	@Override
	public T Dequeue()
	{
		ChainLinkClass<T> chainLink = this.ReturnAndRemoveFirstLinkInChain();
		T firstItem = chainLink.getValue();
		//	Delete chainLink
		return firstItem;
	}
	@Override
	public void QueueItem(T item)
	{
		//
		//	Step 1
		//
		ChainLinkClass<T> chainLink = new ChainLinkClass<>(item);
		//
		//	Step 2
		//
		this.JoinQueue(chainLink);
	}

	/**
	 *
	 * @param items
	 */
	public void QueueItems(T... items)
	{
		for(T item : items)
		{
			QueueItem(item);
		}
	}

	//
	//	Protected Methods
	//
	protected void ClearItems()
	{
//		ChainLinkClass<T> current;
//		while(this.firstLinkInChain != null)
//		{
//			current = this.firstLinkInChain;
//			this.firstLinkInChain = this.firstLinkInChain.getNextNodeInList();
//			//delete current;
//		}
	}
	private void JoinQueue(ChainLinkClass<T> chainLink)
	{
		if(this.isEmpty())
		{
			this.PlaceFirstInChain(chainLink);
		}
		else
		{
			this.AddToLastLinkInChain(chainLink);
		}
		this.lastLinkInChain = chainLink;

		this.size++;
	}
	private void PlaceFirstInChain(ChainLinkClass<T> chainLink)
	{
		this.firstLinkInChain = chainLink;
	}
	private void AddToLastLinkInChain(ChainLinkClass<T> chainLink)
	{
		this.lastLinkInChain.setNextNodeInList(chainLink);
	}
	private void FirstLinkInChain(ChainLinkClass<T> chainLink)
	{
		if(this.isEmpty())
		{
			this.firstLinkInChain = chainLink;
		}
		else
		{
			this.lastLinkInChain.setNextNodeInList(chainLink);
		}
		this.lastLinkInChain = chainLink;

		this.size++;
	}

	private ChainLinkClass<T> ReturnAndRemoveFirstLinkInChain()
	{
		ChainLinkClass<T> chainLink = this.firstLinkInChain;
		this.RemoveFirstLinkInChain();
		return chainLink;
	}
	protected void RemoveFirstLinkInChain()
	{
		this.firstLinkInChain = firstLinkInChain.getNextNodeInList();
		this.size--;
		if(this.size == 0)
		{
			this.lastLinkInChain = null;
		}
	}
	@Override
	public Iterator<T> iterator()
	{
		return new ChainLinkIteratorClass<>(this.firstLinkInChain);
	}
	//
	//	Private Methods
	//
	private void Initialize()
	{
		this.firstLinkInChain = this.lastLinkInChain = null;
		this.size = 0;
	}
	//
	//	Private Fields
	//
	private ChainLinkClass<T> firstLinkInChain;
	private ChainLinkClass<T> lastLinkInChain;
	private int size;
}
