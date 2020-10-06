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
	void clear();
	void insert(T value);
	//
	//	access
	//
	BinarySearchNode<T> searchForTree(BinarySearchNode<T> root, T value);
	BinarySearchNode<T> searchForTree(BinarySearchNode<T> root, T value, Comparator<T> comparator);
	//
	//	Traverse BinarySearchTree
	//
	String traverseInOrder();
	String traversePreOrder();
	String traversePostOrder();
}
