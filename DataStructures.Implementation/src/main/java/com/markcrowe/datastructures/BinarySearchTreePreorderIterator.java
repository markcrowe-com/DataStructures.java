/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import com.markcrowe.algorithms.BinarySearchNodeMethods;
import java.util.Iterator;

public class BinarySearchTreePreorderIterator<T> implements Iterator<T>
{
	public BinarySearchTreePreorderIterator(BinarySearchNode<T> treeRoot)
	{
		this.stack.push(treeRoot);
		this.currentNode = treeRoot;
	}
	//
	//	Status Methods
	//
	@Override
	public boolean hasNext()
	{
		return this.currentNode != null;
	}
	//
	//	Modifiers
	//
	@Override
	public T next()
	{
		var node = stack.pop();
		pushIfNotNull(node.getNextGreaterValueNode());
		pushIfNotNull(node.getNextLesserValueNode());
		handleFinalCall();
		return node.getValue();
	}
	//
	//	Private Methods
	//
	private void handleFinalCall()
	{
		if(this.stack.isEmpty())
		{
			this.currentNode = null;
		}
	}
	private void pushIfNotNull(BinarySearchNode<T> node)
	{
		BinarySearchNodeMethods.pushIfNotNull(node, this.stack);
	}
	//
	//	Private Fields
	//
	private BinarySearchNode<T> currentNode;
	private final Stack<BinarySearchNode<T>> stack = new LinkedStack<>();
}
