/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

import com.markcrowe.datastructures.WeightedGraph;
import java.util.List;

public interface WeightedGraphSearch<TVertex>
{
	boolean Search(WeightedGraph<TVertex> graph, TVertex startVertex, TVertex endVertex, List<TVertex> path);
}
