package com.deepak.sample.lambda.inf;

public interface IntSequence {

	boolean hasNext();
	int next();
	
	public static IntSequence InfiniteSequenceOf(int num){
		return new IntSequence() {
			
			@Override
			public int next() {
				return num;
			}
			
			@Override
			public boolean hasNext() {
				return true;
			}
		};
	}
	
	public static IntSequence of(int... i){
		return new IntSequence() {
			int count = 0;
			@Override
			public int next() {
				return i[count++];
			}
			
			@Override
			public boolean hasNext() {
				return count < i.length;
			}
		};
	}
	
	/**
	 * Provide Implementation
	 * @param num
	 * @return
	 */
	public static IntSequence constant(int num){
		return null;
	}
}
