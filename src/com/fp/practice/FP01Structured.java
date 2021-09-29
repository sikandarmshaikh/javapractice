package com.fp.practice;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {

		/*
		 * System.out.println(List.of("Sikandar","Shaikh")); int day =0; String
		 * dayOfWeek = switch(day) { case 0 -> "Monday"; case 1 -> "Tuesday"; default ->
		 * throw new IllegalArgumentException("Unexpected value: " + day); };
		 * 
		 * String str = """ Line1 Line2 Line3 """;
		 * System.out.println(day+" "+dayOfWeek);
		 */
		
		String value = "red";
		switch(value) {
		case "red": 
			System.out.println("FAIL");
		case "green" :
			System.out.println("OK");
		}
		
	}
	
	void method(int a) {
		a=4;
	}

}
