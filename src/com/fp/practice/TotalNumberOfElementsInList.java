package com.fp.practice;

import java.util.Arrays;
import java.util.List;

/*
 * Q5 Given a list of integers, find the total number of elements present in the list using Stream functions?
 * Output: 6
 */
public class TotalNumberOfElementsInList {

	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(11,22,33,44,55,66);
		long count = myList.stream()
			  .count();
		System.out.println(count);
	}

}
