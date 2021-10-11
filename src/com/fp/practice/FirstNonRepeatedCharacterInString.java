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
		Character result = input.chars()  // Stream of String
						   .mapToObj(s->Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
							// Store the Chars in map with Count 
						   .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) 
						   .entrySet()
						   .stream()
						   .filter(entry -> entry.getValue() == 1L)
						   .map(entry->entry.getKey())
					       .findFirst()
					       .get();
	   System.out.println(result);
		}
}
