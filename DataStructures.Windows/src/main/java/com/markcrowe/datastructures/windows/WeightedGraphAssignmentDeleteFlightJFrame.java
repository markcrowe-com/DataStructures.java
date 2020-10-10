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
public final class WeightedGraphAssignmentDeleteFlightJFrame extends javax.swing.JFrame
{
	public WeightedGraphAssignmentDeleteFlightJFrame(WeightedGraphAssignmentJFrame parent)
	{
		this.initComponents();
		this.CenterTheFrame();
		this.theblackmainframe = parent;
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.InitializeValues();

	}
	public void InitializeValues()
	{
		for(Airport item : this.theblackmainframe.airportList)
		{
			this.startPositionComboBox.addItem(item.Name());
			this.endPositionComboBox.addItem(item.Name());
		}
	}
	private void CenterTheFrame()
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	private void DeleteAction()
	{
		Airport startAirport = this.getAirport(this.startPositionComboBox);
		Airport endAirport = this.getAirport(this.endPositionComboBox);

		this.theblackmainframe.RemoveAirport(startAirport, endAirport);

		this.setVisible(false);
		this.theblackmainframe.setVisible(true);
	}
	private Airport getAirport(JComboBox jComboBox)
	{
		String name = jComboBox.getSelectedItem().toString();
		return this.theblackmainframe.GetAirportByName(name);
	}

	final private WeightedGraphAssignmentJFrame theblackmainframe;

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        startPositionComboBox = new javax.swing.JComboBox<>();
        endPositionComboBox = new javax.swing.JComboBox<>();

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

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel1.setText("Departure Airport");

        saveButton.setBackground(new java.awt.Color(0, 0, 0));
        saveButton.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Delete");
        saveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setText("Arrival Airport");

        startPositionComboBox.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        startPositionComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startPositionComboBoxActionPerformed(evt);
            }
        });

        endPositionComboBox.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        endPositionComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                endPositionComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(startPositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(endPositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startPositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(endPositionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
		this.DeleteAction();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
		this.theblackmainframe.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
		this.theblackmainframe.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void endPositionComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_endPositionComboBoxActionPerformed
    {//GEN-HEADEREND:event_endPositionComboBoxActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_endPositionComboBoxActionPerformed

    private void startPositionComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_startPositionComboBoxActionPerformed
    {//GEN-HEADEREND:event_startPositionComboBoxActionPerformed

    }//GEN-LAST:event_startPositionComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> endPositionComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> startPositionComboBox;
    // End of variables declaration//GEN-END:variables
}
