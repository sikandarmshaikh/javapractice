package com.algoexpert.practice;

import java.util.ArrayList;
import java.util.List;

/*
 * Find the Sum of all the branches in a Binary Tree
 * The branch sum is like calculating sum of all the nodes that lead to a leaf node
 * The total number of sums will be equal to total number of Leaf nodes
 * 
 * Output: 15 16 18 10 11 
 */
public class BranchSums {

	public static void main(String[] args) {
		
		BinaryTree bt = new BranchSums.BinaryTree(1);
		//bt.value = new BranchSums.BinaryTree(1);
		bt.left = new BranchSums.BinaryTree(2);
		bt.right = new BranchSums.BinaryTree(3);
		bt.left.left = new BranchSums.BinaryTree(4);
		bt.left.right = new BranchSums.BinaryTree(5);
		bt.right.left = new BranchSums.BinaryTree(6);
		bt.right.right = new BranchSums.BinaryTree(7);
		bt.left.left.left = new BranchSums.BinaryTree(8);
		bt.left.left.right = new BranchSums.BinaryTree(9);
		bt.left.right.left = new BranchSums.BinaryTree(10);
		
		List<Integer> sums = BranchSums.branchSums(bt);
		/*for (Integer value : sums) {
			System.out.print(value+" ");
		}
		System.out.println();*/
		sums.stream().forEach(System.out::println);
	}
	
	public static List<Integer> branchSums(BinaryTree root) {
		List<Integer> sums = new ArrayList<Integer>();
		calculateBranchSums(root,0,sums);
	    return sums;
	  }
	
	public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
		
		long correctCnt = 0, checkedExcCnt = 0, uncheckedExcCnt = 0, otherExcCnt = 0; 
		
		try {
			
		} catch (Error e) {
			otherExcCnt++;
		} catch(RuntimeException re) {
			uncheckedExcCnt++;
		} catch(Exception e) {
			checkedExcCnt++;
		}
		
		for (Integer integer : sums) {
			
		}
		
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
		protected BinaryTree left;
		protected BinaryTree right;

		protected BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

}
