/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.Comparator;

/**
 *
 * @param <T>
 * @param <TComparator>
 */
public class HeapClass<T, TComparator extends Comparator<T>> implements Heap
{
	public HeapClass(int maxSize, TComparator comparator)
	{
		this.comparator = comparator;
		this.items = new Object[maxSize];//T[maxSize];
		this.itemsSize = maxSize;
	}
	//
	//	Accessors
	//
	@Override
	public Object[] Items()
	{
		return this.items;
	}
	@Override
	public int ItemsSize()
	{
		return this.itemsSize;
	}
	@Override
	public void ItemsSize(int numElements)
	{
		this.itemsSize = numElements;
	}
	//
	//	Methods
	//
	@Override
	public void ReheapDown(int rootIndex, int bottomIndex)
	{
		int leftChildIndex = rootIndex * 2 + 1;
		int maxChildIndex;
		int rightChildIndex = rootIndex * 2 + 2;

		if(leftChildIndex <= bottomIndex)
		{
			if(leftChildIndex == bottomIndex)
			{
				maxChildIndex = leftChildIndex;
			}
			else
			{
				@SuppressWarnings("unchecked")
				T leftChildItem = (T) items[leftChildIndex];
				@SuppressWarnings("unchecked")
				T rightChildItem = (T) items[rightChildIndex];
				int compareResult = this.comparator.compare(leftChildItem, rightChildItem);
				if(CompareResult.IsLessThanOrEqual(compareResult))
				{
					maxChildIndex = rightChildIndex;
				}
				else
				{
					maxChildIndex = leftChildIndex;
				}
			}
			@SuppressWarnings("unchecked")
			T rootItem = (T) items[rootIndex];
			@SuppressWarnings("unchecked")
			T maxChildItem = (T) items[maxChildIndex];
			int compareResult = this.comparator.compare(rootItem, maxChildItem);
			if(CompareResult.IsLessThan(compareResult))
			{
				this.SwapArrayElements(items, rootIndex, maxChildIndex);

				this.ReheapDown(maxChildIndex, bottomIndex);
			}
		}
	}
	@Override
	public void ReheapUp(int rootIndex, int bottomIndex)
	{
		int parentIndex;
		if(bottomIndex > rootIndex)
		{
			parentIndex = (bottomIndex - 1) / 2;
			@SuppressWarnings("unchecked")
			T parentItem = (T) items[parentIndex];
			@SuppressWarnings("unchecked")
			T bottomItem = (T) items[bottomIndex];
			int compareResult = this.comparator.compare(parentItem, bottomItem);
			if(CompareResult.IsLessThan(compareResult))
			{
				this.SwapArrayElements(items, parentIndex, bottomIndex);
				this.ReheapUp(rootIndex, parentIndex);
			}
		}
	}
	//
	//	Methods Support
	//
	public static void SwapArrayElements(Object[] array, int lhsIndex, int rhsIndex)
	{
		Object lhsCopy = array[lhsIndex];
		array[lhsIndex] = array[rhsIndex];
		array[rhsIndex] = lhsCopy;
	}
	//
	//	fields
	//
	private final Object[] items;  // Array that holds heap items
	private int itemsSize;
	private final TComparator comparator;
}
