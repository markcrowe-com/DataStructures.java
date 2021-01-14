/*
 * Copyright (c) 2021 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.Scanner;

public class PrefixTreeCommandApp
{
	public PrefixTreeCommandApp()
	{
		prefixTree = null;
		choice = 0;
		leaveMenu = false;
	}
	//
	//	properties
	//
	public PrefixTree<String> getPrefixTree()
	{
		return prefixTree;
	}
	public void setPrefixTree(PrefixTree<String> prefixTree)
	{
		this.prefixTree = prefixTree;
	}
	//
	//	Methods
	//
	public void run()
	{
		leaveMenu = false;

		InitializeTree();

		do
		{
			choice = DisplayMenu();
			switch(choice)
			{
				case ClearTreeCode ->
					ClearTree();
				case DisplayTreeCode ->
					DisplayTree();
				case ExitProgramCode ->
					ExitProgram();
				case InitializeTreeCode ->
					InitializeTree();
				case InsertValueCode ->
					InsertValue();
				case RemoveValueCode ->
					RemoveValue();
				case SearchTreeCode ->
					SearchTree();
				default ->
					HandleInvalidCode();
			}
		}
		while(!leaveMenu);
	}
	//
	//	Methods
	//
	private void ClearTree()
	{
		prefixTree.clear();

		System.out.println("");
		System.out.println("The Prefix Tree has been cleared.");
		System.out.println("");
	}
	private void DisplayBanner()
	{
		System.out.println("******************************************");
		System.out.println("               Prefix Tree ");
		System.out.println("******************************************");
		System.out.println();
	}
	int DisplayMenu()
	{
		int option;
		DisplayBanner();
		String menu = " " + DisplayTreeCode + " -> Display the Prefix Tree.\n"
				+ " " + InsertValueCode + " -> Insert into Prefix Tree.\n"
				+ " " + SearchTreeCode + " -> Search the Prefix Tree.\n"
				+ " " + RemoveValueCode + " -> Delete from the Prefix Tree.\n"
				+ " " + ClearTreeCode + " -> Clear the Prefix Tree.\n"
				+ " " + InitializeTreeCode + " -> Initialize the Prefix Tree with default values.\n"
				+ " " + ExitProgramCode + " -> Exit.\n\n"
				+ "******************************************\n"
				+ " \n  Enter your choice and press return: \n\n"
				+ "******************************************\n";
		System.out.println(menu);

		Scanner scanner = new Scanner(System.in);
		option = scanner.nextInt();
		return option;
	}
	void DisplayTree()
	{
		DisplayBanner();

		if(prefixTree.isEmpty())
		{
			System.out.println("The Prefix Tree is empty.");
			System.out.println();
			System.out.println();
		}
		else
		{
			System.out.println(prefixTree.toString());
			System.out.println();
			System.out.println();
		}
	}
	void ExitProgram()
	{
		System.out.println("End of Program.");
		leaveMenu = true;
	}
	void HandleInvalidCode()
	{
		System.out.println("Not a Valid Choice. \n Please enter again! ");
	}
	void InitializeTree()
	{
		prefixTree.clear();
		System.out.println("Initialize Prefix Tree:");
		String namesValues[] =
		{
			"Tom", "Una", "Mary", "Zaki", "Tim", "Amy"
		};	// { "Mark", "Ann", "Tom", "Sarah", "Simon" };
		for(String value : namesValues)
		{
			prefixTree.insert(value.toLowerCase(), value);
			System.out.println(" " + value);
		}
		System.out.println(".");
		System.out.println();
	}
	void InsertValue()
	{
		String userInput;
		do
		{
			System.out.println();
			System.out.println("Please enter the name you would like to add: (Enter " + ExitRoutineCode + " to cancel)");

			Scanner scanner = new Scanner(System.in);
			userInput = scanner.nextLine();
			if(!ExitRoutineCode.equals(userInput))
			{
				System.out.println("Now adding " + userInput);
				prefixTree.insert(userInput.toLowerCase(), userInput);
			}
		}
		while(!ExitRoutineCode.equals(userInput));
	}
	void RemoveValue()
	{
		String userInput;
		System.out.println();
		System.out.println("Please enter the name you would like to Delete:");
		Scanner scanner = new Scanner(System.in);
		userInput = scanner.nextLine();

		if(prefixTree.remove(userInput, userInput))
		{
			System.out.println("Removed " + userInput + " from the Prefix Tree.");
		}
		else
		{
			System.out.println("The Prefix Tree does not contain " + userInput + ".");
		}
	}
	void SearchTree()
	{
		String userInput;
		do
		{
			System.out.println();
			System.out.println("Please enter the name you would like to Search: (Enter " + ExitRoutineCode + " to cancel)");
			Scanner scanner = new Scanner(System.in);
			userInput = scanner.nextLine();

			if(!ExitRoutineCode.equals(userInput))
			{
				if(prefixTree.contains(userInput, userInput))
				{
					System.out.println("The Prefix Tree contains " + userInput + ".");
				}
				else
				{
					System.out.println("The Prefix Tree does not contain " + userInput + ".");
				}
			}
		}
		while(!ExitRoutineCode.equals(userInput));
	}
	//
	//	Fields
	//
	private int choice;
	private boolean leaveMenu;
	private PrefixTree<String> prefixTree;
	//
	//	Fields
	//
	private static final String ExitRoutineCode = "0";
	private static final int DisplayTreeCode = 1;
	private static final int InsertValueCode = 2;
	private static final int SearchTreeCode = 3;
	private static final int RemoveValueCode = 4;
	private static final int ClearTreeCode = 5;
	private static final int InitializeTreeCode = 6;
	private static final int ExitProgramCode = 7;
}
