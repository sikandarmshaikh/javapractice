package com.interviews.experience;

/**
 * 
 * Reverse a String using recursive solution
 * Example 1:
 * input: interview
 * output: weivretni
 * 
 */
public class ReverseStringRecursively {
	
	public static void main(String[] args) {
		System.out.println(reverseString("interview"));
	}
	
	public static String reverseString(final String str) {
		if(str==null)
			throw new IllegalArgumentException("string cannot be null");
		String result = str;
		if(str.length()>1) {
			result = str.charAt(str.length() - 1) + reverseString(str.substring(0,str.length() - 1));
		}
		return result;
	}
}
