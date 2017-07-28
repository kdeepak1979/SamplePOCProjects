package com.deepak.sample.streams.basics;

import java.util.ArrayList;
import java.util.List;

public class StreamOfDistinctElements {

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
		
		StreamOfDistinctElements elements = new StreamOfDistinctElements();
		List<Person> people = elements.populateList();
		
		people.stream().distinct().forEach(System.out::println);

	}

}
