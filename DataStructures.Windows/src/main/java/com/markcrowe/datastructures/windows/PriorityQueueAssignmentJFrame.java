/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.windows;

import com.markcrowe.datastructures.support.Patient;
import com.markcrowe.datastructures.support.PatientPriorityQueue;
import java.awt.Color;
import javax.swing.text.DefaultCaret;

public final class PriorityQueueAssignmentJFrame extends javax.swing.JFrame
{

	final public PatientPriorityQueue priorityqueue;
	private final PriorityQueueAssignmentPatientInputJFrame theblackinsertpane;

	public PriorityQueueAssignmentJFrame()
	{
		this.theblackinsertpane = new PriorityQueueAssignmentPatientInputJFrame(this);
		getContentPane().setBackground(Color.BLACK);
		initComponents();

		DefaultCaret caret2 = (DefaultCaret) patientWaitingListDisplayJTextArea.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

		int max = 10;

		this.priorityqueue = new PatientPriorityQueue(max);
	}
	//
	//	Methods
	//
	public void PrepopulateWithDesValues()
	{
		this.priorityqueue.Enqueue(new Patient("tom", 2));
		this.priorityqueue.Enqueue(new Patient("mary", 1));
		this.priorityqueue.Enqueue(new Patient("Pat", 5));
		this.priorityqueue.Enqueue(new Patient("sarah", 4));
		this.priorityqueue.Enqueue(new Patient("Paul", 2));

		/*this.priorityqueue.Enqueue(new Patient("tom", 5));
		this.priorityqueue.Enqueue(new Patient("mary", 4));
		this.priorityqueue.Enqueue(new Patient("des", 1));
		this.priorityqueue.Enqueue(new Patient("sarah", 2));*/
	}
	public void PrepopulateWithLitValues()
	{
		this.priorityqueue.Enqueue(new Patient("Des", 1));
		this.priorityqueue.Enqueue(new Patient("Pat", 2));
		this.priorityqueue.Enqueue(new Patient("Paul", 3));
		this.priorityqueue.Enqueue(new Patient("Ita", 2));
		this.priorityqueue.Enqueue(new Patient("Alan", 4));
		this.priorityqueue.Enqueue(new Patient("Janic", 3));
		this.priorityqueue.Enqueue(new Patient("Gerry", 5));
	}
	public void PrintConsole(String text)
	{
		//this.noticeBoardJTextArea.insert(text + "\n", 0);
		this.noticeBoardJTextArea.append(System.lineSeparator() + text);
	}
	public void RePrintPatientWaitingList()
	{
		String text = "";
		String title = "\t     Current Waiting List \n \n";
		String headings = "Patient Name \t \t \t Priority";
		text += title;
		text += headings;
		//
		//  Print Prioperty Queue
		//
		int length = this.priorityqueue.ItemsCount();
		Object[] items = this.priorityqueue.Items();

		Patient item;

		for(int i = 0; i < length; i++)
		{
			item = (Patient) items[(i)];
			text += "\n" + item.Name() + "\t\t" + item.Priority();
		}
		this.patientWaitingListDisplayJTextArea.setText(text);
	}
	private void AddNewPatient()
	{
		this.theblackinsertpane.setVisible(true);
		this.setVisible(false);
	}
	private void CallNextPatient()
	{
		if(priorityqueue.IsEmpty())
		{
			this.PrintConsole("All Patients seen");
		}
		else
		{
			Patient item = this.priorityqueue.Dequeue();
			this.PrintConsole("Patient " + item.Name() + " seen.");
			this.RePrintPatientWaitingList();
		}
	}
	private void DesButtonAction()
	{
		this.priorityqueue.ClearItems();
		this.PrepopulateWithDesValues();
		this.RePrintPatientWaitingList();
	}
	private void LITButtonAction()
	{
		this.priorityqueue.ClearItems();
		this.PrepopulateWithLitValues();
		this.RePrintPatientWaitingList();
	}
	private void ClearPatientButtonAction()
	{
		priorityqueue.ClearItems();
		RePrintPatientWaitingList();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        AddNewPatientButton = new javax.swing.JButton();
        CallNextPatientButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientWaitingListDisplayJTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        noticeBoardJTextArea = new javax.swing.JTextArea();
        DesButton = new javax.swing.JButton();
        LITButton = new javax.swing.JButton();
        ClearPatientButton = new javax.swing.JButton();
        ClearPatientButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddNewPatientButton.setBackground(new java.awt.Color(0, 0, 0));
        AddNewPatientButton.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        AddNewPatientButton.setForeground(new java.awt.Color(255, 255, 255));
        AddNewPatientButton.setText("Add New Patient");
        AddNewPatientButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddNewPatientButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AddNewPatientButtonActionPerformed(evt);
            }
        });

        CallNextPatientButton.setBackground(new java.awt.Color(0, 0, 0));
        CallNextPatientButton.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        CallNextPatientButton.setForeground(new java.awt.Color(255, 255, 255));
        CallNextPatientButton.setText("Call Next Patient");
        CallNextPatientButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CallNextPatientButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CallNextPatientButtonActionPerformed(evt);
            }
        });

        patientWaitingListDisplayJTextArea.setEditable(false);
        patientWaitingListDisplayJTextArea.setBackground(new java.awt.Color(0, 0, 0));
        patientWaitingListDisplayJTextArea.setColumns(20);
        patientWaitingListDisplayJTextArea.setFont(new java.awt.Font("Courier", 1, 12)); // NOI18N
        patientWaitingListDisplayJTextArea.setForeground(new java.awt.Color(255, 255, 255));
        patientWaitingListDisplayJTextArea.setRows(5);
        jScrollPane2.setViewportView(patientWaitingListDisplayJTextArea);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Courier New", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Patients that are waiting for a doctor");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Courier New", 1, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Notices");

        noticeBoardJTextArea.setEditable(false);
        noticeBoardJTextArea.setBackground(new java.awt.Color(0, 0, 0));
        noticeBoardJTextArea.setColumns(20);
        noticeBoardJTextArea.setFont(new java.awt.Font("Courier", 1, 12)); // NOI18N
        noticeBoardJTextArea.setForeground(new java.awt.Color(255, 255, 255));
        noticeBoardJTextArea.setRows(5);
        jScrollPane3.setViewportView(noticeBoardJTextArea);

        DesButton.setBackground(new java.awt.Color(0, 0, 0));
        DesButton.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        DesButton.setForeground(new java.awt.Color(255, 255, 255));
        DesButton.setText("Des Patients");
        DesButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                DesButtonActionPerformed(evt);
            }
        });

        LITButton.setBackground(new java.awt.Color(0, 0, 0));
        LITButton.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        LITButton.setForeground(new java.awt.Color(255, 255, 255));
        LITButton.setText("LIT Patients");
        LITButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LITButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                LITButtonActionPerformed(evt);
            }
        });

        ClearPatientButton.setBackground(new java.awt.Color(0, 0, 0));
        ClearPatientButton.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        ClearPatientButton.setForeground(new java.awt.Color(255, 255, 255));
        ClearPatientButton.setText("Clear Patients");
        ClearPatientButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClearPatientButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ClearPatientButtonActionPerformed(evt);
            }
        });

        ClearPatientButton1.setBackground(new java.awt.Color(0, 0, 0));
        ClearPatientButton1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        ClearPatientButton1.setForeground(new java.awt.Color(255, 255, 255));
        ClearPatientButton1.setText("Clear Screen");
        ClearPatientButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClearPatientButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ClearPatientButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LITButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClearPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddNewPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CallNextPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(197, 197, 197)
                        .addComponent(ClearPatientButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddNewPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CallNextPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ClearPatientButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LITButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(DesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddNewPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNewPatientButtonActionPerformed
		this.AddNewPatient();
    }//GEN-LAST:event_AddNewPatientButtonActionPerformed

    private void CallNextPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CallNextPatientButtonActionPerformed
		this.CallNextPatient();
    }//GEN-LAST:event_CallNextPatientButtonActionPerformed

    private void DesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesButtonActionPerformed
		this.DesButtonAction();
    }//GEN-LAST:event_DesButtonActionPerformed

    private void LITButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LITButtonActionPerformed
		this.LITButtonAction();
    }//GEN-LAST:event_LITButtonActionPerformed

    private void ClearPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearPatientButtonActionPerformed
		this.ClearPatientButtonAction();
    }//GEN-LAST:event_ClearPatientButtonActionPerformed

    private void ClearPatientButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ClearPatientButton1ActionPerformed
    {//GEN-HEADEREND:event_ClearPatientButton1ActionPerformed
		this.noticeBoardJTextArea.setText("");
    }//GEN-LAST:event_ClearPatientButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNewPatientButton;
    private javax.swing.JButton CallNextPatientButton;
    private javax.swing.JButton ClearPatientButton;
    private javax.swing.JButton ClearPatientButton1;
    private javax.swing.JButton DesButton;
    private javax.swing.JButton LITButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea noticeBoardJTextArea;
    private javax.swing.JTextArea patientWaitingListDisplayJTextArea;
    // End of variables declaration//GEN-END:variables

}
