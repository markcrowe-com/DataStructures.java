/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.badexamples;

import com.markcrowe.datastructures.BinarySearchNode;
import com.markcrowe.datastructures.BinarySearchNodeClass;
import java.util.Comparator;

/**
 *
 * @param <T>
 * @param <TComparator>
 */
public class BinarySearchTreeClass<T, TComparator extends Comparator<T>>
{
	public BinarySearchTreeClass(TComparator comparator)
	{
		this.comparator = comparator;
		this.root = null;
	}
	//
	//	modifiers
	//
	public void clear()
	{
		this.root = null;
	}
	public synchronized void insert(T value)
	{
		if(this.root == null)
		{
			this.root = new BinarySearchNodeClass<>(value, this.comparator);
		}
		else
		{
			this.root.attachValueOnNode(value);
		}
	}
	//
	//	access
	//
	public BinarySearchNode<T> searchForTree(BinarySearchNode<T> root, T value)
	{
		return this.searchForTree(root, value, comparator);
	}
	public BinarySearchNode<T> searchForTree(BinarySearchNode<T> root, T value, Comparator<T> comparator)
	{
		BinarySearchNode<T> candidate;
		candidate = root;
		while((candidate != null) && (value != candidate.getValue()))
		{
			if(this.comparator.compare(value, candidate.getValue()) == -1)
			{
				candidate = candidate.getNextLesserValueNode();
			}
			else
			{
				candidate = candidate.getNextGreaterValueNode();
			}
		}
		return candidate;
	}
	//
	//	Public Methods - Traverse BinarySearchTree
	//

	public synchronized String traverseInOrder()
	{
		return this.TraverseInOrderSupport(this.root);
	}

	public synchronized String traversePreOrder()
	{
		return this.TraversePreOrderSupport(this.root);
	}

	public synchronized String traversePostOrder()
	{
		return this.TraversePostOrderSupport(this.root);
	}
	//
	//	Private Methods - Traverse BinarySearchTree Recursive
	//
	private String TraverseInOrderSupport(BinarySearchNode<T> node)
	{
		if(node == null)
		{
			return "";
		}
		String lowerValue = this.TraverseInOrderSupport(node.getNextLesserValueNode());
		String operand = this.PrintNode(node);
		String higherValue = this.TraverseInOrderSupport(node.getNextGreaterValueNode());

		return this.PrintOrder(lowerValue, operand, higherValue);
	}
	private String TraversePreOrderSupport(BinarySearchNode<T> node)
	{
		if(node == null)
		{
			return "";
		}
		String operand = this.PrintNode(node);
		String lowerValue = this.TraversePreOrderSupport(node.getNextLesserValueNode());
		String higherValue = this.TraversePreOrderSupport(node.getNextGreaterValueNode());

		return this.PrintOrder(operand, lowerValue, higherValue);
	}
	private String TraversePostOrderSupport(BinarySearchNode<T> node)
	{
		if(node == null)
		{
			return "";
		}
		String lowerValue = this.TraversePostOrderSupport(node.getNextLesserValueNode());
		String higherValue = this.TraversePostOrderSupport(node.getNextGreaterValueNode());
		String operand = this.PrintNode(node);

		return this.PrintOrder(lowerValue, higherValue, operand);
	}
	//
	//	Private Methods - Traverse BinarySearchTree Support
	//
	public String PrintNode(BinarySearchNode<T> node)
	{
		return node.getValue() + " : " + this.PrintNodeDetails(node);
	}
	private String PrintNodeDetails(BinarySearchNode<T> node)
	{

		if(node.isLeaf())
		{
			return " LeafNode";
		}
		String leftString = PrintNodeDetailLeft(node.getNextLesserValueNode());
		String rightString = PrintNodeDetailRight(node.getNextGreaterValueNode());

		if(leftString.isEmpty())
		{
			return rightString;
		}
		else
		{
			return leftString + "\t" + rightString;
		}
	}
	private String PrintNodeDetailLeft(BinarySearchNode<T> node)
	{
		if(node == null)
		{
			return "";
		}
		String detail = "Left SubTree : " + node.getValue();
		return detail;
	}
	private String PrintNodeDetailRight(BinarySearchNode<T> node)
	{
		if(node == null)
		{
			return "";
		}
		String detail = "Right SubTree : " + node.getValue();
		return detail;
	}
	public String PrintOrder(String value1, String value2, String value3)
	{
		return value1
				+ System.lineSeparator() + value2
				+ System.lineSeparator() + value3
				+ "";
	}
	//
	//	Private Fields
	//
	private final TComparator comparator;
	private BinarySearchNode<T> root;

	public BinarySearchNode getRoot()
	{
		return this.root;
	}
}
