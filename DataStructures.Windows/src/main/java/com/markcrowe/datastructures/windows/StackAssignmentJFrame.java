/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.windows;

import com.markcrowe.datastructures.support.StringLinkedStack;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import javax.swing.JOptionPane;

public final class StackAssignmentJFrame extends javax.swing.JFrame
{
	public StackAssignmentJFrame()
	{
//		java.util.Stack<String> mystatck = null;
//		mystatck.pop();

		this.initComponents();
		//
		//	stack
		//
		this.stack = new StringLinkedStack();
		//
		//	Prepopulation
		//
		this.PrepopulateStack();
		//
		//	Custom GUI
		//
		this.CenterTheFrame();
	}
	private void PrepopulateStack()
	{
		stack.push("6");
		stack.push("3");
		stack.push("2");
		stack.push("1");
	}
	public void CenterTheFrame()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	private void PrintConsole(String text)
	{
		this.displayConsoleJTextArea.append(text + System.lineSeparator());
	}
	private void ClearDisplayConsole()
	{
		System.out.println("Clearing Display Console.");
		this.displayConsoleJTextArea.setText("");
	}
	private void PrintSize()
	{
		int size = this.stack.size();
		this.PrintConsole("The size of the Stack is: " + size);
	}
	private void IsStackEmpty()
	{
		if(stack.isEmpty())
		{
			this.PrintConsole("Nothing in Stack");
		}
		else
		{
			this.PrintConsole("There are nodes in the stack");
		}
	}
	private void PopStack()
	{
		if(stack.isEmpty())
		{
			this.PrintConsole("Nothing in Stack Cannot Pop");
		}
		else
		{
			String element = this.stack.pop();
			this.PrintConsole("Popped Stack Result = " + element);
		}
	}
	private void PushStack()
	{
		String element = JOptionPane.showInputDialog("Enter Node Details");
		this.stack.push(element);
		this.PrintConsole("Pushed Stack Result = " + element);
	}
	private void ClearStack()
	{
		if(stack.isEmpty())
		{
			this.PrintConsole("Nothing in Stack Clear Unsuccessful");
		}
		else
		{
			this.stack.clear();
			this.PrintConsole("Stack has been cleared");
		}
	}
	private void PeekStack()
	{
		if(stack.isEmpty())
		{
			this.PrintConsole("Nothing in Stack Cannot Check");
		}
		else
		{
			String element = this.stack.peek();
			this.PrintConsole("Element at the top = " + element);
		}
	}
	private void SearchStack()
	{
		String Result = "Found nothing";
		String searchitem = JOptionPane.showInputDialog("Enter a value");
		for(String element : this.stack)
		{
			if(searchitem.compareTo(element) == 0)
			{
				Result = "Found one!";
				break;
			}

		}
		this.PrintConsole(Result);
	}
	private void PrintStack()
	{
		String text = "{";
		Iterator<String> iterator = this.stack.iterator();
		//
		//  case1
		//
		if(iterator.hasNext())
		{
			text += iterator.next();
		}
		//
		// case n
		//
		while(iterator.hasNext())
		{
			text += ", " + iterator.next();
		}
		text += "}";
		//
		//output
		//
		this.PrintConsole("Stack = " + text);
	}
	//
	//	Private Fields
	//
	private final StringLinkedStack stack;

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        checkIsEmptyButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        currentButton = new javax.swing.JButton();
        sizeButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        displayConsoleJTextArea = new javax.swing.JTextArea();
        clearConsoleButton = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        checkIsEmptyButton.setText("Is Empty");
        checkIsEmptyButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkIsEmptyButtonActionPerformed(evt);
            }
        });

        insertButton.setText("INSERT");
        insertButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                insertButtonActionPerformed(evt);
            }
        });

        removeButton.setText("REMOVE");
        removeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removeButtonActionPerformed(evt);
            }
        });

        currentButton.setText("CURRENT TOP");
        currentButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                currentButtonActionPerformed(evt);
            }
        });

        sizeButton.setText("CURRENT SIZE");
        sizeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sizeButtonActionPerformed(evt);
            }
        });

        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearButtonActionPerformed(evt);
            }
        });

        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                searchButtonActionPerformed(evt);
            }
        });

        printButton.setText("PRINT");
        printButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                printButtonActionPerformed(evt);
            }
        });

        displayConsoleJTextArea.setColumns(20);
        displayConsoleJTextArea.setRows(5);
        jScrollPane.setViewportView(displayConsoleJTextArea);

        clearConsoleButton.setText("Clear console");
        clearConsoleButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearConsoleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkIsEmptyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(clearConsoleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkIsEmptyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(clearConsoleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkIsEmptyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkIsEmptyButtonActionPerformed
		this.IsStackEmpty();
    }//GEN-LAST:event_checkIsEmptyButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
		this.PushStack();
    }//GEN-LAST:event_insertButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
		this.PopStack();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void clearConsoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearConsoleButtonActionPerformed
		this.ClearDisplayConsole();
    }//GEN-LAST:event_clearConsoleButtonActionPerformed

    private void currentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentButtonActionPerformed
		this.PeekStack();
    }//GEN-LAST:event_currentButtonActionPerformed

    private void sizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeButtonActionPerformed
		this.PrintSize();
    }//GEN-LAST:event_sizeButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
		this.ClearStack();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
		this.PrintStack();
    }//GEN-LAST:event_printButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
		this.SearchStack();
    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkIsEmptyButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton clearConsoleButton;
    private javax.swing.JButton currentButton;
    private javax.swing.JTextArea displayConsoleJTextArea;
    private javax.swing.JButton insertButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton printButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton sizeButton;
    // End of variables declaration//GEN-END:variables
}
