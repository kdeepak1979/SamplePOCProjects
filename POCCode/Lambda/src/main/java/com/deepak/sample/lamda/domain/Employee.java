package com.deepak.sample.lamda.domain;

public class Employee extends Person {

	private int salary;
	
	public Employee(String firstName, String lastName, int age, int salary) {
		super(firstName, lastName, age);
		this.salary = salary;
	}


	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [toString()=" + super.toString()+ ", salary=" + salary   + "]";
	}

	

}
