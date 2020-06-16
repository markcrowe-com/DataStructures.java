/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.Comparator;

/**
 * Binary Search Tree
 *
 * @param <T>
 */
public interface BinarySearchTree<T>
{
	//
	//	modifiers
	//
	void Clear();
	void Insert(T d);
	//
	//	access
	//
	BinarySearchNode SearchForTree(BinarySearchNode<T> root, T value);
	BinarySearchNode SearchForTree(BinarySearchNode<T> root, T value, Comparator<T> comparator);
	//
	//	Traverse BinarySearchTree
	//
	String TraverseInOrder();
	String TraversePreOrder();
	String TraversePostOrder();
}
