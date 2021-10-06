package com.fp.practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Q8 Given a String, find the first repeated character in it using Stream functions?
 * Output: a
 */
public class FirstRepeatedCharacterInString {

	public static void main(String[] args) {
		
		String input = "Java 8 Functional prgramming is Awesome";
		
		Character result = input.chars()  // Stream of String
				   .mapToObj(s->Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
					// Store the Chars in map with Count 
				   .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) 
				   .entrySet()
				   .stream()
				   .filter(entry -> entry.getValue() > 1L)
				   .map(entry->entry.getKey())
			       .findFirst()
			       .get();
		System.out.println(result);
	}

}
