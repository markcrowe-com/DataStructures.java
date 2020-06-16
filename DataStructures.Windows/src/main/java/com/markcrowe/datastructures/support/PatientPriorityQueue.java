/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import com.markcrowe.datastructures.implementation.PriorityQueueClass;

/**
 * Patient Priority Queue
 */
public final class PatientPriorityQueue extends PriorityQueueClass<Patient, PatientComparator>
{
	public PatientPriorityQueue(int max)
	{
		super(max, new PatientComparator());
	}
}
