package com.deepak.sample.lambda.inf.impl;

import com.deepak.sample.lambda.inf.IntSequence;

public class DigitSequence implements IntSequence{

	private int number;
	
	public DigitSequence(int number){
		this.number = number;
	}
	
	@Override
	public boolean hasNext() {		
		return number != 0;
	}

	@Override
	public int next() {
		int nextDigit = number%10;
		number = number/10;
		return nextDigit;
	}
	
	public static void main(String [] args){
		DigitSequence seq = new DigitSequence(1542);
		while (seq.hasNext()) {
			System.out.println(seq.next());
			
		}
	}

}
