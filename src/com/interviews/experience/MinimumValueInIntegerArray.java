package com.interviews.experience;

/**
 * 
 * Find the minimum value in the Integer Array
 * Examples: 
 * 1) array = null 
 * result: IllegalArgumentException: The Array must not be null
 * 2) array: []
 * result: IllegalArgumentException: Array cant be empty
 * 3) array: [1]
 * result: 1
 * 4) array: [5,4,4,7]
 * result: 4
 * 5) array: [4,4]
 * result: 4
 * 6) array: [4,5,-4,3]
 * result: -4
 * 
 */
public class MinimumValueInIntegerArray {
	
	public static void main(String[] args) {
		int[] array = {5,4,4,7};
		System.out.println(searchMinValue(array));
	}
	
	public static int searchMinValue(int[] array) {
		if(array==null) {
			throw new IllegalArgumentException("The Array must not be null");
		}
		if(array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty");
		}
		int min = array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
}
