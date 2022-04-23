package com.fp.practice;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiPredicateFunctionDemo {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> checkSumOfTwo = (a,b) -> a+b >= 5;
		System.out.println("Sum of 2 and 5 is greater then 5 : " + checkSumOfTwo.test(2,5));
		System.out.println("Sum of 2 and 1 is greater then 5 : " + checkSumOfTwo.test(2,1));
		
		BiFunction<Integer, Integer, Integer> multiplyBoth = (a,b) -> (a*b);
		System.out.println("Multiplication of 5 and 10 is " + multiplyBoth.apply(5,10));
		
	}

}
