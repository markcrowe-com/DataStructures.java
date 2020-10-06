/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import com.markcrowe.datastructures.BinarySearchNode;
import com.markcrowe.datastructures.BinarySearchNodeClass;

public class BTreePrinterTest
{

	private static BinarySearchNode<Integer> buildTestTree1()
	{
		var root = new IntegerBinarySearchNode(2);
		var n11 = new IntegerBinarySearchNode(7);
		var n12 = new IntegerBinarySearchNode(5);
		var n21 = new IntegerBinarySearchNode(2);
		var n22 = new IntegerBinarySearchNode(6);
		var n23 = new IntegerBinarySearchNode(3);
		var n24 = new IntegerBinarySearchNode(6);
		var n31 = new IntegerBinarySearchNode(5);
		var n32 = new IntegerBinarySearchNode(8);
		var n33 = new IntegerBinarySearchNode(4);
		var n34 = new IntegerBinarySearchNode(5);
		var n35 = new IntegerBinarySearchNode(8);
		var n36 = new IntegerBinarySearchNode(4);
		var n37 = new IntegerBinarySearchNode(5);
		var n38 = new IntegerBinarySearchNode(8);

		root.setNextLesserValueNode(n11);
		root.setNextGreaterValueNode(n12);

		n11.setNextLesserValueNode(n21);
		n11.setNextGreaterValueNode(n22);
		n12.setNextLesserValueNode(n23);
		n12.setNextGreaterValueNode(n24);

		n21.setNextLesserValueNode(n31);
		n21.setNextGreaterValueNode(n32);

		n22.setNextLesserValueNode(n33);
		n22.setNextGreaterValueNode(n34);

		n23.setNextLesserValueNode(n35);
		n23.setNextGreaterValueNode(n36);

		n24.setNextLesserValueNode(n37);
		n24.setNextGreaterValueNode(n38);

		return root;
	}

	private static BinarySearchNode<Integer> buildTestTree2()
	{
		var root = new IntegerBinarySearchNode(2);
		var n11 = new IntegerBinarySearchNode(7);
		var n12 = new IntegerBinarySearchNode(5);
		var n21 = new IntegerBinarySearchNode(2);
		var n22 = new IntegerBinarySearchNode(6);
		var n23 = new IntegerBinarySearchNode(9);
		var n31 = new IntegerBinarySearchNode(5);
		var n32 = new IntegerBinarySearchNode(8);
		var n33 = new IntegerBinarySearchNode(4);

		root.setNextLesserValueNode(n11);
		root.setNextGreaterValueNode(n12);

		n11.setNextLesserValueNode(n21);
		n11.setNextGreaterValueNode(n22);

		n12.setNextGreaterValueNode(n23);
		n22.setNextLesserValueNode(n31);
		n22.setNextGreaterValueNode(n32);

		n23.setNextLesserValueNode(n33);

		return root;
	}

	public static void main(String args)
	{

		System.out.println(BTreePrinter.printNode(buildTestTree1()));
		System.out.println(BTreePrinter.printNode(buildTestTree2()));

	}
}

final class IntegerBinarySearchNode extends BinarySearchNodeClass<Integer, IntegerComparator>
{
	public IntegerBinarySearchNode(int value)
	{
		super(value, new IntegerComparator());
	}
}
