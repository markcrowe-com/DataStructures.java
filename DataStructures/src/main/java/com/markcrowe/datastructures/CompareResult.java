/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures;

/**
 *
 */
public class CompareResult
{
	//
	//	Constants
	//
	public static final int Equal = 0;
	public static final int LessThan = -1;
	public static final int GreaterThan = 1;
	//
	//	Methods
	//
	public static boolean Equal(int value)
	{
		return CompareResult.Equal == value;
	}
	public static boolean IsGreaterThan(int value)
	{
		return CompareResult.GreaterThan == value;
	}
	public static boolean IsGreaterThanOrEqual(int value)
	{
		return (CompareResult.IsGreaterThan(value) || CompareResult.Equal(value));
	}
	public static boolean IsLessThan(int value)
	{
		return CompareResult.LessThan == value;
	}
	public static boolean IsLessThanOrEqual(int value)
	{
		return (CompareResult.IsLessThan(value) || CompareResult.Equal(value));
	}
	public static boolean IsNotEqual(int value)
	{
		return (!CompareResult.Equal(value));
	}
}
