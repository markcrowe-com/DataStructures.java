/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.Comparator;

/**
 *
 * @param <T>
 * @param <TComparator>
 */
public class BinarySearchNodeClass<T, TComparator extends Comparator<T>> implements BinarySearchNode<T>
{
	public BinarySearchNodeClass(T value)
	{
		this.comparator = null;
		this.nextGreaterValueNode = this.nextLesserValueNode = null;  // this node has no children
		this.value = value;
	}
	public BinarySearchNodeClass(T value, TComparator comparator)
	{
		this.comparator = comparator;
		this.nextGreaterValueNode = this.nextLesserValueNode = null;  // this node has no children
		this.value = value;
	}
	//
	//	accessors
	//
	@Override
	public BinarySearchNode<T> getNextGreaterValueNode()
	{
		return this.nextGreaterValueNode;
	}
	@Override
	public BinarySearchNode<T> getNextLesserValueNode()
	{
		return this.nextLesserValueNode;
	}
	public void setNextGreaterValueNode(BinarySearchNode<T> nextGreaterValueNode)
	{
		this.nextGreaterValueNode = nextGreaterValueNode;
	}
	public void setNextLesserValueNode(BinarySearchNode<T> nextLesserValueNode)
	{
		this.nextLesserValueNode = nextLesserValueNode;
	}
	@Override
	public T getValue()
	{
		return this.value;
	}
	//
	//	modifiers
	//
	@Override
	public synchronized void attachValueOnNode(T value)
	{
		var compareResult = this.comparator.compare(value, this.value);
		if(CompareResult.IsLessThan(compareResult))
		{
			if(this.nextLesserValueNode == null)
			{
				this.nextLesserValueNode = this.CreateChildNode(value);
			}
			else
			{
				this.nextLesserValueNode.attachValueOnNode(value);
			}
		}
		else if(CompareResult.IsGreaterThan(compareResult))
		{
			if(this.nextGreaterValueNode == null)
			{
				this.nextGreaterValueNode = this.CreateChildNode(value);
			}
			else
			{
				this.nextGreaterValueNode.attachValueOnNode(value);
			}
		}
	}
	@Override
	public synchronized BinarySearchNode<T> attachLeftValue(T value)
	{
		if(this.nextLesserValueNode == null)
		{
			this.nextLesserValueNode = this.CreateChildNode(value);
			return this.nextLesserValueNode;
		}
		else
		{
			return this.nextLesserValueNode.attachLeftValue(value);
		}
	}
	@Override
	public synchronized BinarySearchNode<T> attachRightValue(T value)
	{
		if(this.nextGreaterValueNode == null)
		{
			return this.nextGreaterValueNode = this.CreateChildNode(value);
		}
		else
		{
			return this.nextGreaterValueNode.attachRightValue(value);
		}
	}
	private BinarySearchNodeClass<T, TComparator> CreateChildNode(T value)
	{
		return new BinarySearchNodeClass<>(value, this.comparator);
	}
	//
	//	Status Methods
	//
	@Override
	public boolean isLeaf()
	{
		return (this.nextLesserValueNode == null && this.nextGreaterValueNode == null);
	}
	@Override
	public String toString()
	{
		return this.value.toString();
	}

	//
	//	Private Fields
	//
	private BinarySearchNode<T> nextGreaterValueNode;
	private BinarySearchNode<T> nextLesserValueNode;
	private final T value;
	private final TComparator comparator;
}
