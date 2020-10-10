/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.windows;

import com.markcrowe.datastructures.support.Airport;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;

/**
 *
 */
public final class FlightSearchJFrame extends javax.swing.JFrame
{
	public FlightSearchJFrame(WeightedGraphAssignmentJFrame parent)
	{
		this.initComponents();
		this.centerTheFrame();
		this.theblackmainframe = parent;
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.InitializeValues();

	}
	private void InitializeValues()
	{
		for(Airport item : this.theblackmainframe.airportList)
		{
			this.StartPositionComboBox.addItem(item.Name());
			this.EndPositionComboBox.addItem(item.Name());
		}
	}
	private void centerTheFrame()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	private void Action()
	{
		Airport startAirport = this.getAirport(this.StartPositionComboBox);
		Airport endAirport = this.getAirport(this.EndPositionComboBox);

		this.theblackmainframe.Search(startAirport, endAirport);

		this.setVisible(false);
		this.theblackmainframe.setVisible(true);
	}
	private Airport getAirport(JComboBox jComboBox)
	{
		String name = jComboBox.getSelectedItem().toString();
		return this.theblackmainframe.GetAirportByName(name);
	}
	//
	//	fields
	//
	final private WeightedGraphAssignmentJFrame theblackmainframe;

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        StartPositionComboBox = new javax.swing.JComboBox<>();
        EndPositionComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                formWindowClosed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel1.setText("Departure Airport");

        saveButton.setBackground(new java.awt.Color(0, 0, 0));
        saveButton.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Search");
        saveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setText("Arrival Airport");

        StartPositionComboBox.setBackground(new java.awt.Color(0, 0, 0));
        StartPositionComboBox.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        StartPositionComboBox.setForeground(new java.awt.Color(255, 255, 255));
        StartPositionComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                StartPositionComboBoxActionPerformed(evt);
            }
        });

        EndPositionComboBox.setBackground(new java.awt.Color(0, 0, 0));
        EndPositionComboBox.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        EndPositionComboBox.setForeground(new java.awt.Color(255, 255, 255));
        EndPositionComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                EndPositionComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                .addGap(3, 3, 3)
                                .addComponent(StartPositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)
                                .addComponent(EndPositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartPositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(EndPositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
		this.Action();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
		this.theblackmainframe.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		this.theblackmainframe.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void EndPositionComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_EndPositionComboBoxActionPerformed
    {//GEN-HEADEREND:event_EndPositionComboBoxActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_EndPositionComboBoxActionPerformed

    private void StartPositionComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_StartPositionComboBoxActionPerformed
    {//GEN-HEADEREND:event_StartPositionComboBoxActionPerformed

    }//GEN-LAST:event_StartPositionComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> EndPositionComboBox;
    private javax.swing.JComboBox<String> StartPositionComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
