/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.badexamples;

import javax.swing.JOptionPane;

/**
 * Work in Progress
 */
public class TreeBuildTest
{
	private TreeNode root;
	public void delete(int item)
	{
		TreeNode marker = root, parent = null, child = root, temp;

		while((marker != null) && (marker.data != item))
		{
			parent = marker;

			if(item < marker.data)
			{
				marker = marker.NextLowerValueNode();
			}
			else
			{
				marker = marker.right;
			}
		} // end of while

		if(marker == null)
		{
			System.out.println("Cannot delete: item not in tree");
		}
		// Delete root node
		if(parent == null)
		{
			if(marker.right == null)
			{
				root = marker.NextLowerValueNode();
			}
			else if(marker.NextLowerValueNode() == null)
			{
				root = marker.right;
			}
			else
			{
				for(temp = marker, child = marker.NextLowerValueNode(); child.right != null;
						temp = child, child = child.right);
				if(child != marker.NextLowerValueNode())
				{
					temp.right = child.NextLowerValueNode();
					child.left = root.NextLowerValueNode();
				}
				child.right = root.right;
				root = child;
			} // end else
		} // end of if
// Delete internal node
		else if(marker.right == null)
		{
			if(parent.NextLowerValueNode() == marker)
			{
				parent.left = marker.left;
			}
			else
			{
				parent.right = marker.left;
			}
		}

		else if(marker.left == null)
		{
			if(parent.left == marker)
			{
				parent.left = marker.right;
			}
			else
			{
				parent.right = marker.right;
			}
		}
		else
		{
			for(temp = marker, child = marker.left; child.right != null;
					temp = child, child = child.right);
			if(child != marker.left)
			{
				temp.right = child.left;
				child.left = marker.left;
			}

			child.right = marker.right;
			if(parent.left == marker)
			{
				parent.left = child;
			}
			else
			{
				parent.right = child;
			}
		} // end of else
	} // end of delete
	public static TreeNode getNode()
	{
		int d;
		d = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer : (0 to End)"));
		if(d == 0)
		{
			return null;
		}
		else
		{
			TreeNode localnode = new TreeNode(d);
			return localnode;
		}
	} // end of getNode

	/*
	public static void buildTree(Tree tree)
	{
		String outStr = "";
		TreeNode newNode = null;
		int count = 0;
		int level = 0;
		TreeNode lastNode[] = new TreeNode[MAXHEIGHT];
		for(level = 0; level < MAXHEIGHT; level++)
		{
			lastNode[level] = null;
		}
		newNode = getNode();
		while(newNode != null)
		{
			tree.insert(newNode, ++count, lastNode);
			newNode = getNode();
		} // end of while
		newNode = tree.findRoot(lastNode);
		tree.connectSubtrees(lastNode);
		outStr = tree.printTree(newNode);
		JOptionPane.showMessageDialog(null, outStr, "Build a BST", JOptionPane.INFORMATION_MESSAGE);
	} // end of buildTree
	 */
	public void insert(TreeNode newnode, int count, TreeNode lastnode[])
	{
		int level = Power2(count) + 1;
		newnode.right = null;
		newnode.left = lastnode[level - 1];
		lastnode[level] = newnode;
		if((lastnode[level + 1] != null) && (lastnode[level + 1].right == null))
		{
			lastnode[level + 1].right = newnode;
		}
	} // end of insert

	public int Power2(int x)
	{
		int level;

		for(level = 0; ((x) / 2 * 2) == x; level++)
		{
			x /= 2;
		}
		return level;
	}
	public TreeNode findRoot(TreeNode lastnode[])
	{
		int level;
		for(level = MAXHEIGHT - 1; level > 0 && lastnode[level] == null; level--);
		if(level <= 0)
		{
			return null;
		}
		else
		{
			return lastnode[level];
		}
	}	// end of findRoot
	public void connectSubtrees(TreeNode lastnode[])
	{
		TreeNode p;
		int level, templevel;
		for(level = MAXHEIGHT - 1; level > 2 && lastnode[level] == null; level--);
		while(level > 2)
		{
			if(lastnode[level].right != null)
			{
				level--;
			}
			else
			{
				p = lastnode[level].left;
				templevel = level - 1;
				do
				{
					p = p.right;
				}
				while((p != null) && (p == lastnode[--templevel]));
				lastnode[level].right = lastnode[templevel];
				level = templevel;
			} // end of else
		} // end of while
	} // end of connectSubtrees
	static int MAXHEIGHT = 5;
}

class TreeNode
{
	// package access members
	TreeNode left;   // left node
	int data;        // data item	          - data will differ depending on the application.
	TreeNode right;  // right node
	// Constructor: initialize data to d and make this a leaf node
	public TreeNode(int d)
	{
		data = d;
		left = right = null;  // this node has no children
	}
	// Insert a TreeNode into a Tree that contains nodes.( Ignore duplicate values).
	public TreeNode NextLowerValueNode()
	{
		return this.left;
	}
	public TreeNode NextHigherValueNode()
	{
		return this.right;
	}
	public synchronized void insert(int d)
	{
		if(d < data)
		{
			if(left == null)
			{
				left = new TreeNode(d);
			}
			else
			{
				left.insert(d);
			}
		}
		else if(d > data)
		{
			if(right == null)
			{
				right = new TreeNode(d);
			}
			else
			{
				right.insert(d);
			}
		}
	}
}
