/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import com.markcrowe.datastructures.Queue;
import java.util.Iterator;

/**
 *
 * @param <T>
 */
public class QueueClass<T> implements Queue<T>
{
	public QueueClass()
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
		//return this.firstLinkInChain == null;
		return this.lastLinkInChain == null;
		//return (this.size == 0);
	}
	@Override
	public T PeekAtFirstItem()
	{
		return this.firstLinkInChain.Item();
	}
	@Override
	public T PeekAtLastItem()
	{
		return this.lastLinkInChain.Item();
	}
	@Override
	public String toString()
	{
		String output = "";
		for(ChainLinkClass<T> i = this.firstLinkInChain; i != null; i = i.NextNodeInList())
		{
			output += i.toString() + System.lineSeparator();
		}
		return output;
	}
	//
	//	Public Methods
	//
	@Override
	public void Clear()
	{
		//this.ClearItems();
		this.Initialize();
	}
	@Override
	public T Dequeue()
	{
		ChainLinkClass<T> chainLink = this.ReturnAndRemoveFirstLinkInChain();
		T firstItem = chainLink.Item();
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
	//
	//	Protected Methods
	//
	protected void ClearItems()
	{
//		ChainLinkClass<T> current;
//		while(this.firstLinkInChain != null)
//		{
//			current = this.firstLinkInChain;
//			this.firstLinkInChain = this.firstLinkInChain.NextNodeInList();
//			//delete current;
//		}
	}
	private void JoinQueue(ChainLinkClass<T> chainLink)
	{
		if(this.IsEmpty())
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
		this.lastLinkInChain.NextNodeInList(chainLink);
	}
	private void FirstLinkInChain(ChainLinkClass<T> chainLink)
	{
		if(this.IsEmpty())
		{
			this.firstLinkInChain = chainLink;
		}
		else
		{
			this.lastLinkInChain.NextNodeInList(chainLink);
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
		this.firstLinkInChain = firstLinkInChain.NextNodeInList();
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
