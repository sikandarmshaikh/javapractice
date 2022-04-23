package com.interviews.experience;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-only-letters/ 
 * 917. Reverse Only Letters
 * Input: Hello@$World
 * Output: dlroW@$olleH
 * 
 * Logic: Use a Stack to first add only letters in it and then take a StringBuilder and check whether the 
 * Character in input String is a character, if yes then pop the Stack and add it to StringBuilder otherwise it is a Special character
 * then add this Special Character to the StringBuilder
 * 
 */
public class ReverseOnlyLetters {
	
	public static void main(String[] args) {
		
		String input = new String("Hello@$World");
		System.out.println("Reverse String is : "+reverseString(input));
		
	}

	private static String reverseString(String S) { 
		
	Stack<Character> letters = new Stack<>();
	for(Character c: S.toCharArray()) {
		if(Character.isLetter(c))
			letters.push(c);
	}
	
	StringBuilder ans = new StringBuilder();
	for(char c: S.toCharArray()) {
		if(Character.isLetter(c))
			ans.append(letters.pop());
		else
			ans.append(c);
	}
		
    return ans.toString();}
	
}
