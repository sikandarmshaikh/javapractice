package com.leetcode.stirng.exercises;

import java.util.Scanner;

/*
 * https://leetcode.com/tag/string/
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
 * Return the minimum number of steps to make t an anagram of s.
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 * 
 * Example 1:
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * 
 */
public class IfStringIsAKAnagram {

	public static void main(String[] args) {
		
		System.out.println("Please enter the input string1 ");
		Scanner scan = new Scanner(System.in);
		String input1 = scan.nextLine();
		System.out.println("Please enter the input string2 ");
		String input2 = scan.nextLine();
		scan.close();
		System.out.println(input2+" is a Anagram of "+input1+" with Minimum steps : "+minSteps(input1, input2));
	}
	
	public static int minSteps(String s, String t) {
		
		int arr[]=new int [128];
		int n=s.length(), count = 0;
		for(int i=0;i<n;i++) {
			arr[s.charAt(i)]++;
			arr[t.charAt(i)]--;
		}
		
		for (int i = 'a'; i < 'z'; i++) {
			if(arr[i]>0)
				count+=arr[i];
		}
		
        return count;
    }


}
