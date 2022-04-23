package com.fp.practice;

import java.util.Date;
import java.util.function.Supplier;

public class SuppplierDemo {

	public static void main(String[] args) {
		SuppplierDemo supplierDemo = new SuppplierDemo();
		System.out.println(supplierDemo.fetchCurrentDate());
		
		Supplier<Date> supplier = () -> new Date();
		System.out.println(supplier.get());
	}
	
	public static Date fetchCurrentDate() {
		return new Date();
	}
}
