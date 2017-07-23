package com.deepak.sample.lambda.inf.impl;

import java.util.Random;

import com.deepak.sample.lambda.inf.IntSequence;

public class RandomSequence implements IntSequence {
    private Random random = new Random();
    
	@Override
	public boolean hasNext() {		
		return true;
	}

	@Override
	public int next() {
		return random.nextInt(100);
	}
	
	public static void main(String [] args){
		RandomSequence randomSequence = new RandomSequence();
		for(int i =0;i<10;i++){
			System.out.println(randomSequence.next());
		}
	}

}
