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
	T Value();
	BinarySearchNode<T> NextGreaterValueNode();
	BinarySearchNode<T> NextLesserValueNode();
	//
	//	modifiers
	//
	void AttachValueOnNode(T value);
	//
	//	Methods
	//
	boolean IsLeaf();
}
