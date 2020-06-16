/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 *
 * @param <TVertex>
 */
public interface WeightedEdge<TVertex>
{
	//
	//	gdt
	//
	TVertex EndVertex();
	TVertex StartVertex();
	int Weight();
	//
	//	set
	//
	void EndVertex(TVertex endVertex);
	void StartVertex(TVertex startVertex);
	void Weight(int weight);
}
