package com.algoexpert.easy.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Find the total waiting time for the elements given in the array
 * The array can't be empty and atleast 1 element should be present
 * Input: 3,2,1,2,6
 * Output: 17
 *
 * Solution is to sort the array in ascending order and then calculate the minimum
 * waiting time
 */
public class MinimumWaitingTime {

	public static void main(String[] args) {
		List<Integer> input  = Arrays.asList(3,2,1,2,6);
		int output = findMinimumWaitingTime(input);
		System.out.print("Minimum Waiting Time = "+output);
	}

	private static int findMinimumWaitingTime(List<Integer> input) {
		Collections.sort(input); 
		int queriesLeft = 0, duration = 0, totalWaitingTime = 0;
		for (int counter = 0; counter < input.size(); counter++) {
			duration = input.get(counter);
			queriesLeft = input.size() - (counter+1);
			totalWaitingTime += duration * queriesLeft;
		}		
		return totalWaitingTime;
	}
}
