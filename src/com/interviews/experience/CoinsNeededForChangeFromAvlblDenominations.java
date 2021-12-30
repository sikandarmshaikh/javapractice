package com.interviews.experience;

/**
 * 
 * Find the Coins needed for Change from the Available denominations : 200,100,50,20,10,5,2,1
 * Examples: 
 * 1) -12->IllegalArgumentException
 * 2) 10->1
 * 3) 1021->7, because:1X1+1X20+5X200=1021
 * 4) 1379->12, because  2X2+1X5+1X20+1X50+1X100+6X200 = 379
 */
public class CoinsNeededForChangeFromAvlblDenominations {
	
	public static void main(String[] args) {
		int[] array = {5,4,4,7};
		System.out.println(coinsNeededFor(1379));
	}
	
	public static int coinsNeededFor(int amount) {
		if(amount<0) {
			throw new IllegalArgumentException("amount must be a positive number");
		}
		final int[] coins = {200,100,50,20,10,5,2,1};
		int count = 0, currentCoin = 0;
		while(amount>0 && currentCoin < coins.length) {
			int neededAmount = amount / coins[currentCoin];
			amount = amount-coins[currentCoin]*neededAmount;
			count = count+neededAmount;
			currentCoin++;
		}
		return count;
	}
}
