/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

import com.markcrowe.datastructures.BinarySearchNode;
import com.markcrowe.datastructures.Stack;

public class BinarySearchNodeMethods
{
	public static <T> void pushIfNotNull(BinarySearchNode<T> binarySearchNode, Stack<BinarySearchNode<T>> stack)
	{
		if(binarySearchNode != null)
		{
			stack.push(binarySearchNode);
		}
	}
	public static <T> void pushLesserBranchValues(BinarySearchNode<T> node, Stack<BinarySearchNode<T>> stack)
	{
		while(node != null)
		{
			stack.push(node);
			node = node.getNextLesserValueNode();
		}
	}
	public static <T> void pushLesserBranchValuesFromNextGreaterValueNode(BinarySearchNode<T> node, Stack<BinarySearchNode<T>> stack)
	{
		var greaterValueNode = node.getNextGreaterValueNode();
		pushLesserBranchValues(greaterValueNode, stack);
	}
}
