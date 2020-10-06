/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @param <T>
 * @param <TComparator>
 */
public class BinarySearchTreeClass<T, TComparator extends Comparator<T>> implements BinarySearchTree<T>
{
	public BinarySearchTreeClass(TComparator comparator)
	{
		this.comparator = comparator;
		this.root = null;
	}
	//
	//	modifiers
	//
	@Override
	public void clear()
	{
		this.root = null;
	}
	@Override
	public synchronized void insert(T value)
	{
		if(this.root == null)
		{
			this.root = new BinarySearchNodeClass<>(value, this.comparator);
		}
		else
		{
			this.root.attachValueOnNode(value);
		}
	}
	//
	//	access
	//
	@Override
	public BinarySearchNode<T> searchForTree(BinarySearchNode<T> root, T value)
	{
		return this.searchForTree(root, value, comparator);
	}
	@Override
	public BinarySearchNode<T> searchForTree(BinarySearchNode<T> root, T value, Comparator<T> comparator)
	{
		BinarySearchNode<T> candidate;
		candidate = root;
		while((candidate != null) && (value != candidate.getValue()))
		{
			if(this.comparator.compare(value, candidate.getValue()) == -1)
			{
				candidate = candidate.getNextLesserValueNode();
			}
			else
			{
				candidate = candidate.getNextGreaterValueNode();
			}
		}
		return candidate;
	}
	//
	//	Iterators
	//
	@Override
	public Iterator<T> getInOrderIterator()
	{
		return new BinarySearchTreeInorderIterator<T>(this.root);
	}
	@Override
	public Iterator<T> getPreOrderIterator()
	{
		return new BinarySearchTreePreorderIterator<T>(this.root);
	}
	@Override
	public Iterator<T> getPostOrderIterator()
	{
		return new BinarySearchTreePostorderIterator<T>(this.root);
	}
	//
	//	Private Fields
	//
	private final TComparator comparator;
	private BinarySearchNode<T> root;

	public BinarySearchNode<T> getNodes()
	{
		BinarySearchNode<T> copy = copyNodes(this.root, comparator);
		return copy;
	}
	public static <T, TComparator extends Comparator<T>> BinarySearchNode<T> copyNodes(BinarySearchNode<T> originalNode, TComparator comparator)
	{
		if(originalNode == null)
		{
			return null;
		}
		var nodeCopy = new BinarySearchNodeClass<>(originalNode.getValue(), comparator);
		var left = copyNodes(originalNode.getNextLesserValueNode(), comparator);
		var right = copyNodes(originalNode.getNextGreaterValueNode(), comparator);
		nodeCopy.setNextLesserValueNode(left != null ? copyNodes(left, comparator) : null);
		nodeCopy.setNextGreaterValueNode(right != null ? copyNodes(right, comparator) : null);
		return nodeCopy;
	}
}
