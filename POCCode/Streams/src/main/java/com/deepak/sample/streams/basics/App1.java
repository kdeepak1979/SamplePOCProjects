package com.deepak.sample.streams.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App1 {

	public List<Person> populateList(){
		List<Person> list = new ArrayList<>();
		list.add(new Person("Person1", "US"));
		list.add(new Person("Person2", "Mexico"));
		list.add(new Person("Person3", "Singapore"));
		list.add(new Person("Person4", "India"));
		list.add(new Person("Person5", "India"));
		list.add(new Person("Person6", "Japan"));
		return list;
	}
	
	
	public static void main(String[] args) {
		App1 starter = new App1();
		List<Person> personList = starter.populateList();
		System.out.println("All persons from India");
		personList.stream()
				  .filter(p->p.getCountry().equals("India"))
				  .map(p->p.getName())
				  .forEach(System.out::println);
		System.out.println("All persons not belonging India");
		personList.stream()
		          .filter(p->!p.getCountry().equals("India"))
		          .map(p->p.getName())
		          .forEach(System.out::println);
		
		Person [] personArray = personList.stream().toArray(Person []::new);
		System.out.println(Arrays.deepToString(personArray));

	}

}
