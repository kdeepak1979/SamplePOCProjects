package com.deepak.sample.lambda.inf.functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import com.deepak.sample.lamda.domain.Employee;


public class FunctionInterfaceExample {

	private List<Employee> employeeList = Arrays.asList(
			new Employee("Deepak","Kumar",35,10000),
			new Employee("Seema","Nishad",35,15000)
			);
	
	public List<Employee> getEmployees(){
		return employeeList;	
	}
	
	public void updateSalaries(List<Employee> employess, Function<Employee,Void> calc){
		employess.forEach(e->calc.apply(e));		
		//employess.forEach(System.out::println);
	}
	
	public static void main(String [] args){
		
		System.out.println("Composite Funtion {before} ");
		Function<Employee, Employee> printSalaries = e-> {System.out.println("[Name = "+e.getFirstName()+" "+e.getLastName()+" , Salary = "+e.getSalary()+"]"); return e;};
		Function<Employee, Void> printSalaries2 = e-> {System.out.println("[Name = "+e.getFirstName()+" "+e.getLastName()+" , Salary = "+e.getSalary()+"]"); return null;};
		Function<Employee, Employee> salaryIncrementByTenPercent = e-> {e.setSalary(e.getSalary()+e.getSalary()*10/100); return e;};
		Function<Employee, Void> compositeFuntion = salaryIncrementByTenPercent.compose(printSalaries).andThen(printSalaries2);
		FunctionInterfaceExample example = new FunctionInterfaceExample();		
		example.updateSalaries(example.getEmployees(), compositeFuntion);

		System.out.println("Composite Funtion {after} ");		
		Function<Employee, Employee> salaryIncrementByTwentyPercent = e-> {e.setSalary(e.getSalary()+e.getSalary()*10/100); return e;};
		Function<Employee, Employee> applyTax = e-> {e.setSalary(e.getSalary()- e.getSalary()*10/100); return e;};
		
		Function<Employee, Void> compositeFuntion2 = salaryIncrementByTwentyPercent.andThen(applyTax).andThen(printSalaries2);
		FunctionInterfaceExample example2 = new FunctionInterfaceExample();		
		example2.updateSalaries(example2.getEmployees(), compositeFuntion2);

		
	}
}
