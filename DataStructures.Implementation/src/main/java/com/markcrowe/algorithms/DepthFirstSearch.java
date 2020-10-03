/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

import com.markcrowe.datastructures.LinkedStack;
import com.markcrowe.datastructures.Queue;
import com.markcrowe.datastructures.Stack;
import com.markcrowe.datastructures.WeightedGraph;
import java.util.List;

/**
 *
 * @param <TVertex>
 */
public class DepthFirstSearch<TVertex> implements WeightedGraphSearch<TVertex>
{
	@Override
	public boolean Search(WeightedGraph<TVertex> graph, TVertex startVertex, TVertex endVertex, List<TVertex> path)
	{
		Stack<TVertex> stack = new LinkedStack<>();
		Queue<TVertex> vertexQueue;

		boolean found = false;
		TVertex candiateVertex;

		graph.ClearMarks();
		stack.push(startVertex);
		do
		{
			candiateVertex = stack.peek();
			stack.pop();

			if(candiateVertex == endVertex)
			{
				found = true;
				path.add(candiateVertex);
			}
			else
			{
				if(!graph.IsMarked(candiateVertex))
				{
					path.add(candiateVertex);
					graph.MarkVertex(candiateVertex);
					vertexQueue = graph.EdgeConnectedVertices(candiateVertex);
					TVertex item;
					while(!vertexQueue.IsEmpty())
					{
						item = vertexQueue.Dequeue();
						if(!graph.IsMarked(item))
						{
							stack.push(item);
						}
					}
				}
			}
		}
		while(!stack.isEmpty() && !found);
		return found;
	}
}
