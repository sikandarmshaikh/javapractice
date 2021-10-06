package com.fp.practice;

import java.util.Arrays;
import java.util.List;

/*
 * Q9 Given a list of integers, sort all the values present in it using Stream functions?
 * Output: 1 2 3 4 5 6 7 8 9
 */
public class SortListUsingStreams {

	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(1,3,2,6,5,7,9,8,4);
		myList.stream()
		.sorted()
		.forEach(System.out::println);
	}

}
