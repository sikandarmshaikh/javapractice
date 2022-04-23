package com.fp.practice;

import java.util.function.Predicate;

public class PredicateFunctionDemo {

	public static void main(String[] args) {
		
		Predicate<String> checkLength = s -> s.length() >=5;
		Predicate<String> checkEvenLength = s -> s.length() %2 == 0;
		System.out.println(checkLength.and(checkEvenLength).test("FIVEPLUS"));
		System.out.println(checkLength.or(checkEvenLength).test("FIVEPLUS"));
		System.out.println(checkLength.and(checkEvenLength).test("THREE"));
		System.out.println(checkLength.or(checkEvenLength).test("THREE"));
		System.out.println(checkLength.negate().test("THREE"));
		//System.out.println(checkLength.and(checkEvenLength).test("THREE"));
		//System.out.println(checkLength.test("Sample String"));
		//System.out.println(checkLength.test("FOUR"));
	}

}
