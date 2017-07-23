package com.deepak.sample.lambda.inf.impl;

import com.deepak.sample.lambda.inf.Measurable;

public class Employee implements Measurable {

	private String empName;
	private double empSalary;
	    
	public Employee(String empName, double empSalary) {
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public String getEmpName() {
		return empName;
	}

	@Override
	public double getMeasure() {		
		return empSalary;
	}

}
