/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.windows;

import com.markcrowe.datastructures.support.Employee;
import com.markcrowe.datastructures.support.EmployeeLinkedQueue;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

/**
 *
 */
public final class QueueAssignmentJFrame extends javax.swing.JFrame
{
	public QueueAssignmentJFrame()
	{
		this.initComponents();
		//
		//	queue
		//
		this.queue = new EmployeeLinkedQueue();
		//
		//	Prepopulation
		//
		this.PrepopulateQueue();
		//
		//	Custom GUI
		//
		DefaultCaret caret2 = (DefaultCaret) displayConsoleJTextArea.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		this.employee = new QueueAssignmentInputJFrame(this);
		this.CenterTheFrame();
	}
	private void PrepopulateQueue()
	{
		this.queue.QueueItem(new Employee("1", "John", "Rickard", "24"));
		this.queue.QueueItem(new Employee("2", "Dave", "Boyle", "30"));
		this.queue.QueueItem(new Employee("3", "Kevin", "O'Farrell", "23"));
		this.queue.QueueItem(new Employee("4", "Sam", "dooley", "45"));
		this.queue.QueueItem(new Employee("5", "George", "Rickard", "24"));
		this.queue.QueueItem(new Employee("6", "Matt", "Bellamy", "37"));
		this.queue.QueueItem(new Employee("7", "James", "Dolan", "60"));
	}
	private void ClearQueue()
	{
		if(this.HandleQueueIsEmpty());
		else
		{
			this.queue.Clear();
			this.PrintConsole("The Queue has been cleared.");
		}
	}
	private void PrintSize()
	{
		int size = this.queue.Size();
		this.PrintConsole("The size of the queue is: " + size);
	}
	private void PrintQueue()
	{
		if(this.HandleQueueIsEmpty());
		else
		{
			String Result = "Printing the Queue:" + System.lineSeparator();
			Iterator<Employee> iterator = this.queue.iterator();

			if(iterator.hasNext())
			{
				Result += "Top  of queue: " + iterator.next().toString();
			}

			int size = this.queue.Size() - 1;
			for(int index = 1; index < size; index++)
			{
				Result += System.lineSeparator() + "Next in queue: " + iterator.next().toString();
			}

			if(iterator.hasNext())
			{
				Result += System.lineSeparator() + "Back of queue: " + iterator.next().toString() + System.lineSeparator();
			}
			this.PrintConsole(Result);
		}
	}
	public void DeQueueItem()
	{
		if(this.HandleQueueIsEmpty());
		else
		{
			Employee item = this.queue.Dequeue();
			this.PrintConsole("Dequeued Employee: " + item.toString() + System.lineSeparator());
		}
	}
	public void QueueItem()
	{
		this.employee.RandomValues();
		this.employee.setVisible(true);
		this.setVisible(false);
	}
	public void SearchQueue()
	{
		if(this.HandleQueueIsEmpty());
		else
		{
			String searchitem = JOptionPane.showInputDialog("Enter an Employee Number");
			String resultText = "No Employee was found with an number " + searchitem + " was found in the queue.";

			int index = 0;
			for(Employee element : this.queue)
			{
				if(element.getNum().compareTo(searchitem) == 0)
				{
					resultText = "Employee of " + element.toString() + " was found at index " + index;
					break;
				}
				index++;
			}
			this.PrintConsole(resultText);
		}
	}
	public void PeekAtFirstItem()
	{
		if(this.HandleQueueIsEmpty());
		else
		{
			Employee item = this.queue.PeekAtFirstItem();
			this.PrintConsole("The First Item in the queue is:" + item.toString());
		}
	}
	public void PeekAtLastItem()
	{
		if(this.HandleQueueIsEmpty());
		else
		{
			Employee item = this.queue.PeekAtLastItem();
			this.PrintConsole("The Last Item in the queue is:" + item.toString());
		}
	}
	private void ClearDisplayConsole()
	{
		System.out.println("Clearing Display Console.");
		this.displayConsoleJTextArea.setText("");
	}
	public void PrintConsole(String text)
	{
		this.displayConsoleJTextArea.insert(text + System.lineSeparator(), 0);
	}
	public boolean HandleQueueIsEmpty()
	{
		boolean isEmpty = queue.IsEmpty();
		if(isEmpty)
		{
			this.PrintConsole("The Queue is Empty.");
		}
		return isEmpty;
	}
	public void CenterTheFrame()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	//
	//	fields
	//
	final public EmployeeLinkedQueue queue;
	final private QueueAssignmentInputJFrame employee;

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        itemQueueButton = new javax.swing.JButton();
        deQueueButton = new javax.swing.JButton();
        searchQueueButton = new javax.swing.JButton();
        printQueueSize = new javax.swing.JButton();
        peekAtFirstItemButton = new javax.swing.JButton();
        peekAtLastItemButton = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        displayConsoleJTextArea = new javax.swing.JTextArea();
        printQueueButton = new javax.swing.JButton();
        clearDisplayConsoleButton = new javax.swing.JButton();
        clearQueueButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        itemQueueButton.setText("Queue");
        itemQueueButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                itemQueueButtonActionPerformed(evt);
            }
        });

        deQueueButton.setText("DeQueue");
        deQueueButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deQueueButtonActionPerformed(evt);
            }
        });

        searchQueueButton.setText("Find");
        searchQueueButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                searchQueueButtonActionPerformed(evt);
            }
        });

        printQueueSize.setText("Size");
        printQueueSize.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                printQueueSizeActionPerformed(evt);
            }
        });

        peekAtFirstItemButton.setText("Peek At First Item");
        peekAtFirstItemButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                peekAtFirstItemButtonActionPerformed(evt);
            }
        });

        peekAtLastItemButton.setText("Peek At Last Item");
        peekAtLastItemButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                peekAtLastItemButtonActionPerformed(evt);
            }
        });

        displayConsoleJTextArea.setEditable(false);
        displayConsoleJTextArea.setBackground(new java.awt.Color(0, 0, 0));
        displayConsoleJTextArea.setColumns(20);
        displayConsoleJTextArea.setFont(new java.awt.Font("Courier", 1, 12)); // NOI18N
        displayConsoleJTextArea.setForeground(new java.awt.Color(255, 255, 255));
        displayConsoleJTextArea.setRows(5);
        jScrollPane.setViewportView(displayConsoleJTextArea);

        printQueueButton.setText("Print");
        printQueueButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                printQueueButtonActionPerformed(evt);
            }
        });

        clearDisplayConsoleButton.setText("Clear Console ");
        clearDisplayConsoleButton.setPreferredSize(new java.awt.Dimension(115, 23));
        clearDisplayConsoleButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearDisplayConsoleButtonActionPerformed(evt);
            }
        });

        clearQueueButton.setText("Clear");
        clearQueueButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearQueueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clearDisplayConsoleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(itemQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(peekAtFirstItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(peekAtLastItemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peekAtFirstItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peekAtLastItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearDisplayConsoleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	//
	//	event handlers
	//
    private void searchQueueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchQueueButtonActionPerformed
		this.SearchQueue();
    }//GEN-LAST:event_searchQueueButtonActionPerformed

    private void itemQueueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQueueButtonActionPerformed
		this.QueueItem();
    }//GEN-LAST:event_itemQueueButtonActionPerformed

    private void deQueueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deQueueButtonActionPerformed
		this.DeQueueItem();
    }//GEN-LAST:event_deQueueButtonActionPerformed

    private void peekAtFirstItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peekAtFirstItemButtonActionPerformed
		this.PeekAtFirstItem();
    }//GEN-LAST:event_peekAtFirstItemButtonActionPerformed

    private void peekAtLastItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peekAtLastItemButtonActionPerformed
		this.PeekAtLastItem();
    }//GEN-LAST:event_peekAtLastItemButtonActionPerformed

    private void printQueueSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printQueueSizeActionPerformed
		this.PrintSize();
    }//GEN-LAST:event_printQueueSizeActionPerformed

    private void printQueueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printQueueButtonActionPerformed
		this.PrintQueue();
    }//GEN-LAST:event_printQueueButtonActionPerformed

    private void clearDisplayConsoleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDisplayConsoleButtonActionPerformed
		this.ClearDisplayConsole();
    }//GEN-LAST:event_clearDisplayConsoleButtonActionPerformed

    private void clearQueueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearQueueButtonActionPerformed
		this.ClearQueue();
    }//GEN-LAST:event_clearQueueButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearDisplayConsoleButton;
    private javax.swing.JButton clearQueueButton;
    private javax.swing.JButton deQueueButton;
    private javax.swing.JTextArea displayConsoleJTextArea;
    private javax.swing.JButton itemQueueButton;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton peekAtFirstItemButton;
    private javax.swing.JButton peekAtLastItemButton;
    private javax.swing.JButton printQueueButton;
    private javax.swing.JButton printQueueSize;
    private javax.swing.JButton searchQueueButton;
    // End of variables declaration//GEN-END:variables
}
