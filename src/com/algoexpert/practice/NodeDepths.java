package com.algoexpert.practice;

import com.algoexpert.practice.BranchSums.BinaryTree;

public class NodeDepths {

	public static void main(String[] args) {
		
		BinaryTree bt = new NodeDepths.BinaryTree(1);
		bt.left = new NodeDepths.BinaryTree(2);
		bt.right = new NodeDepths.BinaryTree(3);
		bt.left.left = new NodeDepths.BinaryTree(4);
		bt.left.right = new NodeDepths.BinaryTree(5);
		bt.right.left = new NodeDepths.BinaryTree(6);
		bt.right.right = new NodeDepths.BinaryTree(7);
		bt.left.left.left = new NodeDepths.BinaryTree(8);
		bt.left.left.right = new NodeDepths.BinaryTree(9);
		
		int sum = NodeDepths.nodeDepths(bt);
		System.out.println("Node Depth of the Bunary Tree is "+sum);
	}
	
	public static int nodeDepths(BinaryTree root) {
		return nodeDepthsHelper(root,0);
	}
	
	/**
	 * Recursive approach
	 * 
	 */
	public static int nodeDepthsHelper(BinaryTree root, int depth) {
		if(root==null)
			return 0;
		return depth+nodeDepthsHelper(root.left, depth+1)+nodeDepthsHelper(root.right, depth+1);
	}

	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

}
