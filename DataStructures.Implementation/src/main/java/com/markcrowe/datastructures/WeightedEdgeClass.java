/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

import com.markcrowe.datastructures.WeightedEdge;

/**
 *
 * @param <TVertex>
 */
public class WeightedEdgeClass<TVertex> implements WeightedEdge<TVertex>
{
	public WeightedEdgeClass(TVertex startVertex, TVertex endVertex, int weight)
	{
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = weight;
	}
	@Override
	public TVertex EndVertex()
	{
		return this.endVertex;
	}
	@Override
	public TVertex StartVertex()
	{
		return this.startVertex;
	}
	@Override
	public int Weight()
	{
		return this.weight;
	}
	@Override
	public void EndVertex(TVertex endVertex)
	{
		this.endVertex = endVertex;
	}
	@Override
	public void StartVertex(TVertex startVertex)
	{
		this.startVertex = startVertex;
	}
	@Override
	public void Weight(int weight)
	{
		this.weight = weight;
	}
	//
	//	private fields
	//
	private TVertex startVertex;
	private TVertex endVertex;
	private int weight;

}
