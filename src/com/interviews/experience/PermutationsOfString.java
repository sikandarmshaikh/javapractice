package com.interviews.experience;

/**
 * Print all the permutations of a String recursively
 * Example 1: 
 * input: abc
 * Output: abc acb bac bca cab cba 
 * Example 2: 
 * input: abcd
 * Output: abcd abdc acbd acdb adbc adcb bacd badc bcad bcda bdac bdca cabd cadb cbad cbda cdab cdba dabc dacb dbac dbca dcab dcba 
 *
 */
public class PermutationsOfString {
	static void printPermutn(String str, String ans)
	{

		// If string is empty
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) +
						str.substring(i + 1);

			// Recurvise call
			printPermutn(ros, ans + ch);
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		String s = "abcd";
		System.out.println("All permutations of the String "+s+" are: ");
		printPermutn(s, "");
	}}
