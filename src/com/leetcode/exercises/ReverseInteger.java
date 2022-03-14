package com.leetcode.exercises;

import java.util.Scanner;

/**
 * 
 * https://leetcode.com/problems/reverse-integer/solution/
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * Input: x = 123
 * Output: 321
 * Input: x = -123
 * Output: -321
 * Input: x = 120
 * Output: 21
 * 
 */
public class ReverseInteger {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputStr = scan.nextLine();
		int input = Integer.parseInt(inputStr);
		
		
		reverseInteger(input);
		
	}

	private static void reverseInteger(int input) {
		System.out.println(input);
	}

}
