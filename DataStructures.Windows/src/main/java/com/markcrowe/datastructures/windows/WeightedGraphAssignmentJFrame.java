/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.windows;

import com.markcrowe.algorithms.DepthFirstSearch;
import com.markcrowe.datastructures.WeightedEdge;
import com.markcrowe.datastructures.WeightedGraph;
import com.markcrowe.datastructures.WeightedGraphClass;
import com.markcrowe.datastructures.support.Airport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public final class WeightedGraphAssignmentJFrame extends javax.swing.JFrame
{
	public WeightedGraphAssignmentJFrame()
	{
		graph = new WeightedGraphClass<>(this.numberofairports);
		airportList = new Airport[numberofairports];
		this.InitilizeGraph();

		this.theblackinsertpane = new WeightedGraphAssignmentAddFlightJFrame(this);
		this.theblacksearchpane = new FlightSearchJFrame(this);
		this.theblackdeletepane = new WeightedGraphAssignmentDeleteFlightJFrame(this);

		initComponents();

		this.PrintFlightList(this.PrintEdges());

	}
	//
	//	graph methods
	//
	public void AddEdgeToGraph(Airport startAirport, Airport endAirport, int distance)
	{
		this.ClearFlightDetailsConsole();
		if(!startAirport.equals(endAirport))
		{
			if(this.graph.EdgeExists(startAirport, endAirport))
			{
				//
				//	output
				//
				this.PrintFlightDetails("A Flight from " + startAirport.Name() + " to " + endAirport.Name() + " already exists.");
			}
			else
			{
				this.graph.AddEdge(startAirport, endAirport, distance);

				//
				//	output
				//
				this.PrintFlightDetails("New Flight added from " + startAirport.Name() + " to " + endAirport.Name() + " " + distance);
				this.PrintFlightList(this.PrintEdges());
			}
		}
		else
		{
			//
			//	output
			//
			this.PrintFlightDetails("You cannot create a flight from an airport to the same airport.");
		}
	}
	public void RemoveAirport(Airport startAirport, Airport endAirport)
	{
		this.ClearFlightConsole();
		if(this.graph.EdgeExists(startAirport, endAirport))
		{
			this.graph.RemoveEdge(startAirport, endAirport);
			//
			//	output
			//
			this.PrintFlightDetails("Flight " + startAirport.Name() + " to " + endAirport.Name() + " has been canceled.");
			this.PrintFlightList(this.PrintEdges());
		}
		else
		{
			//
			//	output
			//
			this.PrintFlightDetails("No Such Flight Exists.");
			this.PrintFlightList(this.PrintEdges());
		}

	}
	public void Search(Airport startAirport, Airport endAirport)
	{
		this.ClearFlightDetailsConsole();
		if(startAirport != endAirport)
		{
			List<Airport> path = new ArrayList<>();
			boolean found = this.searchMethod.Search(graph, startAirport, endAirport, path);
			if(found)
			{
				//
				//	output
				//
				this.PrintFlightDetails("A flight from " + startAirport.Name() + " to " + endAirport.Name() + " has been found." + System.lineSeparator() + this.PrintPath(path) + ".");
			}
			else
			{
				//
				//	output
				//
				this.PrintFlightDetails("No flight is available from " + startAirport.Name() + " to " + endAirport.Name() + ".");
			}
		}
		else
		{
			//
			//	output
			//
			this.PrintFlightDetails("you cannot travel from an airport to the same airport.");
		}
	}
	//
	//	suppport
	//
	public Airport GetAirportByName(String name)
	{
		for(Airport item : this.airportList)
		{
			if(item.Name().equalsIgnoreCase(name))
			{
				return item;
			}
		}
		return null;
	}
	//
	//	private methods
	//
	private void InitilizeGraph()
	{
		Airport atlanta = this.airportList[0] = new Airport("Atlanta");
		Airport austin = this.airportList[1] = new Airport("Austin");
		Airport chicago = this.airportList[2] = new Airport("Chicago");
		Airport dallas = this.airportList[3] = new Airport("Dallas");
		Airport denver = this.airportList[4] = new Airport("Denver");
		Airport houston = this.airportList[5] = new Airport("Houston");
		Airport washington = this.airportList[6] = new Airport("Washington");
		Airport zington = this.airportList[7] = new Airport("Zington");

		for(Airport airport : airportList)
		{
			this.graph.AddVertex(airport);
		}

		this.graph.AddEdge(atlanta, washington, 600);
		this.graph.AddEdge(atlanta, houston, 800);

		this.graph.AddEdge(austin, dallas, 200);
		this.graph.AddEdge(austin, houston, 160);

		this.graph.AddEdge(chicago, denver, 1000);

		this.graph.AddEdge(dallas, austin, 200);
		this.graph.AddEdge(dallas, denver, 780);
		this.graph.AddEdge(dallas, chicago, 900);

		this.graph.AddEdge(denver, atlanta, 1400);
		this.graph.AddEdge(denver, chicago, 1000);

		this.graph.AddEdge(houston, atlanta, 800);

		this.graph.AddEdge(washington, atlanta, 600);
		this.graph.AddEdge(washington, dallas, 1300);

		this.graph.AddEdge(washington, zington, 99);

	}
	//
	//	private methods - create Flight Text
	//
	private String PrintEdges()
	{
		String output = "";
		for(WeightedEdge item : this.graph.EdgeList())
		{
			output += item.StartVertex().toString() + " to " + item.EndVertex().toString() + " " + item.Weight() + System.lineSeparator();
		}
		return output;
	}
	private String PrintPath(List<Airport> path)
	{
		String output = "Search Path:" + System.lineSeparator();
		for(int index = 0; index < path.size(); index++)
		{
			output += path.get(index).Name() + "-->";
		}
		output = output.substring(0, (output.length() - 3));
		return output;
	}
	//
	//	private methods - printing
	//
	private void ClearFlightDetailsConsole()
	{
		this.flightInformationTextArea.setText("");
	}
	public void PrintFlightDetails(String text)
	{
		this.flightInformationTextArea.setText(text);
	}
	public void PrintFlightList(String text)
	{
		this.fligthsTextArea.setText(text + System.lineSeparator());
	}
	public void ClearFlightConsole()
	{
		this.fligthsTextArea.setText("");
	}
	//
	//	fields
	//
	public final Airport[] airportList;
	public WeightedGraph<Airport> graph;
	private final int numberofairports = 8;
	public DepthFirstSearch<Airport> searchMethod = new DepthFirstSearch<>();
	//
	//	custom frames
	//
	private final WeightedGraphAssignmentAddFlightJFrame theblackinsertpane;
	private final FlightSearchJFrame theblacksearchpane;
	private final WeightedGraphAssignmentDeleteFlightJFrame theblackdeletepane;

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        fligthsTextArea = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        flightInformationTextArea = new javax.swing.JTextArea();
        deleteButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deleteButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fligthsTextArea.setEditable(false);
        fligthsTextArea.setColumns(20);
        fligthsTextArea.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        fligthsTextArea.setRows(5);
        jScrollPane1.setViewportView(fligthsTextArea);

        addButton.setBackground(new java.awt.Color(0, 0, 0));
        addButton.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("New Flight");
        addButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(0, 0, 0));
        searchButton.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Seek Flight");
        searchButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                searchButtonActionPerformed(evt);
            }
        });

        flightInformationTextArea.setEditable(false);
        flightInformationTextArea.setColumns(20);
        flightInformationTextArea.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        flightInformationTextArea.setLineWrap(true);
        flightInformationTextArea.setRows(5);
        flightInformationTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(flightInformationTextArea);

        deleteButton.setBackground(new java.awt.Color(0, 0, 0));
        deleteButton.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete Flight");
        deleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(0, 0, 0));
        exitButton.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Flight Schedule");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Flight Details");

        deleteButton1.setBackground(new java.awt.Color(0, 0, 0));
        deleteButton1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        deleteButton1.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton1.setText("Delete All Flights");
        deleteButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(exitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, deleteButton, deleteButton1, exitButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitButtonActionPerformed
    {//GEN-HEADEREND:event_exitButtonActionPerformed
		System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addButtonActionPerformed
    {//GEN-HEADEREND:event_addButtonActionPerformed
		this.theblackinsertpane.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchButtonActionPerformed
    {//GEN-HEADEREND:event_searchButtonActionPerformed
		this.theblacksearchpane.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteButtonActionPerformed
    {//GEN-HEADEREND:event_deleteButtonActionPerformed
		this.theblackdeletepane.setVisible(true);
		this.setVisible(false);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteButton1ActionPerformed
    {//GEN-HEADEREND:event_deleteButton1ActionPerformed
		this.graph.DeleteAllEdges();
		this.PrintFlightList(this.PrintEdges());
    }//GEN-LAST:event_deleteButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextArea flightInformationTextArea;
    private javax.swing.JTextArea fligthsTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

}
