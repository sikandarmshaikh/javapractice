package com.interviews.experience;

/**
 * https://www.geeksforgeeks.org/deficient-number/
 * In the number theory a deficient number is a number m for which the sum of division o(n)<2n. 
 * The value 2n-o(n) is called the number's deficiency. 
 * Write a function, that given a positive number n returns its deficiency or throws an exception
 * if the number is not deficient.
 * Examples: 
 * 1) -5->IllegalArgumentException: 
 * 2) 1->1
 * 3) 21->10
 * 4) 10->2
 * 5) 16->1
 * 6) 6->NotDeficientNumberException("Deficiency of number 6 is 0, which is less than 1")
 * 7) 20->NotDeficientNumberException("Deficiency of number 20 is 2, which is less than 1")
 */
public class FindDeficientNumber {
	
	public static void main(String[] args) throws Exception {
		int[] array = {5,4,4,7};
		System.out.println(numberDeficiency(20));
	}
	
	public static int numberDeficiency(int number) throws Exception{
		if(number<1) {
			throw new IllegalArgumentException("Argument number has to be a positive number!");
		}
		int sumOfDivisors = 0; // Fixed
		int count = 0, currentCoin = 0;
		for(int i=number;i>=1;i--) {
			if(number%i==0) {
				sumOfDivisors+=i;
			}
			if(sumOfDivisors>=2*number) { // Fixed
				throw new Exception("Deficiency of number "+number+
						" is "+(2*number-sumOfDivisors)+", which is less than 1");
			}
		}
		return 2*number-sumOfDivisors;
	}
}
