package com.deepak.sample.streams.basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollector {

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
		StreamCollector sc = new StreamCollector();
		
		List<Person> people = sc.populateList();
		
		List<Person> usPeople = people.stream()
				                      .filter(p->p.getCountry().equals("US"))
				                      .collect(Collectors.toList());
		System.out.println("US People : "+usPeople);
		
		Set<Person> uniqueUsPeople = people.stream()
									  .filter(p->p.getCountry().equals("US"))
									  .collect(Collectors.toCollection(HashSet::new));
		System.out.println("US People : "+uniqueUsPeople);
		
		try{
		Map<String, String> countryToPeopleMap = people.stream()
													   .collect(Collectors.toMap(Person::getCountry, Person::getName));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//To Handle duplicate keys
		Map<String, String> countryToPeopleMap = people.stream()
				   .collect(Collectors.toMap(Person::getCountry, Person::getName,(existingValue,newValue)->existingValue));

		System.out.println(countryToPeopleMap);
		
		IntSummaryStatistics summary = people.stream().collect(Collectors.summarizingInt(p->p.getCountry().length()));
		
		System.out.println(summary);
	}

}
