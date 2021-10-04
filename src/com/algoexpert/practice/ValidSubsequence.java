package com.algoexpert.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidSubsequence {

	public static void main(String[] args) {
		
		List<Integer> array = new ArrayList<>();
		array.add(5);
		array.add(1);
		array.add(22);
		array.add(25);
		array.add(6);
		array.add(-1);
		array.add(8);
		array.add(10);
		
		List<Integer> sequence = new ArrayList<>();
		sequence.add(1);
		sequence.add(6);
		sequence.add(-1);
		sequence.add(10);
		
		boolean result = isValidSubsequenceSol1(array, sequence);
		System.out.println("ValidSequence result Sol1 :: "+ result);
		boolean result2 = isValidSubsequenceSol2(array, sequence);
		System.out.println("ValidSequence result Sol2 :: "+ result2);
	}
	
	public static boolean isValidSubsequenceSol1(List<Integer> array, List<Integer> sequence) 
	{
		int arrIdx = 0;
		int seqIdx = 0;
		
		while(arrIdx < array.size() && seqIdx < sequence.size()) {
			if(array.get(arrIdx).equals(sequence.get(seqIdx))) {
				seqIdx++;
			}
				arrIdx++;
		}
		System.out.println("seqIdx::"+seqIdx+" sequence.size()::"+sequence.size());
		return seqIdx == sequence.size();
	}
	
	public static boolean isValidSubsequenceSol2(List<Integer> array, List<Integer> sequence) 
	{
		int seqIdx = 0;
		for (Integer value : array) {
			if(seqIdx == sequence.size()) {
				break;
			}
			if(sequence.get(seqIdx).equals(value)) {
				seqIdx++;
			}
		}
		
		return seqIdx == sequence.size();
	}

}
