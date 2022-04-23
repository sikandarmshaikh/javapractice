package com.fp.practice;

import java.util.function.Consumer;

/**
 * 
 * Output: 
 * Squared number is 25
 * Taking an input and performing operation 
 * 
 */
public class ConsumerDemo {

	public static void main(String[] args) {
		
		ConsumerDemo consumerDemo = new ConsumerDemo();
		consumerDemo.squareIt(5);
		
		Consumer<Integer> squareMe = i -> System.out.println("Taking an input and performing operation "+i*i);
		squareMe.accept(5);
		
		Consumer<Integer> doubleMe = i -> System.out.println("Taking an input and performing operation "+2*i);
		doubleMe.accept(5);
		
		//Consumer Chaining
		squareMe.andThen(doubleMe).accept(5);
	}

	public static void squareIt(int i) {
		int squared = i*i;
		System.out.println("Squared number is "+squared);
	}

}
