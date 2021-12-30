package com.interviews.experience;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		System.out.println("Please enter the input string ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		System.out.println(input+" string reverse is "+reverseString(input));
	}

	private static String reverseString(String input) {
		
		char[] carray = input.toCharArray();
		String reverseString = "";

		for(int i=carray.length - 1;i>=0;i--)
			reverseString+=carray[i];
		
		return reverseString+"";
	}

}
