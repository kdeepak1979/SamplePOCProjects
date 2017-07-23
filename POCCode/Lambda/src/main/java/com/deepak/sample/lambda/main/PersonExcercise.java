package com.deepak.sample.lambda.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deepak.sample.lamda.domain.Person;

public class PersonExcercise {

	public static void main(String[] args) {
		// 1- create method that sort list by age
		// 2- create method that prints all persons in the list
		// 3- create method that prints all persons whose name starts with c
		
		List<Person> listOfPerson = Arrays.asList(
				 new Person("Deepak", "Kumar", 35),
				 new Person("Seema", "Nishad", 34),
				 new Person("Rajni", "Singh", 33),
				 new Person("Roli", "Kashyap", 30),
				 new Person("Rekha", "Kashyap", 28),
				 new Person("Prajjwal", "Kashyupa", 2)
				);		
		Comparator<Person> ageComparator = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return Integer.compare(o1.getAge(), o2.getAge());
			}
		};
		
		AllElementPrinter<Person> allElementPrinter = new AllElementPrinter<Person>() {

			@Override
			public void print(List<Person> list) {
				for(Person p : list){
					System.out.println(p);
				}
			}
		};
				
		
		AllElementPrinter<Person> allElementLambdaPrinter = (allPerson)->{
	    	   for(Person p : allPerson){
					System.out.println(p);
				} 
	       };
	       
	    StartsWithElementPrinter<Person> startsWithElementPrinter = new StartsWithElementPrinter<Person>(){
			@Override
			public void print(List<Person> list, String startsWith) {
				for(Person p : list){
					if(p.getFirstName().startsWith(startsWith))
					System.out.println(p);
				}
			}
	    	
	    };

	    StartsWithElementPrinter<Person> startsWithElementLambdaPrinter = (list,startsWith) ->{			
				for(Person p : list){
					if(p.getFirstName().startsWith(startsWith))
					System.out.println(p);
				}
	    };
			

	   System.out.println("Sorting with ananymous function");
       Collections.sort(listOfPerson, ageComparator);
       allElementPrinter.print(listOfPerson);
       System.out.println("Person starting with 'R'");
       startsWithElementPrinter.print(listOfPerson, "R");
       System.out.println("");
       System.out.println("");
       System.out.println("");
       
       System.out.println("Sorting with lambda");
       Collections.sort(listOfPerson, (p1,p2)-> Integer.compare(p1.getAge(), p2.getAge()));
       allElementLambdaPrinter.print(listOfPerson);
       System.out.println("Person starting with 'R'");
       startsWithElementLambdaPrinter.print(listOfPerson, "R");
       
	}

}

interface AllElementPrinter<T>{	
	public void print(List<T> list);
}

interface StartsWithElementPrinter<T>{	
	public void print(List<T> list,String startsWith);
}