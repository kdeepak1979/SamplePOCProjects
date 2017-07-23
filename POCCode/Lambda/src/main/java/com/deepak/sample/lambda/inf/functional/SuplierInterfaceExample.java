package com.deepak.sample.lambda.inf.functional;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Supplier;

public class SuplierInterfaceExample {
	
	public static void main(String[] args) {
		Supplier<Date> currentTimeSupplier = ()->Calendar.getInstance().getTime();
        System.out.println("CurrentDate is : "+currentTimeSupplier.get());		
	}

}
