package com.fp.practice;

public class MethodReferenceDemo {
	
	public static void main(String[] args) {
		FunctionalInterfaceDemo functionalInterfaceDemo = Test :: testImplementation;
		functionalInterfaceDemo.singleAbstractMethod();
		
		//If no testImplementation is available in existing code base then use following code
		// for lambda expressions
		
		FunctionalInterfaceDemo f = () -> System.out.println("Implementation of Single Abstract Method");
		f.singleAbstractMethod();
		
	}
	
}

class Test {
	public static void testImplementation() {
		System.out.println("This is test implementation of abstract method");
	}
}
