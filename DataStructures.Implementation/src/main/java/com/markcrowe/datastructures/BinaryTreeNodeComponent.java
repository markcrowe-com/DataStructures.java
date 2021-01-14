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
public class BinaryTreeNodeComponent<T, TComparator extends Comparator<T>> implements BinaryTreeNode<T>
{
	public BinaryTreeNodeComponent(T value)
	{
		this.comparator = null;
		this.leftTree = this.rightTree = null;  // this node has no children
		this.value = value;
	}
	public BinaryTreeNodeComponent(T value, TComparator comparator)
	{
		this.comparator = comparator;
		this.leftTree = this.rightTree = null;  // this node has no children
		this.value = value;
	}
	//
	//	accessors
	//
	@Override
	public BinaryTreeNode<T> getLeftTree()
	{
		return this.leftTree;
	}
	@Override
	public BinaryTreeNode<T> getRightTree()
	{
		return this.rightTree;
	}
	@Override
	public T getValue()
	{
		return this.value;
	}

	public BinaryTreeNode<T> setLeftTree(BinaryTreeNode<T> value)
	{
		this.leftTree = value;
		return this.leftTree;
	}
	public BinaryTreeNode<T> setRightTree(BinaryTreeNode<T> value)
	{
		this.rightTree = value;
		return this.rightTree;
	}
	//
	//	modifiers
	//
	@Override
	public synchronized BinaryTreeNode<T> attachLeftValue(T value)
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
	public synchronized BinaryTreeNode<T> attachRightValue(T value)
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
	private BinaryTreeNodeComponent<T, TComparator> CreateChildNode(T value)
	{
		return new BinaryTreeNodeComponent<>(value, this.comparator);
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
	private BinaryTreeNode<T> leftTree;
	private BinaryTreeNode<T> rightTree;
	private final T value;
}
