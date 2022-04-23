package com.fp.practice;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
	
	void singleAbstractMethod();
	default void printName() {
		System.out.println("This is default method in Functioanal Interface");
	}
	
	default void printName2() {
		System.out.println("Create as many default methods as needed in Functioanal Interface");
	}

}
