package com.deepak.sample.lambda.inf;

public interface Measurable {
	public double getMeasure();
	
	static double getAverage(Measurable [] measurables){
		int count = 0;
		double sum = 0;
		for(Measurable m : measurables){
			count++;
			sum += m.getMeasure();
		}		
		return sum/count;
	}
	
	static Measurable largest(Measurable [] measurables){
		if(measurables == null || measurables.length == 0){
			throw new RuntimeException(" Measurable array is Null or empty");
		}		
		Measurable largest = measurables[0];		
		for(Measurable m : measurables){
			if(m.getMeasure()> largest.getMeasure()){
				largest = m;
			}
		}		
		return largest;
	}
}
