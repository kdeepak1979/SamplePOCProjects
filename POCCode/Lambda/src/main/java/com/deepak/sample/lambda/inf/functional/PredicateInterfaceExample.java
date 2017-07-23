package com.deepak.sample.lambda.inf.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.deepak.sample.lamda.domain.Person;

public class PredicateInterfaceExample {
	private List<Person> people = Arrays.asList(
			new Person("Deepak", "Kumar", 37), 
			new Person("Seema", "Nishad", 35),
			new Person("Prajjwal", "Kashyupa", 2), 
			new Person("Roli", "Kashyap", 30));

	public List<Person> findPeople(Predicate<Person> filter){
		List<Person> selectedPeople = new ArrayList<>();
		for(Person p : people){
			if(filter.test(p)){
				selectedPeople.add(p);
			}
		}
		
		return selectedPeople;
	}
	public static void main(String[] args) {
		Predicate<Person> ageCheck = (p -> p.getAge() < 35);
		Predicate<Person> ageAndNameCheck = ageCheck.and(p->p.getFirstName().startsWith("P"));
		Predicate<Person> ageOrNameCheck = ageCheck.or(p->p.getFirstName().startsWith("D"));
		
		PredicateInterfaceExample example = new PredicateInterfaceExample();
		
		System.out.println(example.findPeople(ageCheck));
		System.out.println(example.findPeople(ageAndNameCheck));
		System.out.println(example.findPeople(ageOrNameCheck));
		System.out.println(example.findPeople(ageCheck.negate()));
		
		
	}

}
