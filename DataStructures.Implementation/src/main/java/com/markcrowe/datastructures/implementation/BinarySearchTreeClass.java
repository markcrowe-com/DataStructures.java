/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.implementation;

import com.markcrowe.datastructures.BinarySearchNode;
import com.markcrowe.datastructures.BinarySearchTree;
import java.util.Comparator;

/**
 *
 * @param <T>
 * @param <TComparator>
 */
public class BinarySearchTreeClass<T, TComparator extends Comparator<T>> implements BinarySearchTree<T>
{
	public BinarySearchTreeClass(TComparator comparator)
	{
		this.comparator = comparator;
		this.root = null;
	}
	//
	//	modifiers
	//
	@Override
	public void Clear()
	{
		this.root = null;
	}
	@Override
	public synchronized void Insert(T value)
	{
		if(this.root == null)
		{
			this.root = new BinarySearchNodeClass<>(value, this.comparator);
		}
		else
		{
			this.root.AttachValueOnNode(value);
		}
	}
	//
	//	access
	//

	@Override
	public BinarySearchNode SearchForTree(BinarySearchNode<T> root, T value)
	{
		return this.SearchForTree(root, value, comparator);
	}
	@Override
	public BinarySearchNode SearchForTree(BinarySearchNode<T> root, T value, Comparator<T> comparator)
	{
		BinarySearchNode<T> candidate;
		candidate = root;
		while((candidate != null) && (value != candidate.Value()))
		{
			if(this.comparator.compare(value, candidate.Value()) == -1)
			{
				candidate = candidate.NextLesserValueNode();
			}
			else
			{
				candidate = candidate.NextGreaterValueNode();
			}
		}
		return candidate;
	}
	//
	//	Public Methods - Traverse BinarySearchTree
	//
	@Override
	public synchronized String TraverseInOrder()
	{
		return this.TraverseInOrderSupport(this.root);
	}
	@Override
	public synchronized String TraversePreOrder()
	{
		return this.TraversePreOrderSupport(this.root);
	}
	@Override
	public synchronized String TraversePostOrder()
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
		String lowerValue = this.TraverseInOrderSupport(node.NextLesserValueNode());
		String operand = this.PrintNode(node);
		String higherValue = this.TraverseInOrderSupport(node.NextGreaterValueNode());

		return this.PrintOrder(lowerValue, operand, higherValue);
	}
	private String TraversePreOrderSupport(BinarySearchNode<T> node)
	{
		if(node == null)
		{
			return "";
		}
		String operand = this.PrintNode(node);
		String lowerValue = this.TraversePreOrderSupport(node.NextLesserValueNode());
		String higherValue = this.TraversePreOrderSupport(node.NextGreaterValueNode());

		return this.PrintOrder(operand, lowerValue, higherValue);
	}
	private String TraversePostOrderSupport(BinarySearchNode<T> node)
	{
		if(node == null)
		{
			return "";
		}
		String lowerValue = this.TraversePostOrderSupport(node.NextLesserValueNode());
		String higherValue = this.TraversePostOrderSupport(node.NextGreaterValueNode());
		String operand = this.PrintNode(node);

		return this.PrintOrder(lowerValue, higherValue, operand);
	}
	//
	//	Private Methods - Traverse BinarySearchTree Support
	//
	public String PrintNode(BinarySearchNode<T> node)
	{
		return node.Value() + " : " + this.PrintNodeDetails(node);
	}
	private String PrintNodeDetails(BinarySearchNode<T> node)
	{

		if(node.IsLeaf())
		{
			return " LeafNode";
		}
		String leftString = PrintNodeDetailLeft(node.NextLesserValueNode());
		String rightString = PrintNodeDetailRight(node.NextGreaterValueNode());

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
		String detail = "Left SubTree : " + node.Value();
		return detail;
	}
	private String PrintNodeDetailRight(BinarySearchNode<T> node)
	{
		if(node == null)
		{
			return "";
		}
		String detail = "Right SubTree : " + node.Value();
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
	private BinarySearchNode root;
}
