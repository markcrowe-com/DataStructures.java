/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

import com.markcrowe.datastructures.LinkedQueue;
import com.markcrowe.datastructures.Queue;
import com.markcrowe.datastructures.WeightedGraph;
import java.util.List;

/**
 *
 * @param <T>
 */
public class BreadthFirstSearch<T> implements WeightedGraphSearch<T>
{
	@Override
	public boolean Search(WeightedGraph<T> graph, T startVertex, T endVertex, List<T> path)
	{
		boolean found = false;
		graph.ClearMarks();
		Queue<T> queue = new LinkedQueue<>();
		queue.QueueItem(startVertex);
		do
		{
			T vertex = queue.Dequeue();
			if(vertex == endVertex)
			{
				found = true;
			}
			else
			{
				if(!graph.IsMarked(vertex))
				{
					graph.MarkVertex(vertex);
					Queue<T> vertexQueue = graph.EdgeConnectedVertices(vertex);

					while(!vertexQueue.isEmpty())
					{
						T item = vertexQueue.Dequeue();
						if(!graph.IsMarked(item))
						{
							queue.QueueItem(item);
						}
					}
				}
			}
		}
		while(!queue.isEmpty() && !found);
		return found;
	}
}
