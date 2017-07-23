package com.deepak.sample.lambda.methodRef;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Stream;

public class MethodReferenceExample {

	private String [] names = {"Deepak", "Seema", "Prajjwal"};
	
	public void printSortedNames(){
		//Arrays.sort(names, (x,y)->x.compareToIgnoreCase(y));
		Arrays.sort(names, String::compareToIgnoreCase);		
		System.out.println(Arrays.toString(names));
		
		Arrays.stream(names).forEach(e->this.greetPeople(e));
		Arrays.stream(names).forEach(e->MethodReferenceExample.greetPeopleLoud(e));
		
		Arrays.stream(names).forEach(this::greetPeople);
		Arrays.stream(names).forEach(MethodReferenceExample::greetPeopleLoud);
	}
	
	
	
	public void greetPeople(String name){
		System.out.println("Hello "+name);		
	}
	
	public static void greetPeopleLoud(String name){
		System.out.println("Helloooooooo "+name);		
	}
	
	public void greetAllPeople(String [] name){
		Arrays.stream(names).forEach(this::greetPeople);
	}
	
	
	public static void main(String[] args) {
		MethodReferenceExample example = new MethodReferenceExample();
		example.printSortedNames();
		
		List<Greeting> greetings = Arrays.asList(
				new Greeting("Hello Deepak!!"),
				new Greeting("Hello Seema!!")
				);
		
		greetings.forEach(Greeting::greet);
				
	}

}

class Greeting{

	private String greeting;
	
	public Greeting(String str){
		this.greeting = str;
	}
	
	public void greet(){
		System.out.println(greeting);
	}
}

