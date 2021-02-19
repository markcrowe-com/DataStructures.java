/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import java.util.List;

/**
 *
 * @param <TVertex>
 */
public interface WeightedGraph<TVertex>
{
	//
	//	methods
	//
	List<WeightedEdge> EdgeList();
	void AddEdge(TVertex startVertex, TVertex endVertex, int edgeWeight);
	void RemoveEdge(TVertex startVertex, TVertex endVertex);
	List<TVertex> VertexList();
	void AddVertex(TVertex vertex);
	void MarkVertex(TVertex vertex);
	//
	//	methods - path
	//
	void ClearMarks();
	void DeleteAllEdges();
	Queue<TVertex> EdgeConnectedVertices(TVertex vertex);
	boolean EdgeExists(TVertex startVertex, TVertex endVertex);
	int WeightOfEdgeOf(TVertex startVertex, TVertex endVertex);

	String PrintPath();
	//
	//	status
	//
	boolean IsEmpty();
	boolean IsNotEmpty();
	boolean IsFull();
	boolean IsNotFull();
	boolean IsMarked(TVertex vertex);
	boolean IsMarked(int vertexIndex);
	boolean IsNotMarked(TVertex vertex);
	boolean IsNotMarked(int vertexIndex);
}
