/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.windows;

import com.markcrowe.datastructures.support.BTreePrinter;
import com.markcrowe.datastructures.support.IntegerBinarySearchTreeClass;
import com.markcrowe.datastructures.support.TreeInorderPrinter;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

public class BinarySearchTreeAssignmentJFrame extends javax.swing.JFrame
{

	public BinarySearchTreeAssignmentJFrame()
	{
		this.initComponents();

		this.tree = new IntegerBinarySearchTreeClass();

		this.PrepopulateTreeWithSimpleValues();
		this.PrepopulateTreeWithDesValues();

		DefaultCaret caret2 = (DefaultCaret) displayConsoleJTextArea.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		this.CenterTheFrame();
	}

	private void PrepopulateTreeWithSimpleValues()
	{
		this.tree.clear();
		this.tree.insert(2);
		this.tree.insert(1);
		this.tree.insert(3);

	}
	private void PrepopulateTreeWithDesValues()
	{
		this.tree.clear();
		this.tree.insert(20);
		this.tree.insert(1);
		this.tree.insert(60);
		this.tree.insert(12);
		this.tree.insert(4);
		this.tree.insert(11);
		this.tree.insert(33);
	}

	private void PrintTreeInOrder()
	{
		var text = "Inorder: " + TreeIteratorToString(tree.getInOrderIterator());
		this.PrintConsole(text);
		//JOptionPane.showConfirmDialog(this, this.tree.traverseInOrder());
	}
	public String TreeIteratorToString(Iterator<Integer> iterator)
	{
		String text = iterator.hasNext() ? iterator.next() + "" : "";
		for(; iterator.hasNext();)
		{
			text += ", " + iterator.next();
		}
		return text;
	}

	private void PrintTreePreOrder()
	{
		var text = "Preorder: " + TreeIteratorToString(tree.getPreOrderIterator());
		this.PrintConsole(text);
		TreeInorderPrinter<Integer> printer = new TreeInorderPrinter<>(tree);
		this.graphicConsoleJTextArea.setText(printer.printString());
	}
	private void PrintTreePostOrder()
	{
		var text = "Postorder: " + TreeIteratorToString(tree.getPostOrderIterator());
		this.PrintConsole(text);
	}
	int i = 99;

	public void Randomnumbertotree()
	{
		this.tree.insert(++i);
		this.PrintConsole("inserted into Tree" + i);
	}

	public void Inserttotree()
	{
		String input = JOptionPane.showInputDialog("Enter Value");
		try
		{
			int value = Integer.parseInt(input);
			this.tree.insert(value);
			this.PrintConsole("inserted into Tree" + value);
		}
		catch(Exception exception)
		{
			String message = "Uunable to accept input:";
			this.PrintConsole(message + input);
		}
	}
	private void EmptyTree()
	{
		this.tree.clear();
		this.PrintConsole("Emptied Tree");
	}
	private void ClearDisplayConsole()
	{
		this.displayConsoleJTextArea.setText("");
		this.graphicConsoleJTextArea.setText("");
	}

	public void PrintConsole(String text)
	{
		this.displayConsoleJTextArea.insert(text + System.lineSeparator(), 0);
		this.graphicConsoleJTextArea.setText(BTreePrinter.printNode(tree.getNodes()));
	}
	public final void CenterTheFrame()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	final public IntegerBinarySearchTreeClass tree;

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        InsertRandomButton = new javax.swing.JButton();
        EmptyButton = new javax.swing.JButton();
        InsertButton = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        displayConsoleJTextArea = new javax.swing.JTextArea();
        postOrderPrintButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        preOrderPrintButton = new javax.swing.JButton();
        inOrderPrintButton = new javax.swing.JButton();
        fillSimpleValuesButton = new javax.swing.JButton();
        fillDesValuesButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        graphicConsoleJTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InsertRandomButton.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        InsertRandomButton.setText("Insert Random");
        InsertRandomButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                InsertRandomButtonActionPerformed(evt);
            }
        });

        EmptyButton.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        EmptyButton.setText("Empty Tree");
        EmptyButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                EmptyButtonActionPerformed(evt);
            }
        });

        InsertButton.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        InsertButton.setText("Insert");
        InsertButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                InsertButtonActionPerformed(evt);
            }
        });

        displayConsoleJTextArea.setEditable(false);
        displayConsoleJTextArea.setBackground(new java.awt.Color(0, 0, 0));
        displayConsoleJTextArea.setColumns(20);
        displayConsoleJTextArea.setFont(new java.awt.Font("Courier", 1, 12)); // NOI18N
        displayConsoleJTextArea.setForeground(new java.awt.Color(255, 255, 255));
        displayConsoleJTextArea.setRows(5);
        jScrollPane.setViewportView(displayConsoleJTextArea);

        postOrderPrintButton.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        postOrderPrintButton.setText("Print PostOrder");
        postOrderPrintButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                postOrderPrintButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        ClearButton.setText("Clear The Console ");
        ClearButton.setPreferredSize(new java.awt.Dimension(115, 23));
        ClearButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ClearButtonActionPerformed(evt);
            }
        });

        preOrderPrintButton.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        preOrderPrintButton.setText("Print PreOrder");
        preOrderPrintButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                preOrderPrintButtonActionPerformed(evt);
            }
        });

        inOrderPrintButton.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        inOrderPrintButton.setText("Print InOrder");
        inOrderPrintButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                inOrderPrintButtonActionPerformed(evt);
            }
        });

        fillSimpleValuesButton.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        fillSimpleValuesButton.setText("Simple Tree");
        fillSimpleValuesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                fillSimpleValuesButtonActionPerformed(evt);
            }
        });

        fillDesValuesButton.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        fillDesValuesButton.setText("DES Tree");
        fillDesValuesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                fillDesValuesButtonActionPerformed(evt);
            }
        });

        graphicConsoleJTextArea.setEditable(false);
        graphicConsoleJTextArea.setBackground(new java.awt.Color(0, 0, 0));
        graphicConsoleJTextArea.setColumns(20);
        graphicConsoleJTextArea.setFont(new java.awt.Font("Courier", 1, 12)); // NOI18N
        graphicConsoleJTextArea.setForeground(new java.awt.Color(255, 255, 255));
        graphicConsoleJTextArea.setRows(5);
        jScrollPane1.setViewportView(graphicConsoleJTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fillDesValuesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fillSimpleValuesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmptyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(preOrderPrintButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inOrderPrintButton)
                        .addGap(18, 18, 18)
                        .addComponent(postOrderPrintButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InsertRandomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(InsertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(postOrderPrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inOrderPrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fillDesValuesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fillSimpleValuesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EmptyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(preOrderPrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InsertRandomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InsertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ClearButton, InsertButton, InsertRandomButton});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {EmptyButton, fillDesValuesButton, fillSimpleValuesButton, inOrderPrintButton, postOrderPrintButton, preOrderPrintButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertRandomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertRandomButtonActionPerformed
		this.Randomnumbertotree();
    }//GEN-LAST:event_InsertRandomButtonActionPerformed

    private void InsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButtonActionPerformed
		this.Inserttotree();
    }//GEN-LAST:event_InsertButtonActionPerformed

    private void EmptyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmptyButtonActionPerformed
		this.EmptyTree();
    }//GEN-LAST:event_EmptyButtonActionPerformed

    private void postOrderPrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postOrderPrintButtonActionPerformed
		this.PrintTreePostOrder();
    }//GEN-LAST:event_postOrderPrintButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
		this.ClearDisplayConsole();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void preOrderPrintButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_preOrderPrintButtonActionPerformed
    {//GEN-HEADEREND:event_preOrderPrintButtonActionPerformed
		this.PrintTreePreOrder();
    }//GEN-LAST:event_preOrderPrintButtonActionPerformed

    private void inOrderPrintButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_inOrderPrintButtonActionPerformed
    {//GEN-HEADEREND:event_inOrderPrintButtonActionPerformed
		this.PrintTreeInOrder();
    }//GEN-LAST:event_inOrderPrintButtonActionPerformed

    private void fillSimpleValuesButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fillSimpleValuesButtonActionPerformed
    {//GEN-HEADEREND:event_fillSimpleValuesButtonActionPerformed
		this.PrepopulateTreeWithSimpleValues();
    }//GEN-LAST:event_fillSimpleValuesButtonActionPerformed

    private void fillDesValuesButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fillDesValuesButtonActionPerformed
    {//GEN-HEADEREND:event_fillDesValuesButtonActionPerformed
		this.PrepopulateTreeWithDesValues();
    }//GEN-LAST:event_fillDesValuesButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton EmptyButton;
    private javax.swing.JButton InsertButton;
    private javax.swing.JButton InsertRandomButton;
    private javax.swing.JTextArea displayConsoleJTextArea;
    private javax.swing.JButton fillDesValuesButton;
    private javax.swing.JButton fillSimpleValuesButton;
    private javax.swing.JTextArea graphicConsoleJTextArea;
    private javax.swing.JButton inOrderPrintButton;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton postOrderPrintButton;
    private javax.swing.JButton preOrderPrintButton;
    // End of variables declaration//GEN-END:variables
}
