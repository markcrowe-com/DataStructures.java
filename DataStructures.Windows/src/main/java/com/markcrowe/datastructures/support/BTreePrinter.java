/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import com.markcrowe.datastructures.BinarySearchNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter
{

	public static <T extends Comparable<?>> String printNode(BinarySearchNode<T> root)
	{
		int maxLevel = BTreePrinter.maxLevel(root);

		return printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T extends Comparable<?>> String printNodeInternal(List<BinarySearchNode<T>> nodes, int level, int maxLevel)
	{

		if(nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
		{
			return "";
		}

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		String text = BTreePrinter.printWhitespaces(firstSpaces);

		var newNodes = new ArrayList<BinarySearchNode<T>>();
		for(BinarySearchNode<T> node : nodes)
		{
			if(node != null)
			{
				text += node.getValue().toString();
				newNodes.add(node.getNextLesserValueNode());
				newNodes.add(node.getNextGreaterValueNode());
			}
			else
			{
				newNodes.add(null);
				newNodes.add(null);
				text += (" ");
			}

			text += BTreePrinter.printWhitespaces(betweenSpaces);
		}
		text += System.lineSeparator();

		for(int i = 1; i <= endgeLines; i++)
		{
			for(int j = 0; j < nodes.size(); j++)
			{
				text += BTreePrinter.printWhitespaces(firstSpaces - i);
				if(nodes.get(j) == null)
				{
					text += BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if(nodes.get(j).getNextLesserValueNode() != null)
				{
					text += ("/");
				}
				else
				{
					text += BTreePrinter.printWhitespaces(1);
				}

				text += BTreePrinter.printWhitespaces(i + i - 1);

				if(nodes.get(j).getNextGreaterValueNode() != null)
				{
					text += ("\\");
				}
				else
				{
					text += BTreePrinter.printWhitespaces(1);
				}

				text += BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			text += System.lineSeparator();

		}

		text += printNodeInternal(newNodes, level + 1, maxLevel);
		return text;
	}

	public static String repeat(String string, int count)
	{
		if(string == null)
		{
			return null;
		}

		StringBuilder builder = new StringBuilder();
		while(count-- > 0)
		{
			builder.append(string);
		}
		return builder.toString();
	}

	public static String printWhitespaces(int count)
	{
		return repeat(" ", count);
	}

	private static void printWhitespaces1(int count)
	{
		for(int i = 0; i < count; i++)
		{
			System.out.print(" ");
		}
	}

	private static <T extends Comparable<?>> int maxLevel(BinarySearchNode<T> node)
	{
		if(node == null)
		{
			return 0;
		}

		return Math.max(BTreePrinter.maxLevel(node.getNextLesserValueNode()), BTreePrinter.maxLevel(node.getNextGreaterValueNode())) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list)
	{
		for(Object object : list)
		{
			if(object != null)
			{
				return false;
			}
		}

		return true;
	}

}
