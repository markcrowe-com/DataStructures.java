/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 * @param <T>
 */
public class PrefixTreeComponent<T> implements PrefixTree<T>
{
	public PrefixTreeComponent(int alphabetSize)
	{
		this.alphabetSize = alphabetSize;
		this.alphabetStartIndex = 'a';
	}
	public PrefixTreeComponent(int alphabetSize, char alphabetStartIndex)
	{
		this.alphabetSize = alphabetSize;
		this.alphabetStartIndex = alphabetStartIndex;
	}
	//
	//	modifiers
	//
	@Override
	public void clear()
	{
		root = null;
	}
	@Override
	public void insert(String key, T value)
	{
		if(isEmpty())
		{
			root = new PrefixTreeNodeComponent<>(this.alphabetSize);
		}
		var iterator = root;
		for(int index = 0; index < key.length(); index++)
		{
			int branchIndex = getIndexForBranch(key.charAt(index));
			if(iterator.getBranch(branchIndex) == null)
			{
				iterator.setBranch(branchIndex, new PrefixTreeNodeComponent<>(this.alphabetSize));
			}
			iterator = iterator.getBranch(branchIndex);
		}
		iterator.addValue(value);
	}

	public boolean remove(String key)
	{
		if(isEmpty())
		{
			return false;
		}
		var iterator = root;
		Stack<PrefixTreeNode<T>> targetPathStack = new LinkedStack<>();
		int branchIndex = 0;
		for(int index = 0; index < key.length(); index++)
		{
			branchIndex = getIndexForBranch(key.charAt(index));
			if(iterator.getBranch(branchIndex) == null)
			{
				break;
			}
			targetPathStack.push(iterator);
			iterator = iterator.getBranch(branchIndex);
		}

		if(iterator == null)
		{
			return false;
		}
		else
		{
			targetPathStack.pop().setBranch(branchIndex, null);
			deleteEmptyNodes(targetPathStack);
			return true;
		}
	}
	void deleteEmptyNodes(Stack<PrefixTreeNode<T>> targetPathStack)
	{
		while(!targetPathStack.isEmpty())
		{
			var node = targetPathStack.pop();
			if(node.isEmpty())
			{
				node.clear();
			}
			else
			{
				break;
			}
		}
	}
	@Override
	public boolean remove(String key, T value)
	{
		if(isEmpty())
		{
			return false;
		}
		return true;
	}
	//
	//	status
	//
	@Override
	public boolean contains(String key, T candidate)
	{
		var current = findNodeByKey(key);
		if(current == null)
		{
			return false;
		}
		return current.containsValue(candidate);
	}
	@Override
	public boolean isEmpty()
	{
		return root == null;
	}
	@Override
	public String toString()
	{
		return toString(root, "", 0);
	}
	public String toString(PrefixTreeNode<T> node, String key, int treeLevel)
	{
		String text = "";
		if(node.isLeaf())
		{
			text += key + System.lineSeparator();
		}
		else
		{
			for(int index = 0; index < alphabetSize; index++)
			{
				var currentNode = node.getBranch(index);
				if(currentNode != null)
				{
					text += toString(node.getBranch(index), key + (char) (index + this.alphabetStartIndex), treeLevel + 1);
				}
			}
		}
		return text;
	}
	//
	//	protected methods
	//
	protected int getIndexForBranch(char key)
	{
		return key - this.alphabetStartIndex;
	}
	protected PrefixTreeNode<T> findNodeByKey(String key)
	{
		if(isEmpty())
		{
			return null;
		}
		var iterator = root;
		for(int index = 0; index < key.length(); index++)
		{
			int branchIndex = getIndexForBranch(key.charAt(index));
			if(iterator.getBranch(branchIndex) == null)
			{
				return null;
			}
			iterator = iterator.getBranch(branchIndex);
		}
		return iterator;
	}
	//
	//	private fields
	//
	private final int alphabetSize;
	private final char alphabetStartIndex;
	private PrefixTreeNode<T> root;
}
