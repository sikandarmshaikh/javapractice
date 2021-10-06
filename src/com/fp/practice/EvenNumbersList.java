package com.fp.practice;

import java.util.Arrays;
import java.util.List;

/*
 * Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?
 * Output: 10 9 8 98 32
 */
public class EvenNumbersList {

	public static void main(String[] args) {
		
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
		myList.stream()
		.filter(n->n%2==0)
		.forEach(System.out::println);
	}

}
