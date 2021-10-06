package com.algoexpert.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortSquaredArray {

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(-4,1,2);
		Collections.sort(array);
		System.out.println("Sorted Input Array : "+array);
		List<Integer> squaredArray = SortSquaredArray.sortedSquaredArraySol1(array);
		Collections.sort(squaredArray);
		System.out.println("Sorted Output Array : "+squaredArray);
		List<Integer> squaredArray2 =  SortSquaredArray.sortedSquaredArraySol2(array);
		Collections.sort(squaredArray2);
		System.out.println("Sorted Output Array Sol2 : "+squaredArray2);
	}

	// Time Complexity = O(nlogn). Space complexity = O(n) 
	public static List<Integer> sortedSquaredArraySol1(List<Integer> array) {
		
		List<Integer> squaredArray = new ArrayList<Integer>(); 
		for (Integer value : array) {
			squaredArray.add(value*value);
		}
		return squaredArray;
	}
	
	// Time Complexity = O(n). Space complexity = O(n) 
	public int[] sortedSquaredArray(int[] array) {
		int[] sortedSquares = new int[array.length];
		int smallerIdx = 0;
		int largerIdx = array.length - 1;
		for (int idx = array.length - 1; idx >= 0; idx--) {
			int smallerValue = array[smallerIdx];
			int largerValue = array[largerIdx];

			if (Math.abs(smallerValue) > Math.abs(largerValue)) {
				sortedSquares[idx] = smallerValue * smallerValue;
				smallerIdx++;
			} else {
				sortedSquares[idx] = largerValue * largerValue;
				largerIdx--;
			}

		}
		return sortedSquares;
	}
		
	// Time Complexity = O(n). Space complexity = O(n) 
	public static List<Integer> sortedSquaredArraySol2(List<Integer> array) {
		
		List<Integer> sortedSquares = new ArrayList<>(array.size());
		Integer smallerValueIdx = 0;
		Integer largerValueIdx = array.size() - 1;
		
		for (int i = 0; i < array.size(); i++) {
			Integer smallerValue = array.get(smallerValueIdx);
			Integer largerValue = array.get(largerValueIdx);
			
			if(Math.abs(smallerValue) < Math.abs(largerValue)) {
				sortedSquares.add(i, smallerValue*smallerValue);
				smallerValueIdx++;
			} else {
				sortedSquares.add(i, largerValue*largerValue);
				largerValueIdx--;
			}
		}
		
		return sortedSquares;
	}
}
