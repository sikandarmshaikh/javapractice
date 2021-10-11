package com.fp.practice;

import java.util.Arrays;

/**
 * 
 * Number of ways to color N-K blocks using given operation
 * Rearrange the given array in specified fashion — a1<a2>a3<a4
 * Given N blocks, out of which K is colored. These K-colored blocks are denoted by an array arr[]. 
 * The task is to count the number of ways to color the remaining uncolored blocks such that only any one of the adjacent blocks,
 *  of a colored block, can be colored in one step. Print the answer with modulo 109+7.
 * Output: 4
 * Reference: https://www.geeksforgeeks.org/number-of-ways-to-color-n-k-blocks-using-given-operation/
 */
public class WaysToColor {
	
	static int mod = 1000000007;
	 
	// Function to count the ways to color
	// block
	static int waysToColor(int arr[], int n, int k)
	{
	     
	    // For storing powers of 2
	    int powOf2[] = new int[500];
	 
	    // For storing binomial coefficient
	    // values
	    int [][]c = new int[500][500];
	 
	    // Calculating binomial coefficient
	    // using DP
	    for(int i = 0; i <= n; i++)
	    {
	       c[i][0] = 1;
	       for(int j = 1; j <= i; j++)
	       {
	          c[i][j] = (c[i - 1][j] +
	                     c[i - 1][j - 1]) % mod;
	       }
	    }
	 
	    powOf2[0] = powOf2[1] = 1;
	 
	    // Calculating powers of 2
	    for(int i = 2; i <= n; i++)
	    {
	       powOf2[i] = powOf2[i - 1] * 2 % mod;
	    }
	 
	    int rem = n - k;
	    arr[k++] = n + 1;
	     
	    // Sort the indices to calculate
	    // length of each section
	    Arrays.sort(arr);
	 
	    // Initialise answer to 1
	    int answer = 1;
	 
	    for(int i = 0; i < k; i++)
	    {
	         
	       // Find the length of each section
	       int x = arr[i] - (i - 1 >= 0 ?
	                     arr[i - 1] : 0) - 1;
	        
	       // Merge this section
	       answer *= c[rem][x] % mod * (i != 0 &&
	                                    i != k - 1 ?
	                                    powOf2[x] : 1) %
	                                    mod;
	       rem -= x;
	    }
	     
	    // Return the final count
	    return answer;
	}
	 
	// Driver Code
	public static void main(String[] args)
	{
	     
	    // Number of blocks
	    int N = 6;
	 
	    // Number of colored blocks
	    int K = 3;
	    int arr[] = { 1, 2, 6 ,0 };
	 
	    // Function call
	    System.out.print(waysToColor(arr, N, K));
	}

}
