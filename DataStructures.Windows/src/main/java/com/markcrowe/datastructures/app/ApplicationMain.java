/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.app;

import com.markcrowe.datastructures.windows.BinarySearchTreeAssignmentJFrame;
import com.markcrowe.datastructures.windows.PriorityQueueAssignmentJFrame;
import com.markcrowe.datastructures.windows.QueueAssignmentJFrame;
import com.markcrowe.datastructures.windows.StackAssignmentJFrame;
import com.markcrowe.datastructures.windows.WeightedGraphAssignmentJFrame;

/**
 *
 */
public class ApplicationMain
{
	public static void main(String args[])
	{
		runBinarySearchTreeAssignment();
		//runPriorityQueueAssignment();
		//runQueueAssignment();
		//runStackAssignment();
		//runWeightedGraphAssignmentJFrame();
	}

	public static void runStackAssignment()
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new StackAssignmentJFrame().setVisible(true);
			}
		});
	}
	public static void runQueueAssignment()
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new QueueAssignmentJFrame().setVisible(true);
			}
		});
	}
	public static void runBinarySearchTreeAssignment()
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new BinarySearchTreeAssignmentJFrame().setVisible(true);
			}
		});
	}
	public static void runPriorityQueueAssignment()
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new PriorityQueueAssignmentJFrame().setVisible(true);
			}
		});
	}
	public static void runWeightedGraphAssignmentJFrame()
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new WeightedGraphAssignmentJFrame().setVisible(true);
			}
		});
	}
}
