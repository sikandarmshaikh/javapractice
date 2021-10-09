package com.algoexpert.practice;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 
 * Output: 
 */
public class BranchSums {

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree(0);
		bt.value = 1;
		bt.left.value = 2;
		bt.right.value = 3;
		bt.left.left.value = 4;
		bt.left.right.value = 5;
		bt.right.left.value = 6;
		bt.right.right.value = 7;
		bt.left.left.left.value = 8;
		bt.left.left.right.value = 9;
		bt.left.right.left.value = 10;
		
		List<Integer> sums = BranchSums.branchSums(bt);
		for (Integer value : sums) {
			System.out.print(value+",");
		}
		//sums.stream().forEach(System.out::println);
	}
	
	public static List<Integer> branchSums(BinaryTree root) {
		List<Integer> sums = new ArrayList<Integer>();
		calculateBranchSums(root,0,sums);
	    return sums;
	  }
	
	public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
		if(node == null)
			return;
		
		int newRunningSum = runningSum + node.value;
		if(node.left == null && node.right == null) {
			sums.add(newRunningSum);
			return;
		}
		calculateBranchSums(node.left, newRunningSum, sums);
		calculateBranchSums(node.right, newRunningSum, sums);
	}

	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

}
