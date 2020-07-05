/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import com.markcrowe.datastructures.PriorityQueue;
import java.util.Comparator;

/**
 *
 * @param <T>
 * @param <TComparator>
 */
public class PriorityQueueClass<T, TComparator extends Comparator<T>> implements PriorityQueue<T>
{
	public PriorityQueueClass(int max, TComparator comparator)
	{
		this.itemComparator = comparator;
		this.itemsMaxiumNumber = max;
		this.itemsHeap = new HeapClass<>(max, this.itemComparator);
		this.itemsCount = 0;
	}
	//
	//	Methods
	//
	@Override
	public Object[] Items()
	{
		return this.itemsHeap.Items();//.items;//.clone();
	}
	@Override
	public int ItemsCount()
	{
		return this.itemsCount;
	}
	@Override
	public void ClearItems()
	{
		this.itemsCount = 0;
	}
	@Override
	public T Dequeue()
	{
		T item = (T) this.itemsHeap.Items()[0];	// remove root element
		this.itemsHeap.Items()[0] = this.itemsHeap.Items()[this.itemsCount - 1];
		this.itemsCount--;
		this.itemsHeap.ReheapDown(0, this.itemsCount - 1);
		//
		//	return
		//
		return item;
	}
	@Override
	public void Enqueue(T newItem)
	{
		itemsCount++;
		this.itemsHeap.Items()[this.itemsCount - 1] = newItem;	// remove root element
		this.itemsHeap.ReheapUp(0, this.itemsCount - 1);
	}
	@Override
	public boolean IsFull()
	{
		return this.itemsCount == this.itemsMaxiumNumber;
	}
	@Override
	public boolean IsEmpty()
	{
		return this.itemsCount == 0;
	}
	//
	//	fields
	//
	private final TComparator itemComparator;
	private int itemsCount;
	private final HeapClass<T, TComparator> itemsHeap;
	private final int itemsMaxiumNumber;
}
