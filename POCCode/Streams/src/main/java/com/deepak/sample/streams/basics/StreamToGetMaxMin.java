package com.deepak.sample.streams.basics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class StreamToGetMaxMin {

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
		StreamToGetMaxMin maxmin = new StreamToGetMaxMin();
		
		Optional<Person> personWithMaxCountry = maxmin.populateList().stream()
							 .max(Comparator.comparing(Person::getCountry));
				
		System.out.println(personWithMaxCountry.orElseThrow(()->new RuntimeException("No Person Found")));
		
		Optional<Person> personWithMinCountry = maxmin.populateList().stream()
				 .min(Comparator.comparing(Person::getCountry));
		
		System.out.println(personWithMinCountry.orElseThrow(()->new RuntimeException("No Person Found")));
		
		Optional<Person> nullPerson = new ArrayList<Person>().stream()
				 .min(Comparator.comparing(Person::getCountry));
		
		System.out.println(nullPerson.orElseThrow(()->new RuntimeException("No Person Found")));
		 
		
		
	}

}
