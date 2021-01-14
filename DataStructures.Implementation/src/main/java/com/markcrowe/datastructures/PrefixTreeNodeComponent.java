/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 */
public class PrefixTreeNodeComponent<T> implements PrefixTreeNode<T>
{
	@SuppressWarnings("unchecked")
	public PrefixTreeNodeComponent(int size)
	{
		branches = (PrefixTreeNode<T>[]) new PrefixTreeNode[size];
		values = new ArrayList<>();
	}
	//
	//	accessors
	//
	@Override
	public PrefixTreeNode<T> getBranch(int index)
	{
		return this.branches[index];
	}
	@Override
	public int getBranchCount()
	{
		return this.branches.length;
	}
	@Override
	public List<T> getValues()
	{
		return this.values;
	}
	//
	//	modifiers
	//
	public void setBranch(int index, PrefixTreeNode<T> value)
	{
		this.branches[index] = value;
	}
	@Override
	public boolean addValue(T value)
	{
		return values.add(value);
	}
	@Override
	public boolean removeValue(T value)
	{
		return values.remove(value);
	}
	//
	//	Methods
	//
	@Override
	public void clear()
	{
		for(int index = 0; index < branches.length; index++)
		{
			branches[index] = null;
		}
		values.clear();
	}
	@Override
	public boolean containsValue(T value)
	{
		return values.contains(value);
	}
	@Override
	public boolean isLeaf()
	{
		for(PrefixTreeNode<T> branch : branches)
		{
			if(branch != null)
			{
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean isEmpty()
	{
		return values.isEmpty() && isLeaf();
	}
	//
	//	private fields
	//
	private final PrefixTreeNode<T>[] branches;
	private final List<T> values;
}
