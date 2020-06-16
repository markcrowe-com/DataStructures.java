/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

import com.markcrowe.datastructures.Queue;
import com.markcrowe.datastructures.WeightedGraph;
import com.markcrowe.datastructures.implementation.QueueClass;
import java.util.List;

/**
 *
 * @param <TVertex>
 */
public class BreadthFirstSearch<TVertex> implements WeightedGraphSearch<TVertex>
{
	@Override
	public boolean Search(WeightedGraph<TVertex> graph, TVertex startVertex, TVertex endVertex, List<TVertex> path)
	{
		Queue<TVertex> queue = new QueueClass<>();
		Queue<TVertex> vertexQueue;
		boolean found = false;
		TVertex vertex;
		TVertex item;
		graph.ClearMarks();
		queue.QueueItem(startVertex);
		do
		{
			vertex = queue.Dequeue();
			if(vertex == endVertex)
			{
				found = true;
			}
			else
			{
				if(!graph.IsMarked(vertex))
				{
					graph.MarkVertex(vertex);
					vertexQueue = graph.EdgeConnectedVertices(vertex);

					while(!vertexQueue.IsEmpty())
					{
						item = vertexQueue.Dequeue();
						if(!graph.IsMarked(item))
						{
							queue.QueueItem(item);
						}
					}
				}
			}
		}
		while(!queue.IsEmpty() && !found);
		return found;
	}
}
