/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import com.markcrowe.datastructures.Queue;
import com.markcrowe.datastructures.WeightedEdge;
import com.markcrowe.datastructures.WeightedGraph;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <TVertex>
 */
public class WeightedGraphClass<TVertex> implements WeightedGraph<TVertex>
{
	public WeightedGraphClass()
	{
		this(DefaultMaxiumNumberOfVertices);
	}
	public WeightedGraphClass(int maxiumNumberOfVertices)
	{
		this.numberOfVertices = 0;
		this.maxiumNumberOfVertices = maxiumNumberOfVertices;
		//
		//	constants
		//
		this.vertexList = new Object[this.maxiumNumberOfVertices];
		this.markedVertexList = new boolean[this.maxiumNumberOfVertices];
		this.edgeDetailList = new int[this.maxiumNumberOfVertices][this.maxiumNumberOfVertices];
	}
	//
	//	methods
	//
	@Override
	public List<WeightedEdge> EdgeList()
	{
		List<WeightedEdge> output = new ArrayList<>();
		//
		//	exectue
		//
		for(int startVertexIndex = 0; startVertexIndex < this.numberOfVertices; startVertexIndex++)
		{
			for(int endVertexIndex = 0; endVertexIndex < this.numberOfVertices; endVertexIndex++)
			{
				int edgeValue = this.GetEdgeWeight(startVertexIndex, endVertexIndex);
				if(EdgeValueIsNotNull(edgeValue))
				{
					TVertex startVertex = this.GetVertex(startVertexIndex);
					TVertex endVertex = this.GetVertex(endVertexIndex);
					output.add(new WeightedEdgeClass<>(startVertex, endVertex, edgeValue));
				}
			}
		}
		//
		//	return
		//
		return output;
	}
	@Override
	public void AddEdge(TVertex startVertex, TVertex endVertex, int edgeWeight)
	{
		int startVertexIndex = this.IndexOf(startVertex);
		int endVertexIndex = this.IndexOf(endVertex);
		this.AddEdge(startVertexIndex, endVertexIndex, edgeWeight);

	}
	@Override
	public void RemoveEdge(TVertex startVertex, TVertex endVertex)
	{
		int startVertexIndex = this.IndexOf(startVertex);
		int endVertexIndex = this.IndexOf(endVertex);
		this.RemoveEdge(startVertexIndex, endVertexIndex);
	}
	@Override
	public List<TVertex> VertexList()
	{
		List<TVertex> output = new ArrayList<>();
		//
		//	exectue
		//
		for(int index = 0; index < this.numberOfVertices; index++)
		{
			output.add(this.GetVertex(index));
		}
		//
		//	return
		//
		return output;
	}
	@Override
	public void AddVertex(TVertex vertex)
	{
		this.vertexList[this.numberOfVertices] = vertex;
		this.ClearEdges(this.numberOfVertices);
		this.numberOfVertices++;
	}
	@Override
	public void MarkVertex(TVertex vertex)
	{
		this.MarkVertex(this.IndexOf(vertex));
	}
	//
	//	methods - path
	//
	@Override
	public void ClearMarks()
	{
		for(int index = 0; index < this.numberOfVertices; index++)
		{
			this.markedVertexList[index] = false;
		}
		//this.list.clear();
	}
	public void DeleteAllEdges()
	{
		for(int startVertexIndex = 0; startVertexIndex < this.numberOfVertices; startVertexIndex++)
		{
			for(int endVertexIndex = 0; endVertexIndex < this.numberOfVertices; endVertexIndex++)
			{
				this.SetEdgeWeight(startVertexIndex, endVertexIndex, NullEdge);
			}
		}
	}
	@Override
	public Queue<TVertex> EdgeConnectedVertices(TVertex vertex
	)
	{
		Queue<TVertex> connectedVertices = new QueueClass<>();
		int startVertexIndex = this.IndexOf(vertex);
		for(int endVertexIndex = 0; endVertexIndex < this.numberOfVertices; endVertexIndex++)
		{
			if(this.EdgeIsNotNullAt(startVertexIndex, endVertexIndex))
			{
				connectedVertices.QueueItem(this.GetVertex(endVertexIndex));
			}
		}
		return connectedVertices;
	}
	@Override
	public boolean EdgeExists(TVertex startVertex, TVertex endVertex)
	{
		int edgeWeight = this.WeightOfEdgeOf(startVertex, endVertex);
		return EdgeValueIsNotNull(edgeWeight);
	}
	public int WeightOfEdgeOf(TVertex startVertex, TVertex endVertex)
	{
		int startVertexIndex = this.IndexOf(startVertex);
		int endVertexIndex = this.IndexOf(endVertex);
		return this.GetEdgeWeight(startVertexIndex, endVertexIndex);
	}
	//
	//	methods - status
	//
	@Override
	public boolean IsEmpty()
	{
		return this.numberOfVertices == 0;
	}
	@Override
	public boolean IsNotEmpty()
	{
		return !this.IsEmpty();
	}
	@Override
	public boolean IsFull()
	{
		return this.numberOfVertices == this.maxiumNumberOfVertices;
	}
	@Override
	public boolean IsNotFull()
	{
		return !this.IsFull();
	}
	@Override
	public boolean IsMarked(TVertex vertex
	)
	{
		return this.IsMarked(this.IndexOf(vertex));
	}
	@Override
	public boolean IsNotMarked(TVertex vertex
	)
	{
		return !this.IsMarked(vertex);
	}
	@Override
	public boolean IsMarked(int vertexIndex
	)
	{
		return (this.markedVertexList[vertexIndex] == true);
	}
	@Override
	public boolean IsNotMarked(int vertexIndex
	)
	{
		return !this.IsMarked(vertexIndex);
	}
	//
	//	protected methods
	//
	protected void AddEdge(int startVertexIndex, int endVertexIndex, int edgeWeight)
	{
		if(VertexIsNotNullAt(startVertexIndex) && VertexIsNotNullAt(endVertexIndex))
		{
			this.SetEdgeWeight(startVertexIndex, endVertexIndex, edgeWeight);
		}
	}
	protected void RemoveEdge(int startVertexIndex, int endVertexIndex)
	{
		if(VertexIsNotNullAt(startVertexIndex) && VertexIsNotNullAt(endVertexIndex))
		{
			this.SetEdgeWeight(startVertexIndex, endVertexIndex, NullEdge);
		}
	}
	protected void ClearEdges(int vertexIndex)
	{
		for(int correspondingVertexIndex = 0; correspondingVertexIndex < vertexIndex; correspondingVertexIndex++)
		{
			this.SetEdgeWeight(vertexIndex, correspondingVertexIndex, NullEdge);
			this.SetEdgeWeight(correspondingVertexIndex, vertexIndex, NullEdge);
		}
	}
	protected boolean EdgeIsNotNullAt(int startVertexIndex, int endVertexIndex)
	{
		return !EgdeIsNullAt(startVertexIndex, endVertexIndex);
	}
	protected boolean EgdeIsNullAt(int startVertexIndex, int endVertexIndex)
	{
		return EdgeValueIsNull(this.GetEdgeWeight(startVertexIndex, endVertexIndex));
	}
	protected TVertex GetVertex(int vertexIndex)
	{
		return (TVertex) this.vertexList[vertexIndex];
	}
	protected int GetEdgeWeight(int startVertexIndex, int endVertexIndex)
	{
		return this.edgeDetailList[startVertexIndex][endVertexIndex];
	}
	protected void SetEdgeWeight(int startVertexIndex, int endVertexIndex, int edgeWeight)
	{
		this.edgeDetailList[startVertexIndex][endVertexIndex] = edgeWeight;
	}
	protected int IndexOf(TVertex vertex)
	{
		int vertexIndex = -1;
		for(int index = 0; index < this.numberOfVertices; index++)
		{
			if(vertex == this.GetVertex(index))
			{
				vertexIndex = index;
				break;
			}
		}
		return vertexIndex;
	}
	protected void MarkVertex(int vertexIndex)
	{
		this.markedVertexList[vertexIndex] = true;
	}

	//
	//	private fields
	//
	private final int[][] edgeDetailList;
	private final boolean[] markedVertexList;
	private final int maxiumNumberOfVertices;
	private int numberOfVertices;
	private final Object[] vertexList;
	//
	//	constants
	//
	public static final int DefaultMaxiumNumberOfVertices = 50;
	public static final int NullEdge = 0;
	public static final int NullVertexIndex = -1;
	//
	//	static methods
	//
	public static boolean EdgeValueIsNotNull(int edgeWeight)
	{
		return !EdgeValueIsNull(edgeWeight);
	}
	public static boolean EdgeValueIsNull(int edgeWeight)
	{
		return edgeWeight == NullEdge;
	}
	public static boolean VertexIsNotNullAt(int vertexIndex)
	{
		return !VertexIsNullAt(vertexIndex);
	}
	public static boolean VertexIsNullAt(int vertexIndex)
	{
		return vertexIndex == NullVertexIndex;
	}

	@Override
	public String PrintPath()
	{
		String output = "";
		for(int j = 0; j < edgeDetailList.length; j++)
		{
			output += (vertexList[j] + ": ");
			for(int i = 0; i < edgeDetailList[j].length; i++)
			{
				if(edgeDetailList[j][i] > 0)
				{
					output += (vertexList[i] + ":" + edgeDetailList[j][i] + " ");
				}
			}
			output += System.lineSeparator();
		}
		return output;
	}

	//
	//	status
	//
	public boolean isEdge1(TVertex vertex1, TVertex vertex2)
	{
		int i = this.IndexOf(vertex1);
		if(i == -1)
		{
			System.out.print("isEdge failed: ");
			System.out.print(vertex1);
			System.out.println(" does not exist.");
			return false;
		}

		int j = this.IndexOf(vertex2);
		if(j == -1)
		{
			System.out.print("isEdge failed: ");
			System.out.print(vertex2);
			System.out.println(" does not exist.");
			return false;
		}

		return true; //isEdge(i, j);
	}

}
