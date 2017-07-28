package com.deepak.sample.streams.basics;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App3 {

	public static void main(String[] args) {
		String str = "key1=val1, key2=val2, key3=val3, key4=val4, key5=val5, key6=val6";		
		//List<String> strList = Arrays.asList(str.split(","));				
		
		Map<String, String> paramMap = Stream.of(str.split(","))
											  .map(s->s.split("="))
											  .collect(Collectors.toMap(sArr->sArr[0].trim(), sArr->sArr[1].trim()));
						
		System.out.println(paramMap);
		
		System.out.println(paramMap.get("key1"));
	}

}
