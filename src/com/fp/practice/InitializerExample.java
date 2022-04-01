package com.fp.practice;

/**
 * 2 Types of Initializers
 * Static and Instance
 * Static Initializer - called when Class is loaded
 * Instance Initializer - Called when an object is created
 * Output:
 * Static Initializer is called when Class is loaded
 * Count when Static Initializer is run 0
 * Instance Initializer
 * Count when instance initializer is run is : 1
 * Instance Initializer
 * Count when instance initializer is run is : 2
 * Instance Initializer
 * Count when instance initializer is run is : 3
 */
public class InitializerExample {
	
	static int count;
	int i;
	
	{ //Instance Initializer
		System.out.println("Instance Initializer");
		i = 6;
		count+=1;
		System.out.println("Count when instance initializer is run is : "+count);
	}
	
	static { //Static Initializer
		System.out.println("Static Initializer is called when Class is loaded");
		System.out.println("Count when Static Initializer is run "+count);
	}

	public static void main(String[] args) {
		InitializerExample i1 = new InitializerExample();
		InitializerExample i2 = new InitializerExample();
		InitializerExample i3 = new InitializerExample();
	}

}
