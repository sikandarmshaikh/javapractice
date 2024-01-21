package com.leetcode.exercises;

import com.leetcode.exercises.BiinaryTreeInorderTraversal.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/symmetric-tree/description/
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
				1
		2				2
	3		4		4		3
			
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
			1
		2		2
			3		3
		
Input: root = [1,2,2,null,3,null,3]
Output: false

*/
public class SymmetricTree {
		
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public static void main(String[] args) {
			TreeNode root = new TreeNode(1);
			root.left = new TreeNode(2);
			root.right = new TreeNode(2);
			root.left.left = new TreeNode(3);
			root.left.right = new TreeNode(4);
			
			root.right = new TreeNode(2);
			root.right.left = new TreeNode(4);
			root.right.right = new TreeNode(3);
			System.out.println(isSymmetric(root));
			
			TreeNode root2 = new TreeNode(1);
			root2.left = new TreeNode(2);
			root2.left.right = new TreeNode(3);
			root2.right = new TreeNode(2);
			root2.right.right = new TreeNode(3);
			System.out.println(isSymmetric(root2));
			
		}
		
		public static boolean isSymmetric(TreeNode root) {
			if(root == null) return true;
			return helper(root.left, root.right);
		}
		
		public static boolean helper(TreeNode left, TreeNode right) {
			if(left == null && right == null) return true;
			if(left == null || right ==null && left.val != right.val) return false;
			return helper(left.left, right.right) && helper(left.right, right.left);
		}
	}
}


