package com.deepak.sample.lambda.inf.conflict;

public class DefaultMethodConflict implements InterfaceA, InterfaceB {

	public static void main(String[] args) {		
	}

	@Override
	public int getID() {		
		return InterfaceA.super.getID();
	}

}
