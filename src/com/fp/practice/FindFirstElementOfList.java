package com.fp.practice;

import java.util.Arrays;
import java.util.List;

/*
 * Q4 Given the list of integers, find the first element of the list using Stream functions?
 * Output: 11
 */
public class FindFirstElementOfList {

	public static void main(String[] args) {
		
		List<Integer> myList = Arrays.asList(11,22,33,44,55,66);
		myList.stream()
			  .findFirst()
			  .ifPresent(System.out::println);
	}

}
