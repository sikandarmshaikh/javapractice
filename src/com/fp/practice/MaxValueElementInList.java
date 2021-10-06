package com.fp.practice;

import java.util.Arrays;
import java.util.List;

/*
 * Q6 Given a list of integers, find the maximum value element present in it using Stream functions?
 * Output: 66
 */
public class MaxValueElementInList {

	public static void main(String[] args) {
		
		List<Integer> myList = Arrays.asList(11,22,33,44,55,66);
		Integer max = myList.stream()
			  .max(Integer::compare)
			  .get();
		System.out.println(max);
	}

}
