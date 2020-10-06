/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 * @param <T>
 */
public interface BinarySearchNode<T>
{
	//
	//	accessors
	//
	/**
	 *
	 * @return
	 */
	BinarySearchNode<T> getNextGreaterValueNode();
	BinarySearchNode<T> getNextLesserValueNode();
	T getValue();
	//
	//	modifiers
	//
	void attachValueOnNode(T value);
	BinarySearchNode<T> attachLeftValue(T value);
	BinarySearchNode<T> attachRightValue(T value);
	//
	//	Methods
	//
	boolean isLeaf();
}
