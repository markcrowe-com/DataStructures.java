/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.implementation;

import com.markcrowe.datastructures.CompareResult;
import com.markcrowe.datastructures.Heap;
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
	public void ReheapDown_wrong(int rootIndex, int bottomIndex)
	{
		int maxChildIndex;
		int rightChildIndex;
		int leftChildIndex;
		leftChildIndex = rootIndex * 2 + 1;
		rightChildIndex = rootIndex * 2 + 2;
		if(leftChildIndex <= bottomIndex)
		{
			if(leftChildIndex == bottomIndex)
			{
				maxChildIndex = leftChildIndex;
			}
			else
			{
				if(true)//items[leftChildIndex] <= items[rightChildIndex])
				{
					maxChildIndex = rightChildIndex;
				}
				else
				{
					maxChildIndex = leftChildIndex;
				}
			}
			if(true)//items[rootIndex] < items[maxChildIndex])
			{
				this.SwapArrayElements(items, rootIndex, maxChildIndex);
				this.ReheapDown_wrong(maxChildIndex, bottomIndex);
			}
		}
	}// end of ReheapDown

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
				T leftChildItem = (T) items[leftChildIndex];
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
			T rootItem = (T) items[rootIndex];
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
			T parentItem = (T) items[parentIndex];
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
	private void SwapArrayElements(Object[] array, int lhsIndex, int rhsIndex)
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
