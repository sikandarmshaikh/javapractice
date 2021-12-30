package com.leetcode.exercises;

import java.util.Scanner;

/**
 * JPMC 4th round Question Print all Prime numbers until the given input:
 * 26 Output: 2 3 5 7 11 13 17 19 23
 */
public class PrintPrimeNumbersTillTheInputProvided {

	public static void main(String[] args) {
		
		System.out.println("Enter the value of n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		String primeNumbers = "";
		for (int i = 0; i < n; i++) {
			int counter=0;
			for (int j = i;j >=1; j--) {
				if(i%j==0) {
					counter+=1;
				}
			}
			if(counter==2) {
				primeNumbers+=" "+i;
			}
		}
		System.out.println("Prime numbers from 1 to "+n+" are: ");
		System.out.println(primeNumbers);
	}
}
