package com.fp.practice;

/** 
 * 
 * Assert Example
 *
 */
public class AssertExample {

	public static void main(String[] args) {
		AssertExample a1 = new AssertExample();
		System.out.println(a1.calculateSimpleInterest(1000, 10, 5));
	}
	
	private static int calculateSimpleInterest(int principal,float interest,int years) {
		assert(principal>0);
		return 100;		
	}

}
