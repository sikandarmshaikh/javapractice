package com.fp.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Q10 Given a list of integers, sort all the values present in it in descending order using Stream functions?
 * Output: 9 8 7 6 5 4 3 2 1
 */
public class SortListInDescendingOrder {

	public static void main(String[] args) {

		List<Integer> myList = Arrays.asList(9,3,5,2,7,4,8,1,6);
		myList.stream()
		.sorted(Collections.reverseOrder())
		.forEach(System.out::println);
	}

}
