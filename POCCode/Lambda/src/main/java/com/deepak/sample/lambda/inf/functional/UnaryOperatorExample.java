package com.deepak.sample.lambda.inf.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import com.deepak.sample.lamda.domain.Employee;


public class UnaryOperatorExample {
	
	private List<Employee> employeeList = Arrays.asList(
			new Employee("Deepak","Kumar",35,10000),
			new Employee("Seema","Nishad",35,15000)
			);
	public void updateSalary(UnaryOperator<Employee> salaryOperator){
		
		for(Employee e : employeeList){
			salaryOperator.apply(e);
		}		
	}
	
	public void printEmployeeDetails(){
	  System.out.println(employeeList);	
	}
	
	public static void main(String [] args){
		UnaryOperator<Employee> salaryUpdate = (e)->{e.setSalary(e.getSalary()+e.getSalary()*10/100); return e;};
		UnaryOperatorExample example = new UnaryOperatorExample();
		
		example.printEmployeeDetails();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		example.updateSalary(salaryUpdate);
		
		example.printEmployeeDetails();
		
	}

}
