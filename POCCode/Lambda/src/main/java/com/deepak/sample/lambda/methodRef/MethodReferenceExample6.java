package com.deepak.sample.lambda.methodRef;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample6 {

	public static void main(String[] args) {
		// Using an anonymous class
		Supplier<List<String>> s = new Supplier() {
		  public List<String> get() {
		    return new ArrayList<String>();
		  }
		};
		List<String> l = s.get();

		// Using a lambda expression
		Supplier<List<String>> lambda = () -> new ArrayList<String>();
		l = lambda.get();

		// Using a method reference
		Supplier<List<String>> consturctorRef = ArrayList<String>::new;
		l = consturctorRef.get();
		
		/* If constructor take one argument*/
		// Using an anonymous class
		Function<String, Integer> f =
		  new Function<String, Integer>() {
		    public Integer apply(String s) {
		      return new Integer(s);
		    }
		};
		Integer i = f.apply("100");

		// Using a lambda expression
		Function<String, Integer> lambdaFunction = str -> new Integer(str);
		i = lambdaFunction.apply("100");

		// Using a method reference
		Function<String, Integer> methodRef = Integer::new;
		i = methodRef.apply("100");
		
		/*If constructor takes 3 arguments */
		// Using a anonymous class
		BiFunction<String, String, Locale> biFunction = new BiFunction<String, String, Locale>() {
		  public Locale apply(String lang, String country) {
		    return new Locale(lang, country);
		  }
		};
		Locale loc = biFunction.apply("en","UK");

		// Using a lambda expression
		BiFunction<String, String, Locale> biFunctionLambda = (lang, country) -> new Locale(lang, country);
		loc = biFunctionLambda.apply("en","UK");

		// Using a method reference
		BiFunction<String, String, Locale> biFunctionContructoRef = Locale::new;
		loc = biFunctionContructoRef.apply("en","UK");
	}

}
