package com.deepak.sample.lambda.inf.conflict;

public class StaticMethodConflict implements InterfaceA, InterfaceC {

	public static void main(String[] args) {
		StaticMethodConflict conflict = new StaticMethodConflict();
		System.out.println(conflict.getID());
	}

}
