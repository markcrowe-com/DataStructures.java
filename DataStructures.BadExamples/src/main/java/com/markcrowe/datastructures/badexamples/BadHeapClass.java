/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.badexamples;

import com.markcrowe.datastructures.Heap;
import com.markcrowe.datastructures.HeapClass;
import java.util.Comparator;

/**
 *
 * @param <T>
 * @param <TComparator>
 */
public class BadHeapClass<T, TComparator extends Comparator<T>> extends HeapClass<T, TComparator> implements Heap
{
	public BadHeapClass(int maxSize, TComparator comparator)
	{
		super(maxSize, comparator);
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
				SwapArrayElements(this.Items(), rootIndex, maxChildIndex);
				this.ReheapDown_wrong(maxChildIndex, bottomIndex);
			}
		}
	}
}
