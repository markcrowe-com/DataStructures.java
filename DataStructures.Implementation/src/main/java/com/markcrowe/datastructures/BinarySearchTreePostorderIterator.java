/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import com.markcrowe.algorithms.BinarySearchNodeMethods;
import java.util.Iterator;

public class BinarySearchTreePostorderIterator<T> implements Iterator<T>
{
	public BinarySearchTreePostorderIterator(BinarySearchNode<T> treeRoot)
	{
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

	private void pushLeftmostNodeRecord(BinarySearchNode<T> node)
	{
		// find the leftmost node
		if(node != null)
		{
			nodeStack.push(node); // push this node
			nodePlacementStack.push(false); // record that it is on the left
			pushLeftmostNodeRecord(node.getNextLesserValueNode()); // continue looping
		}
	}
	@Override

	public T next()
	{
		if(nodeStack.isEmpty())
		{	// at beginning of iterator
			// find the leftmost node, pushing all the intermediate nodes
			// onto the visiting stack
			pushLeftmostNodeRecord(currentNode);
		} // the node on top of the visiting stack is the next one to be
		// visited, unless it has a right subtree
		if((nodeStack.peek().getNextGreaterValueNode() == null) || (nodePlacementStack.peek()))
		{ // right subtree already visited
			// already visited right child, time to visit the node on top
			T result = nodeStack.pop().getValue();
			nodePlacementStack.pop();
			if(nodeStack.isEmpty())
			{
				currentNode = null;
			}
			return result;
		}
		else
		{ // now visit this node's right subtree
			// pop false and push true for visiting right child
			if(nodePlacementStack.pop())
			{
				assert (false);
			}
			nodePlacementStack.push(true);
			// now push everything down to the leftmost node
			// in the right subtree
			var right = nodeStack.peek().getNextGreaterValueNode();
			assert (right != null);
			pushLeftmostNodeRecord(right);
			// use recursive call to visit that node
			return next();
		}
	}

	//
	//	Private Methods
	//
	private void handleFinalCall()
	{
		if(this.nodeStack.isEmpty())
		{
			this.currentNode = null;
		}
	}
	private void pushIfNotNull(BinarySearchNode<T> node)
	{
		BinarySearchNodeMethods.pushIfNotNull(node, this.nodeStack);
	}
	//
	//	Private Fields
	//
	private BinarySearchNode<T> currentNode;
	private final Stack<BinarySearchNode<T>> nodeStack = new LinkedStack<>();
	private Stack<Boolean> nodePlacementStack = new LinkedStack<Boolean>();//True=Greater, False=Lesser
}
