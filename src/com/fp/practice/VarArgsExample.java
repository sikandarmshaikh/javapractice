package com.fp.practice;

/*
 * This program is an example of how varagrs is used
 * 
 */
public class VarArgsExample {

	public static void main(String[] args) {
		VarArgsExample v1 = new VarArgsExample();
		System.out.println(v1.sum(1,4,5)); //10
		System.out.println(v1.sum(1,4,5,20)); //30
		System.out.println(v1.sum()); //0 
	}
	
	public static int sum(int... numbers) {
		int sum = 0;
		for (int num:numbers) {
			sum+=num;
		}
		return sum;
		
	}
}
