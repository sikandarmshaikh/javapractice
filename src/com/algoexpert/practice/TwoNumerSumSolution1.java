package com.algoexpert.practice;

public class TwoNumerSumSolution1 {
	
	public static void main(String[] args) {
		
		int array[] = {3,5,-4,8,11,1,-1,6};
		int result[] = {0,0};
		result = twoNumberSum(array, 10);
		
		System.out.println(result[0]+" - "+result[1]);
		
	}
	
	public static int[] twoNumberSum(int[] array, int targetSum) {
		
	    for(int i=0;i<array.length-1;i++){
	    	int firstNum = array[i];
	    	for(int j=i+1;j<array.length;j++){
	    		int secondNum = array[j];
	    		if(firstNum+secondNum==targetSum){
					return new int[] {firstNum,secondNum};		
	    		}
	    	}
	    }
	    return new int[0];
	} 
}
