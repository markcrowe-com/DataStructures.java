/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import java.util.Date;

/**
 *
 */
public class Patient
{
	public Patient()
	{
	}
	public Patient(String name, int priority)
	{
		this.name = name;
		this.priority = priority;
		this.time = new Date(System.currentTimeMillis());
	}
	//
	//	Accessors
	//
	public String Name()
	{
		return name;
	}
	public int Priority()
	{
		return priority;
	}
	public Date Time()
	{
		return time;
	}
	public void Name(String name)
	{
		this.name = name;
	}
	public void Priority(int priority)
	{
		this.priority = priority;
	}
	public void Time(Date time)
	{
		this.time = time;
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
	//	fields
	//
	private String name;
	private int priority;
	private Date time;
}
