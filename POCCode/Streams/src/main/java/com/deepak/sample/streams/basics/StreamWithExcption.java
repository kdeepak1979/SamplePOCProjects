package com.deepak.sample.streams.basics;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamWithExcption {

	public static void main(String[] args) {
		ExecutorService fixedThredPool = Executors.newFixedThreadPool(4);
				                     
		List<Future<String>> listOfFutute  = Stream.of("deepak","seema","prajjwal")
												   .map(s->fixedThredPool.submit(new Task(s)))
												   .collect(Collectors.toList());
		
		List<String> upperCaseStrings = listOfFutute.stream()
													.map(f->{
														try {
															return f.get();
														}catch(Exception e){
															e.printStackTrace();
															return null;
															}
													})
													.collect(Collectors.toList());
		
		System.out.println(upperCaseStrings);
		fixedThredPool.shutdown();
		
	}
	


}

class Task implements Callable<String>{

	private String str;
	
	public Task(String str){
		this.str = str;
	}
	
	@Override
	public String call() throws Exception {
		if(str.equals("seema")){
			throw new Exception("Exception in str seema");
		}
		return str.toUpperCase();
	}
	
}