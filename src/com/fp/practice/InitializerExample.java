package com.fp.practice;

public class InitializerExample {
	
	static int count;
	int i;
	
	static {
		System.out.println("Static Initializer is called when Class is loaded");
		System.out.println("Count when Static Initializer is run "+count);
	}

	public static void main(String[] args) {
		InitializerExample i1 = new InitializerExample();
		InitializerExample i2 = new InitializerExample();
		InitializerExample i3 = new InitializerExample();
	}

}
