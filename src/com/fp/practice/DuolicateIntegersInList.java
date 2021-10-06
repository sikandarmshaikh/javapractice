package com.fp.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Q3 How to find duplicate elements in a given integers list in java using Stream functions?
 * Output: 11 22 33 44
 */
public class DuolicateIntegersInList {

	public static void main(String[] args) {
		
		List<Integer> myList = Arrays.asList(11,22,33,44,55,66,77,88,99,11,22,33,44);
		Set<Integer> set = new HashSet<Integer>();
		myList.stream()
			.filter(n->!set.add(n))
			.forEach(System.out::println);
	}

}
