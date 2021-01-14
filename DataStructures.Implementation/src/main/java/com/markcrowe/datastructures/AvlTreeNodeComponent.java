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
public class AvlTreeNodeComponent<T, TComparator extends Comparator<T>> implements AvlTreeNode<T>
{
	public AvlTreeNodeComponent(T value)
	{
		this.comparator = null;
		this.leftTree = this.rightTree = null;  // this node has no children
		this.value = value;
	}
	public AvlTreeNodeComponent(T value, TComparator comparator)
	{
		this.comparator = comparator;
		this.leftTree = this.rightTree = null;  // this node has no children
		this.value = value;
	}
	//
	//	accessors
	//
	@Override
	public AvlTreeNode<T> getLeftTree()
	{
		return this.leftTree;
	}
	@Override
	public AvlTreeNode<T> getRightTree()
	{
		return this.rightTree;
	}
	@Override
	public T getValue()
	{
		return this.value;
	}

	@Override
	public AvlTreeNode<T> setLeftTree(AvlTreeNode<T> value)
	{
		this.leftTree = value;
		return this.leftTree;
	}
	@Override
	public AvlTreeNode<T> setRightTree(AvlTreeNode<T> value)
	{
		this.rightTree = value;
		return this.rightTree;
	}
	//
	//	modifiers
	//
	@Override
	public synchronized AvlTreeNode<T> attachLeftValue(T value)
	{
		if(this.rightTree == null)
		{
			this.rightTree = this.CreateChildNode(value);
			return this.rightTree;
		}
		else
		{
			return this.rightTree.attachLeftValue(value);
		}
	}
	@Override
	public synchronized AvlTreeNode<T> attachRightValue(T value)
	{
		if(this.leftTree == null)
		{
			return this.leftTree = this.CreateChildNode(value);
		}
		else
		{
			return this.leftTree.attachRightValue(value);
		}
	}
	private AvlTreeNodeComponent<T, TComparator> CreateChildNode(T value)
	{
		return new AvlTreeNodeComponent<>(value, this.comparator);
	}
	//
	//	Status Methods
	//
	@Override
	public boolean isLeaf()
	{
		return (this.leftTree == null && this.rightTree == null);
	}
	@Override
	public String toString()
	{
		return this.value.toString();
	}
	//
	//	Private Fields
	//
	private final TComparator comparator;
	private AvlTreeNode<T> leftTree;
	private AvlTreeNode<T> rightTree;
	private final T value;
}
