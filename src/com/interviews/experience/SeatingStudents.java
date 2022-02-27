package com.interviews.experience;

import java.util.Arrays;

public class SeatingStudents {
	
	public static int SeatingStudents(int[] arr) {
		
		/*int N = arr.size();
		if (N <= 1) {
			return 0;
		}
		sort(arr.begin(), arr.end());

		int res = 0;*/

		// arrange in this order
		// 0 2 4 ... N-1 N-2 N-4 ... 5 3 1 //N is odd
		// 0 2 4 ... N-2 N-1 N-3 ... 5 3 1 //N is even
	/*	for (int i = 2; i < N; i++) {
			res = max(res, arr[i] - arr[i - 2]);
		}
		return max(res, arr[N - 1] - arr[N - 2]);
	*/
		return 0;
	}

	  public static void main (String[] args) {  
	    // keep this function call here    
	    
	    System.out.print("Test 1 passing: " + (SeatingStudents(new int[] {6, 4}) == 4) + "\r\n");
	    System.out.print("Test 2 passing: " + (SeatingStudents(new int[] {8, 1, 8}) == 6) + "\r\n"); 
	    System.out.print("Test 3 passing: " + (SeatingStudents(new int[] {4, 1, 2, 3, 4}) == 0) + "\r\n");
	    System.out.print("Test 4 passing: " + (SeatingStudents(new int[] {4}) == 4) + "\r\n"); 
	  }

	}


