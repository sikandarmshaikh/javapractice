package com.algoexpert.practice;

public class QuickSort {

	public static void main(String[] args) {
		
		int intArray[] = {20, 35, -15, 7, 55, 1, -22};
		
		quickSort(intArray, 0, intArray.length);
		
		for(int i=0;i<intArray.length;i++) {
			System.out.println(intArray[i]);
		}

	}
	
	public static void quickSort(int[] input, int start, int end) {
		
		if(end - start < 2) {
			return;
		}
		
		int pivotIndex = partition(input, start, end);
		quickSort(input, start, pivotIndex);
		quickSort(input, pivotIndex+1, end);
	}

	public static int partition(int[] input, int start, int end) {
		
		int pivot = input[start];
		int i = start;
		int j = end;
		
		while (i<j) {
			//Empty Loop to reach till the element which is greater than or equal to the pivot in Left Array
			while(i<j && input[--j] >= pivot);
			
			// If i has crossed over j then put the value at jth position in ith position
			if(i<j) {
				input[i] = input[j];
			}
			
			//Empty Loop to reach till the element which less than or equal to the pivot in Right Array
			while(i<j && input[++i] <= pivot);
				
				// If i has crossed over j then put the value at ith position in jth position
				if(i<j) {
					input[j] = input[i];
				}
			}
		
		// Dont Forget to add the pivot at its proper position which is 4th position in the Array for 1st iteration
		input[j] = pivot;
		return j;
	}
	

}
