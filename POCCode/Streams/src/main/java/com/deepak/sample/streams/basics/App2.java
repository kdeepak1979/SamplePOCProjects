package com.deepak.sample.streams.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App2 {

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
		App2 starter = new App2();
		List<Person> personList = starter.populateList();		
		System.out.println(personList.stream().collect(Collectors.partitioningBy(p->p.getCountry().equals("India"))));
		System.out.println(personList.stream().collect(Collectors.partitioningBy(p->p.getCountry().equals("India"),Collectors.counting())));
		System.out.println(personList.stream().collect(Collectors.partitioningBy(p->p.getCountry().equals("India"),Collectors.mapping(p->p.getName().toUpperCase(), Collectors.toList()))));
		
		
		System.out.println(personList.stream().collect(Collectors.groupingBy(p->p.getCountry().equals("India"))));
		System.out.println(personList.stream().collect(Collectors.groupingBy(p->p.getCountry().equals("India"),Collectors.counting())));
		System.out.println(personList.stream().collect(Collectors.groupingBy(p->p.getCountry().equals("India"),Collectors.mapping(p->p.getName().toUpperCase(), Collectors.toList()))));
		
		System.out.println(personList.stream().collect(Collectors.groupingBy(p->p.getCountry())));
		System.out.println(personList.stream().collect(Collectors.groupingBy(p->p.getCountry(),Collectors.counting())));
		
		System.out.println(personList.stream()
									 .collect(Collectors.groupingBy(p->p.getCountry()))
									                    .entrySet()
									                    .stream()
									                    .filter(e->e.getKey().equals("India"))
									                    .mapToInt(e->e.getValue().size()));
	}

}
