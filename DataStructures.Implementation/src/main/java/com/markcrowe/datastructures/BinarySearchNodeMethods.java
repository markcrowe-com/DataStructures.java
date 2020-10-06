/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

public class BinarySearchNodeMethods
{
	private static BinarySearchNode<Object> node;

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
		if(greaterValueNode != null)
		{
			pushLesserBranchValues(greaterValueNode, stack);
		}
	}
}
