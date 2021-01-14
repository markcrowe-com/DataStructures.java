/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import com.markcrowe.datastructures.BinarySearchNode;
import com.markcrowe.datastructures.BinarySearchTree;

public class TreeInorderPrinter<T>
{
	protected BinarySearchTree<T> tree;

	public TreeInorderPrinter(BinarySearchTree<T> tree)
	{
		this.tree = tree;
	}

	public void println()
	{
		print();
		System.out.println();
	}

	public void print()
	{
		System.out.print(printString());
	}

	private static final String rightAppend;
	private static final String leftAppend;
	private static final String blankAppend;
	private static final String lineAppend;
	static
	{
		int length = 2;
		rightAppend = "┌" + Strings.repeat("─", length);
		leftAppend = "└" + Strings.repeat("─", length);
		blankAppend = Strings.blank(length + 1);
		lineAppend = "│" + Strings.blank(length);
	}

	public String printString()
	{
		StringBuilder string = new StringBuilder(
				printString(tree.getNodes(), "", "", ""));
		string.deleteCharAt(string.length() - 1);
		return string.toString();
	}

	private String printString(BinarySearchNode<T> node, String nodePrefix, String leftPrefix, String rightPrefix)
	{
		BinarySearchNode<T> left = node.getNextLesserValueNode();
		BinarySearchNode<T> right = node.getNextGreaterValueNode();
		String valueString = node.getValue().toString();

		int length = valueString.length();
		if(length % 2 == 0)
		{
			length--;
		}
		length >>= 1;

		String nodeString = "";
		if(right != null)
		{
			rightPrefix += Strings.blank(length);
			nodeString += printString(right,
					rightPrefix + rightAppend,
					rightPrefix + lineAppend,
					rightPrefix + blankAppend);
		}
		nodeString += nodePrefix + valueString + "\n";
		if(left != null)
		{
			leftPrefix += Strings.blank(length);
			nodeString += printString(left,
					leftPrefix + leftAppend,
					leftPrefix + blankAppend,
					leftPrefix + lineAppend);
		}
		return nodeString;
	}

}
