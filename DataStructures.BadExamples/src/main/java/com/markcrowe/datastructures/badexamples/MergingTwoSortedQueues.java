/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.badexamples;

/** ****************************************************************************
 * Compilation: javac MergingTwoSortedQueues.java
 * Execution: java MergingTwoSortedQueues
 *
 * Merging two ascending sorted queues to one queue with ascending order.
 *
 * % java MergingTwoSortedQueues
 * First queue:
 * [a, b, g, h]
 *
 * Second queue:
 * [A, c, d, e, f]
 *
 * Merged queue:
 * [A, a, b, c, d, e, f, g, h]
 *
 ***************************************************************************** */
import com.markcrowe.algorithms.QueueMethods;
import com.markcrowe.datastructures.LinkedQueue;
import com.markcrowe.datastructures.Queue;

class MergingTwoSortedQueues
{
	public static void main(String[] args)
	{
		Queue<String> first = new LinkedQueue<>();
		Queue<String> second = new LinkedQueue<>();

		first.QueueItems("a", "b", "g", "h");
		second.QueueItems("A", "c", "d", "e", "f");

		var mergeResultString = mergeResult(first, second);

		System.out.println(mergeResultString);
	}
	public static String mergeResult(Queue<String> lhsQueue, Queue<String> rhsQueue)
	{
		String output = "First queue: [" + lhsQueue.toString() + "]" + System.lineSeparator()
				+ "Second queue: [" + rhsQueue.toString() + "]" + System.lineSeparator()
				+ "Merged queue: [" + QueueMethods.mergeSort(lhsQueue, rhsQueue).toString() + "]";
		return output;
	}
}
