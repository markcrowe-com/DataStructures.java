/*
 * Copyright (c) 2021 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.Scanner;

public class PrefixTreeCommandApp
{
	public PrefixTreeCommandApp()
	{
		choice = 0;
		leaveMenu = false;
		prefixTree = null;
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

		initializeTree();

		displayMenu();
		do
		{
			choice = getMenuChoice();
			switch(choice)
			{
				case ClearTreeCode ->
					clearTree();
				case DisplayMenuCode ->
					displayMenu();
				case DisplayTreeCode ->
					displayTree();
				case ExitProgramCode ->
					exitProgram();
				case InitializeTreeCode ->
					initializeTree();
				case InsertValueCode ->
					insertValue();
				case RemoveValueCode ->
					removeValue();
				case SearchTreeCode ->
					searchTree();
				default ->
					handleInvalidCode();
			}
		}
		while(!leaveMenu);
	}
	//
	//	Methods
	//
	private void clearTree()
	{
		prefixTree.clear();

		System.out.println("");
		System.out.println("The Prefix Tree has been cleared.");
		System.out.println("");
	}
	private void displayBanner()
	{
		String banner = " ****************** Prefix Tree *******************";
		System.out.println(banner);
	}
	void displayMenu()
	{
		displayBanner();
		String menuString = """
 ****************** Command Menu ******************
 %d Display the Command Menu.
 %d Display the Prefix Tree.
 %d Insert into Prefix Tree.
 %d Search the Prefix Tree.
 %d Delete from the Prefix Tree.
 %d Clear the Prefix Tree.
 %d Initialize the Prefix Tree with default values.
 %d Exit the program.
 **************************************************
""";
		System.out.print(String.format(menuString,
				DisplayMenuCode,
				DisplayTreeCode,
				InsertValueCode,
				SearchTreeCode,
				RemoveValueCode,
				ClearTreeCode,
				InitializeTreeCode,
				ExitProgramCode));
	}
	int getMenuChoice()
	{
		displayBanner();
		System.out.println(String.format(" Enter %d to Display the Command Menu.", DisplayMenuCode));
		System.out.println(" Enter your choice and press return:");

		var scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		return option;
	}
	void displayTree()
	{
		if(prefixTree.isEmpty())
		{
			System.out.println("The Prefix Tree is empty.");
		}
		else
		{
			System.out.println(prefixTree.toString());
		}
	}
	void exitProgram()
	{
		System.out.println("End of Program.");
		leaveMenu = true;
	}
	void handleInvalidCode()
	{
		System.out.println("Not a Valid Choice. \n Please enter again! ");
	}
	void initializeTree()
	{
		prefixTree.clear();
		System.out.println("Initialize Prefix Tree:");
		String namesValues[] =
		{
			"Tom", "Mary", "Amy"
		};
		// { "Tom", "Una", "Mary", "Zaki", "Tim", "Amy" };
		// { "Mark", "Ann", "Tom", "Sarah", "Simon" };
		for(String value : namesValues)
		{
			prefixTree.insert(value.toLowerCase(), value);
			System.out.println(" " + value);
		}
		System.out.println(".");
		System.out.println();
	}
	void insertValue()
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
	void removeValue()
	{
		String userInput;
		System.out.println();
		System.out.println("Please enter the name you would like to Delete:");
		Scanner scanner = new Scanner(System.in);
		userInput = scanner.nextLine();
		userInput = userInput.toLowerCase();

		if(prefixTree.remove(userInput, userInput))
		{
			System.out.println("Removed " + userInput + " from the Prefix Tree.");
		}
		else
		{
			System.out.println("The Prefix Tree does not contain " + userInput + ".");
		}
	}
	void searchTree()
	{
		String userInput;
		do
		{
			System.out.println();
			System.out.println("Please enter the name you would like to Search: (Enter " + ExitRoutineCode + " to cancel)");
			Scanner scanner = new Scanner(System.in);
			userInput = scanner.nextLine();

			userInput = userInput.toLowerCase();
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
	private static final int DisplayMenuCode = 0;
	private static final int DisplayTreeCode = 1;
	private static final int InsertValueCode = 2;
	private static final int SearchTreeCode = 3;
	private static final int RemoveValueCode = 4;
	private static final int ClearTreeCode = 5;
	private static final int InitializeTreeCode = 6;
	private static final int ExitProgramCode = 7;
}
