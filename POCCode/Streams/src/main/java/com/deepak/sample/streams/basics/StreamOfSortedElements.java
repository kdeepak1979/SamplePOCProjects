package com.deepak.sample.streams.basics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamOfSortedElements {
	
	public List<Person> populateList(){
		List<Person> list = new ArrayList<>();
		list.add(new Person("Person1", "US"));
		list.add(new Person("Person1", "US"));
		list.add(new Person("Person2", "Mexico"));
		list.add(new Person("Person3", "Singapore"));
		list.add(new Person("Person4", "India"));
		list.add(new Person("Person5", "India"));
		list.add(new Person("Person6", "Japan"));
		return list;
	}
	
	public static void main(String[] args) {
		
		StreamOfSortedElements elements = new StreamOfSortedElements();
		List<Person> people = elements.populateList();
		
		people.stream()
			  .sorted((p1,p2)->p1.getCountry().compareTo(p2.getCountry()))
			  .forEach(System.out::println);	
		
		System.out.println("############reverse sorted############");
		people.stream()
		  .sorted(Comparator.comparing((Person p)->p.getCountry()).reversed())
		  .forEach(System.out::println);	
		
		System.out.println("############Limited people############");
		people.stream()
		  .sorted((p1,p2)->p1.getCountry().compareTo(p2.getCountry())).limit(3)
		  .forEach(System.out::println);	
	}

}
