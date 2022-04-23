package com.fp.practice;

import java.util.function.Function;

/**
 * Function Chaining concept using andThen or compose
 * andThen will first run the previous function and then apply the next method, whereas compose will do the opposite.
 * Output:
 * Double Function 4
 * Cube Function 8
 * First Doubling(2*2) using andThen and then Cubing(2*2*2) 64
 * First Cube(2*2*2) using compose and then Double(8*2) 16
 * 
 */
public class FunctionalChaining {

	public static void main(String[] args) {
		Function<Integer, Integer> doubleNumber = i -> 2*i;
		System.out.println("Double Function "+ doubleNumber.apply(2));
		Function<Integer, Integer> cubeNumber = i -> i*i*i;
		System.out.println("Cube Function "+ cubeNumber.apply(2));
		
		System.out.println("First Doubling using andThen and then Cubing "+ doubleNumber.andThen(cubeNumber).apply(2));
		
		System.out.println("First Cube using compose and then Double "+ doubleNumber.compose(cubeNumber).apply(2));
		
		
	}

}
