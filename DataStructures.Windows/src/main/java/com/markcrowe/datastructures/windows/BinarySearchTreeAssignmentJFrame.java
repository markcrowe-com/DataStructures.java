/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.windows;

import com.markcrowe.datastructures.support.IntegerBinarySearchTreeClass;
import java.awt.Dimension;
import java.awt.Toolkit;
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
		this.tree.Clear();
		this.tree.Insert(2);
		this.tree.Insert(1);
		this.tree.Insert(3);

	}
	private void PrepopulateTreeWithDesValues()
	{
		this.tree.Clear();
		this.tree.Insert(20);
		this.tree.Insert(1);
		this.tree.Insert(60);
		this.tree.Insert(12);
		this.tree.Insert(4);
		this.tree.Insert(11);
		this.tree.Insert(33);
	}

	private void PrintTreeInOrder()
	{
		this.PrintConsole(this.tree.TraverseInOrder());
		JOptionPane.showConfirmDialog(this, this.tree.TraverseInOrder());
	}
	private void PrintTreePreOrder()
	{
		this.PrintConsole(this.tree.TraversePreOrder());
	}
	private void PrintTreePostOrder()
	{
		this.PrintConsole(this.tree.TraversePostOrder());
	}
	int i = 99;

	public void Randomnumbertotree()
	{
		this.tree.Insert(++i);
		this.PrintConsole("inserted into Tree" + i);
	}

	public void Inserttotree()
	{
		String input = JOptionPane.showInputDialog("Enter Value");
		try
		{
			int value = Integer.parseInt(input);
			this.tree.Insert(value);
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
		this.tree.Clear();
		this.PrintConsole("Emptied Tree");
	}
	private void ClearDisplayConsole()
	{
		this.displayConsoleJTextArea.setText("");
	}

	public void PrintConsole(String text)
	{
		this.displayConsoleJTextArea.insert(text + System.lineSeparator(), 0);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
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
                        .addComponent(ClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addGap(18, 18, 18))
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
    private javax.swing.JButton inOrderPrintButton;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton postOrderPrintButton;
    private javax.swing.JButton preOrderPrintButton;
    // End of variables declaration//GEN-END:variables
}
