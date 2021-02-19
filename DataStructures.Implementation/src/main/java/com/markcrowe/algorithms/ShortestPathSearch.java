/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

import com.markcrowe.datastructures.PriorityQueue;
import com.markcrowe.datastructures.PriorityQueueClass;
import com.markcrowe.datastructures.Queue;
import com.markcrowe.datastructures.WeightedGraph;

/**
 *
 * @param <VertexType>
 */
public class ShortestPathSearch<VertexType>
{
	public void PrintShortestPaths(WeightedGraph<VertexType> graph, VertexType startVertex)
	{
		graph.ClearMarks();

		PathManager<VertexType> pathManager = new PathManager<>(startVertex, startVertex);

		PriorityQueue<PathManager<VertexType>> priorityQueue = new PriorityQueueClass<>(10, new PathManagerComparator<VertexType>());// = (10);
		priorityQueue.Enqueue(pathManager);

		System.out.println("Last Vertex Destination Distance");
		System.out.println("------------------------------------------ - ");

		do
		{
			pathManager = priorityQueue.Dequeue(); //.Dequeue(pathManager);
			if( ! graph.IsMarked(pathManager.toVertex))
			{
				graph.MarkVertex(pathManager.toVertex);

				pathManager.PrintLine();

				pathManager.fromVertex = pathManager.toVertex;
				int minDistance = pathManager.distance;

				Queue<VertexType> queue = graph.EdgeConnectedVertices(pathManager.fromVertex);

				while( ! queue.IsEmpty())
				{
					VertexType vertex = queue.Dequeue();
					if( ! graph.IsMarked(vertex))
					{
						pathManager.toVertex = vertex;
						pathManager.distance = minDistance + graph.WeightOfEdgeOf(pathManager.fromVertex, vertex);
						priorityQueue.Enqueue(pathManager);// Enqueue(pathManager);
					}
				}
			}
		}
		while( ! priorityQueue.IsEmpty());// .IsEmpty());
	}
}
