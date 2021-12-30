package com.algoexpert.easy.practice;

import java.util.Arrays;
import java.util.Iterator;

/*
 * Given an array of positive Integers representing the values of coins in your possession, write a function 
 * that returns the minimum of amount of change that you cannot create.
 * Output: 20
 */
public class NonConstructibleChange {

	public static void main(String[] args) {
		
		int[] array = {5,7,1,1,2,3,22};
		int result = NonConstructibleChange.nonConstructibleChange(array);
		System.out.println(result);
	}
	
	public static int nonConstructibleChange(int[] coins) {
		
		int currentChangeCreated = 0;
		Arrays.sort(coins);
		
		for (int coin : coins) {
			if(coin > currentChangeCreated+1)
				return coin+=1;
			currentChangeCreated  = currentChangeCreated+coin;
		}
		
		return currentChangeCreated+1;
	}

}
