package com.leetcode.exercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/knight-dialer/
 * Given a phone pad as below. List out all the phone numbers that can be made with 7 digits. 
 * The method of generating the numbers would be the movement of a rook. 
 * It can move vertically and horizontally by any number of steps.
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 
 * 
 *
 */
public class KnightDialer {
	
	public static int knightDialer(int n) {
		
		if(n==1)
			return 9;
		
		//Total 18 as we have 9 digits
		int[][] branches = {{1,6},{1,8},{2,9},
							{2,7},{3,8},{3,4},
							{4,9},{4,3},{6,7},
							{6,1},{7,2},{7,6},
							{8,3},{8,1},{9,2},
							{9,4}
							};
		
		long[] counts = new long[10];
		Arrays.fill(counts, 1);
		
		final int MOD = 1_000_000_007;
		for (int i = 1; i < n; i++) {
			long[] nextCounts = new long[10];
			for (int[] pair:branches) {
				nextCounts[pair[1]] = (nextCounts[pair[1]] + counts[pair[0]]) % MOD;
			}
			counts = nextCounts;
		}
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (int) ((sum + counts[i]) % MOD);
		}
		
		return sum;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number for which possible combinations of dialing can be done in the movement of a rook");
		int input = sc.nextInt();
		int output = knightDialer(input);
		System.out.println("The number of moves that can be made are: "+output);
	}

}
