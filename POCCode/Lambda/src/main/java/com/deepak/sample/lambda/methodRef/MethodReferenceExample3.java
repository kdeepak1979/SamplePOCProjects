package com.deepak.sample.lambda.methodRef;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExample3 {

	public List<Double> calculateOnShipments(List<Shipment> l, Function<Shipment, Double> f) {
		List<Double> results = new ArrayList<>();
		for (Shipment s : l) {
			results.add(f.apply(s));
		}
		return results;
	}

	public static void main(String[] args) {
		List<Shipment> l = new ArrayList<Shipment>();
		MethodReferenceExample3 example = new MethodReferenceExample3();
		// Using an anonymous class
		example.calculateOnShipments(l, new Function<Shipment, Double>() {
		  public Double apply(Shipment s) { // The object
		    return s.calculateWeight(); // The method
		  }
		});

		// Using a lambda expression
		example.calculateOnShipments(l, s -> s.calculateWeight());

		// Using a method reference
		example.calculateOnShipments(l, Shipment::calculateWeight);
		
		// Using a method reference
		//example.calculateOnShipments(l, example::calculateWeight);

	}

}

class Shipment {
	public double calculateWeight() {
		double weight = 0;
		// Calculate weight
		return weight;
	}
}
