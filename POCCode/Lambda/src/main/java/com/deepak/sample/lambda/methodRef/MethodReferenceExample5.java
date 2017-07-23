package com.deepak.sample.lambda.methodRef;

import java.util.function.Consumer;

public class MethodReferenceExample5 {

	public void execute(Car car, Consumer<Car> c) {
		  c.accept(car);
		}
	public static void main(String[] args) {
		final Mechanic mechanic = new Mechanic();
		Car car = new Car();
		MethodReferenceExample5 example = new MethodReferenceExample5();
		// Using an anonymous class
		example.execute(car, new Consumer<Car>() {
		  public void accept(Car c) {
		    mechanic.fix(c);
		  }
		});

		// Using a lambda expression
		example.execute(car, c -> mechanic.fix(c));

		// Using a method reference
		example.execute(car, mechanic::fix);				

	}

}

class Car {
	private static int id;
	private String color;
	// More properties
	// And getter and setters
	public int getId() {
		return ++id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}

class Mechanic {
	public void fix(Car c) {
		System.out.println("Fixing car " + c.getId());
	}
}