/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.EmptyStackException;

/**
 * Stack
 *
 * @param <T>
 */
public interface Stack<T> extends Iterable<T>
{
	//
	//	Methods
	//
	/**
	 * Removes all of the elements from this stack. The Stack will be empty after this call returns (unless it throws an
	 * exception).
	 */
	void Clear();
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 *
	 * @return the object at the top of this stack.
	 * @throws EmptyStackException if this stack is empty.
	 */
	T Peek() throws EmptyStackException;
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 *
	 * @return The object at the top of this stack.
	 * @throws EmptyStackException if this stack is empty.
	 */
	T Pop() throws EmptyStackException;
	/**
	 * Pushes an item onto the top of this stack.
	 *
	 * @param item the item to be pushed onto this stack.
	 */
	void Push(T item);
	//
	//	Methods - Status
	//
	/**
	 * Tests if this stack is empty.
	 *
	 * @return {@code true} if and only if this stack contains no items; {@code false} otherwise.
	 */
	Boolean IsEmpty();
	/**
	 * Returns the number of items in this stack.
	 *
	 * @return the number of items in this stack
	 */
	int Size();
}
