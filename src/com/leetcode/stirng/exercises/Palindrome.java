package com.leetcode.stirng.exercises;

import java.util.Scanner;

/**
 * https://leetcode.com/tag/string/
 * https://leetcode.com/problems/longest-palindromic-substring
 * 
 * Check is a String is a Palindrome or not
 * Ex: LIRIL, ABBA, DAD, MOM are Palindromes
 * PAPA is not a Palindrome
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		
		System.out.println("Please enter the input string ");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		System.out.println(input+" is a Palindrome: "+isPalindrome(input));
		
	}

	private static Boolean isPalindrome(String input) {
		
		int i = 0, j = input.length()-1;
		
		while(i<j) {
			if(input.charAt(i)!=input.charAt(j))
				return false;
			
			i++;
			j--;
		}
		
		return true;
	}

}
