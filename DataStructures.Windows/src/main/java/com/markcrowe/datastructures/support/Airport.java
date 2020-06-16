/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

/**
 * Airport Data Structure
 */
public class Airport
{
	public Airport()
	{

	}
	public Airport(String name)
	{
		this.name = name;
	}
	//
	//	Properties
	//
	public String Name()
	{
		return name;
	}
	public void Name(String name)
	{
		this.name = name;
	}
	//
	//	Methods
	//
	@Override
	public String toString()
	{
		return this.name;
	}
	//
	//	Fields
	//
	private String name;
}
