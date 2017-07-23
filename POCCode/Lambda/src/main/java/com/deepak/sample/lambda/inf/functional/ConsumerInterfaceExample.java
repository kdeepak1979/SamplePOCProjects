package com.deepak.sample.lambda.inf.functional;

import java.util.function.IntConsumer;

public class ConsumerInterfaceExample {

	public void actionOnInt(int i, IntConsumer action){	
		action.accept(i);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Compounded consumer 1");
		IntConsumer consumer = i->System.out.println(i);
		IntConsumer secondConsumer = consumer.andThen(i->System.out.println(i*2));
		ConsumerInterfaceExample example = new ConsumerInterfaceExample();
		example.actionOnInt(5, secondConsumer);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("Compounded consumer 2");
		IntConsumer consumer2 =  i->{i= i*2;System.out.println(i);};
		IntConsumer compoundedConsumer2 = consumer.andThen(i->System.out.println(i*2));
		ConsumerInterfaceExample example2 = new ConsumerInterfaceExample();
		example.actionOnInt(5, compoundedConsumer2);
		
		
	}

}
