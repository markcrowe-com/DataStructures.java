/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

import com.markcrowe.datastructures.LinkedQueue;
import com.markcrowe.datastructures.LinkedStack;
import com.markcrowe.datastructures.Queue;
import com.markcrowe.datastructures.Stack;

/**
 * Queue Methods
 */
public class QueueMethods
{
	/**
	 *
	 * @param <T>
	 * @param sourceQueue
	 * @param destinationQueue
	 */
	public static <T> void emptyQueueInto(Queue<T> sourceQueue, Queue<T> destinationQueue)
	{
		while(!sourceQueue.isEmpty())
		{
			destinationQueue.QueueItem(sourceQueue.Dequeue());
		}
	}
	/**
	 *
	 * @param <T>
	 * @param sourceQueue
	 * @param destinationStack
	 */
	public static <T> void emptyQueueInto(Queue<T> sourceQueue, Stack<T> destinationStack)
	{
		while(!sourceQueue.isEmpty())
		{
			destinationStack.push(sourceQueue.Dequeue());
		}
	}
	/**
	 *
	 * @param <T>
	 * @param lhsQueue
	 * @param rhsQueue
	 * @return
	 */
	public static <T extends Comparable<T>> Queue<T> mergeSort(Queue<T> lhsQueue, Queue<T> rhsQueue)
	{
		Queue<T> mergedQueue = new LinkedQueue<>();
		mergeSort(lhsQueue, rhsQueue, mergedQueue);
		return mergedQueue;
	}
	/**
	 *
	 * @param <T>
	 * @param lhsQueue
	 * @param rhsQueue
	 * @param mergedQueue
	 */
	public static <T extends Comparable<T>> void mergeSort(Queue<T> lhsQueue, Queue<T> rhsQueue, Queue<T> mergedQueue)
	{
		while(!lhsQueue.isEmpty() && !rhsQueue.isEmpty())
		{
			T lhsQueueItem = lhsQueue.PeekAtFirstItem(), rhsQueueItem = rhsQueue.PeekAtFirstItem();
			mergedQueue.QueueItem((lhsQueueItem.compareTo(rhsQueueItem) < 0 ? lhsQueue : rhsQueue).Dequeue());
		}
		QueueMethods.emptyQueueInto(lhsQueue, mergedQueue);
		QueueMethods.emptyQueueInto(rhsQueue, mergedQueue);
	}
	public static <T> void reverse(Queue<T> queue)
	{
		Stack<T> stack = new LinkedStack<>();
		emptyQueueInto(queue, stack);
		StackMethods.emptyStackInto(stack, queue);
	}
}
