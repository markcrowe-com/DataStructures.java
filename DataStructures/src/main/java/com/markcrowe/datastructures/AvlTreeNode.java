/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 * @param <T>
 */
public interface AvlTreeNode<T> extends BinaryTreeNode<T>
{
	//
	//	accessors
	//
	/**
	 *
	 * @return
	 */
	@Override
	AvlTreeNode<T> getLeftTree();
	@Override
	AvlTreeNode<T> getRightTree();
	AvlTreeNode<T> setLeftTree(AvlTreeNode<T> value);
	AvlTreeNode<T> setRightTree(AvlTreeNode<T> value);

	//
	//	modifiers
	//
	@Override
	AvlTreeNode<T> attachLeftValue(T value);
	@Override
	AvlTreeNode<T> attachRightValue(T value);
}
