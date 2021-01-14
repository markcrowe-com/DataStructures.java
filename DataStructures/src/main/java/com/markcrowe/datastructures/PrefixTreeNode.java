/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.List;

/**
 * @param <T>
 */
public interface PrefixTreeNode<T>
{
	//
	//	accessors
	//
	PrefixTreeNode<T> getBranch(int index);
	int getBranchCount();
	List<T> getValues();
	//
	//	modifiers
	//
	boolean addValue(T value);
	boolean removeValue(T value);
	void setBranch(int index, PrefixTreeNode<T> value);
	//
	//	Methods
	//
	public void clear();
	boolean containsValue(T candidate);
	boolean isEmpty();
	boolean isLeaf();
}
