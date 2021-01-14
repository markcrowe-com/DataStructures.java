/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 * @param <T>
 */
public interface BinaryTreeNode<T>
{
	//
	//	accessors
	//
	/**
	 *
	 * @return
	 */
	BinaryTreeNode<T> getLeftTree();
	BinaryTreeNode<T> getRightTree();
	T getValue();
	//
	//	modifiers
	//
	BinaryTreeNode<T> attachLeftValue(T value);
	BinaryTreeNode<T> attachRightValue(T value);
	//
	//	Methods
	//
	boolean isLeaf();
}
