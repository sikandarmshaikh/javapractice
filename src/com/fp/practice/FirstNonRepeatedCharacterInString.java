package com.fp.practice;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

/*
 * Q7 Given a String, find the first non-repeated character in it using Stream functions?
 * Output: j
 */
public class FirstNonRepeatedCharacterInString {

	public static void main(String[] args) {
		String input = "Functional prgramming in Java";
		
		int countUnique = firstUniqChar(input);
		System.out.println("First Unique Character is "+countUnique);
		
		Character result = input.chars() // Stream of String
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object
																					// and then to lowercase
				// Store the Chars in map with Count
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println(result);
	}

	public static Character firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int n = s.length();
		// build hash map : character and how often it appears
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// find the index
		for (int i = 0; i < n; i++) {
			if (map.get(s.charAt(i)) == 1)
				return s.charAt(i);
		}
		return null;
	}
}
