package com.fp.practice;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers, find if there is a subarray (of size at-least one) with 0 sum
 * Output: Found a subarray with sum 0
 */
public class FindSubArrayWithSum0 {

	public static void main(String[] args) {
		int arr[] = {-3,3,3,1,6};
		if(subArrayExists(arr))
			System.out.println("Found a subarray with sum 0");
		else
			System.out.println("No such sub array exists!");
	}

	public static boolean subArrayExists(int[] arr) {
		int sum = 0;
		Set<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			sum = sum+arr[i];
			
			if(arr[i]==0 || sum == 0 || hs.contains(sum))
				return true;
			
			hs.add(sum);
		}
		return false;
	}
}
