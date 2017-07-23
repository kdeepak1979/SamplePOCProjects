package com.deepak.sample.lambda.lambdaExcercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LuckySort {

	public void luckySort(List<String> list, Comparator<String> comp) {
		boolean sorted = true;
		int shuffleCount = 1;
		do {
			sorted = true;
			System.out.println("Shuffle "+shuffleCount++);
			Collections.shuffle(list);
			for(int i=0;i<list.size()-1;i++){
				if(comp.compare(list.get(i),list.get(i+1))>0){
					sorted = false;
				}
			}			
		} while (!sorted);
		
		System.out.println(list);
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Deepak","Seema","Rekha","Roli");		
		Comparator<String> comp = (s1,s2)-> s1.compareTo(s2);
		LuckySort sort = new LuckySort();
		sort.luckySort(list, comp);
	}

}
