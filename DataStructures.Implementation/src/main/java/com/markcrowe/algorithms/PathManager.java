/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.algorithms;

/**
 *
 * @param <VertexType>
 */
public class PathManager<VertexType>
{
	public PathManager(VertexType fromVertex, VertexType toVertex)
	{
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.distance = 0;
	}

	void PrintLine()
	{
		System.out.print(fromVertex);
		System.out.print(" ");
		System.out.print(toVertex);
		System.out.print(" ");
		System.out.println(distance);
	}
	// < means greater distance
	//bool operator<(PathManager otherItem);
	//bool operator==(PathManager otherItem);
	//bool operator<=(PathManager otherItem);
	//
	//	Fields
	//
	public VertexType fromVertex;
	public VertexType toVertex;
	public int distance;
}
