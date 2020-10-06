/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.Iterator;

public class BinarySearchTreeInorderIterator<T> implements Iterator<T>
{
	public BinarySearchTreeInorderIterator(BinarySearchNode<T> treeRoot)
	{
		fillStackWithValuesFromLesserBranch(treeRoot);
	}
	//
	//	Status Methods
	//
	@Override
	public boolean hasNext()
	{
		return !stack.isEmpty();
	}
	//
	//	Modifiers
	//
	@Override
	public T next()
	{
		var binarySearchNode = stack.pop();
		fillStackWithValuesFromLesserBranchOnGreaterValueBranch(binarySearchNode);
		return binarySearchNode.getValue();
	}

	//
	//	Private Methods
	//
	private void fillStackWithValuesFromLesserBranch(BinarySearchNode<T> current)
	{
		while(current != null)
		{
			this.stack.push(current);
			current = current.getNextLesserValueNode();
		}
	}
	public void fillStackWithValuesFromLesserBranchOnGreaterValueBranch(BinarySearchNode<T> node)
	{
		var greaterValueNode = node.getNextGreaterValueNode();
		if(greaterValueNode != null)
		{
			fillStackWithValuesFromLesserBranch(greaterValueNode);
		}
	}	//
	//	Private Fields
	//
	private final Stack<BinarySearchNode<T>> stack = new LinkedStack<>();
}
