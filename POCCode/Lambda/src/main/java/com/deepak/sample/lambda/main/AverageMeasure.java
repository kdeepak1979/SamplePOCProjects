package com.deepak.sample.lambda.main;

import com.deepak.sample.lambda.inf.Measurable;
import com.deepak.sample.lambda.inf.impl.Employee;

public class AverageMeasure {

	public static void main(String[] args) {
		Measurable [] employees = new Employee[10];
		int baseSalary = 10000;
		for(int i = 1;i<=10;i++){
			employees[i-1] = new Employee("E"+i, baseSalary*i);
		}
		
		System.out.println("Average Employee salary = "+Measurable.getAverage(employees));
	}

}
