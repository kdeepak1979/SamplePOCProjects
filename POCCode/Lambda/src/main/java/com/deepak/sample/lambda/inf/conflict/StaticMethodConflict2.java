package com.deepak.sample.lambda.inf.conflict;

public class StaticMethodConflict2 implements InterfaceB, InterfaceC {

	public static void main(String[] args) {
		StaticMethodConflict2 conflict = new StaticMethodConflict2();
		System.out.println(conflict.getID());
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

}
