/*
 * Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.
 */
package com.markcrowe.datastructures.support;

/**
 * Employee
 */
public class Employee
{
	public Employee()
	{
	}
	public Employee(String number, String firstname, String surname, String age)
	{
		this.number = number;
		this.firstname = firstname;
		this.surname = surname;
		this.age = age;
	}
	//
	//	Public Methods
	//
	public String getNum()
	{
		return number;
	}
	public String getSurname()
	{
		return surname;
	}
	public String getFirstname()
	{
		return firstname;
	}
	public String getAge()
	{
		return age;
	}
	//
	//	Public Methods - Set
	//
	public void setAge(String age)
	{
		this.age = age;
	}
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public void setNum(String number)
	{
		this.number = number;
	}
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	//
	//	Public Methods
	//
	@Override
	public String toString()
	{
		return this.number + " " + this.firstname + " " + this.surname + " (" + this.age + ")";
	}
	//
	//	Private Fields
	//
	private String number;
	private String surname;
	private String firstname;
	private String age;
}
