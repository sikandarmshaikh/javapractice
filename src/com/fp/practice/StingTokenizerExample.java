package com.fp.practice;

import java.util.Arrays;

/** 
 * Using Regex in Java example
 * Input: "1.0.56.255" and "ac.bd.def.e"
 * [1, 0, 56, 255]
 * [ac.bd.def.e]
 */
public class StingTokenizerExample {

	public static void main(String[] args) {
		String inputString = "1.0.56.255";
		//If we want to use a Dot as a Regex then it should be escaped and used
		String regex = "\\.";
		tokenize(inputString,regex);
		tokenize("ac.bd.def.e",";");	
	}

	private static void tokenize(String str, String regex) {
		String[] tokens = str.split(regex);
		System.out.println(Arrays.toString(tokens));
	}

}
