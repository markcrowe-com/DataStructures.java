/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

import com.markcrowe.datastructures.CompareResult;
import java.util.Comparator;

public class PatientComparator implements Comparator<Patient>
{
	private final IntegerComparator integerComparator = new IntegerComparator();
	private final DateComparator dateComparator = new DateComparator();

	@Override
	public int compare(Patient lhs, Patient rhs)
	{
		int result = this.integerComparator.compare(lhs.Priority(), rhs.Priority());

		if(CompareResult.Equal(result))
		{
			return this.dateComparator.compare(rhs.Time(), lhs.Time());

			//return this.dateComparator.compare(lhs.Time(), rhs.Time());
		}
		else
		{
			return result;
		}
	}
}
