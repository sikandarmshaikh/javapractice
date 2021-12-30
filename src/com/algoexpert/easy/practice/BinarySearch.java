package com.algoexpert.easy.practice;

/**
 * 
 * 
 */
public class BinarySearch {
	
/**
	 * Binary Search Tree Construction
 * 			  1(Root)
 * 		2	    		   3		   
	4	 	  5   	   6       7
 8	   9  10    11	12   13  14  15
 * 
 * Input: array = [0,1,21,33,45,45,61,71,72,73]
 * target = 33
 * Output: true
 * target = 70
 * Output = false
 * */
	public static class BST{
		BST root, left, right;
		Integer data;
		
		public BST(Integer data) {
			this.data = data;
		}
		
		public BST(BST left, BST right, Integer data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		BST root = new BST(1);
		root.left = new BST(2);
		root.right = new BST(3);
		root.left.left = new BST(4);
		root.left.right = new BST(5);
		root.right.left = new BST(6);
		root.right.right = new BST(7);
		
		
	}
	
	public static Boolean binarySearchInteger(BST root) {
		
		
		return false;
	}

}
