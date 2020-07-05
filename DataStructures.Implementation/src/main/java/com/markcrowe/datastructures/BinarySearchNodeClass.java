/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import com.markcrowe.datastructures.BinarySearchNode;
import com.markcrowe.datastructures.CompareResult;
import java.util.Comparator;

/**
 *
 * @param <T>
 * @param <TComparator>
 */
public class BinarySearchNodeClass<T, TComparator extends Comparator<T>> implements BinarySearchNode<T>
{
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
	public BinarySearchNode<T> NextGreaterValueNode()
	{
		return this.nextGreaterValueNode;
	}
	@Override
	public BinarySearchNode<T> NextLesserValueNode()
	{
		return this.nextLesserValueNode;
	}
	@Override
	public T Value()
	{
		return this.value;
	}
	//
	//	modifiers
	//
	@Override
	public synchronized void AttachValueOnNode(T value)
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
				this.nextLesserValueNode.AttachValueOnNode(value);
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
				this.nextGreaterValueNode.AttachValueOnNode(value);
			}
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
	public boolean IsLeaf()
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
