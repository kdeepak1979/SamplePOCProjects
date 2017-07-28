package com.deepak.sample.streams.basics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamToFindFirst {
	public List<Person> populateList() {
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

		StreamToFindFirst elements = new StreamToFindFirst();
		List<Person> people = elements.populateList();
		
		Optional<Person> indian = people.stream().filter(p->p.getCountry().startsWith("I")).findFirst();
		
		System.out.println(indian.orElseThrow(()->new RuntimeException("No Indian found")));
		
		Optional<Person> indian2 = people.stream().filter(p->p.getCountry().startsWith("I")).findAny();
		System.out.println(indian2.orElseThrow(()->new RuntimeException("No Indian found")));
		
		System.out.println("is all people indian ? :"+people.stream().allMatch(p->p.getCountry().startsWith("I")));
		
		System.out.println("is any person indian ? :"+people.stream().anyMatch(p->p.getCountry().startsWith("I")));

		
	}
}
