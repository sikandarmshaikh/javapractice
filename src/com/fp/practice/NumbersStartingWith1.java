package com.fp.practice;

import java.util.Arrays;
import java.util.List;

/*
 * Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?
 * Output: 10 15 16 19
 */
public class NumbersStartingWith1 {

	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(10,34,22,15,16,55,19);
		myList.stream()
			  .map(s->s+"")
			  .filter(s->s.startsWith("1"))
			  .forEach(System.out::println);
	}
}
