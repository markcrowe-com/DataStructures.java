/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

import com.markcrowe.datastructures.Queue;
import com.markcrowe.datastructures.Stack;

/**
 *
 */
public class StackMethods
{
	/**
	 *
	 * @param <T>
	 * @param stack
	 * @param queue
	 */
	public static <T> void emptyStackInto(Stack<T> stack, Queue<T> queue)
	{
		while(!stack.isEmpty())
		{
			queue.QueueItem(stack.pop());
		}
	}
}
