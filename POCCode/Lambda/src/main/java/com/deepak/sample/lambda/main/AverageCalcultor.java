package com.deepak.sample.lambda.main;

import com.deepak.sample.lambda.inf.IntSequence;
import com.deepak.sample.lambda.inf.impl.DigitSequence;
import com.deepak.sample.lambda.inf.impl.RandomSequence;

public class AverageCalcultor {

	public float getAverage(IntSequence numbers, int averageCount){
		int currentCount = 0;
		float sum = 0;
		while(numbers.hasNext() & currentCount < averageCount){
		  currentCount ++;	
		  sum += numbers.next();	
		}
		
		if(currentCount == 0){
			return 0;
		}else{
			return sum/currentCount;
		}
	}
	
	public void printSequenceOf(int... i){
		IntSequence seq = IntSequence.of(i);
		while(seq.hasNext()){
			System.out.println(seq.next());
		}
	}
	
	public static void main(String [] args){		
		IntSequence randomSequence = new RandomSequence();
		AverageCalcultor calc = new AverageCalcultor();
		System.out.println("Average of first 5 random numbes is "+calc.getAverage(randomSequence, 5));
		
		IntSequence digitSequence = new DigitSequence(1625628);		
		System.out.println("Average of first 5 random numbes is "+calc.getAverage(digitSequence, 5));
		
		System.out.println("Sequence of (1,2,3,4,5,6) : ");
		calc.printSequenceOf(1,2,3,4,5,6);
	}
}
