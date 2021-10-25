package com.leetcode.exercises;

/**
 * 
Given a linked list, determine if it has a cycle in it

Examples:
A → B → C → D - false

With cycle


                  D
              ↗       ↘
   A → B → C             E 
              ↖       ↙
                  F
 *
 */
public class LoopInLinkedList {
	
	public static class Node{
		
		String data;
		//Node prev;
		Node next;
		
		
		public Node(String data) {
			this.data = data;			
		}
		
		public Node(String data, Node next) {
			this.data = data;	
			this.next = next;
		}
		
	}
	
	public static void main(String[] args) {
		
		Node node = new Node("A");
		node.next = new Node("B");
		node.next.next = new Node("C");
		node.next.next.next = new Node("D");
		node.next.next.next.next = new Node("E");
		node.next.next.next.next.next = new Node("F");
		//node.next.next.next.next.next.next = node.next.next; // Point to C
		
		Boolean isLoopPresent = findLoop(node);
		System.out.println("isLoopPresent "+isLoopPresent);
	}

	private static Boolean findLoop(Node node) {
		
		Node slow  = node.next;
		Node fast  = slow.next;
		
		if(slow == null || fast == null) return false;
		
		if(node.next==null) return false;
		while (node.next != null) {
			if (slow == fast) {
				return true;
			} else if(fast == null){
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
				
			

		}
		
		return false;
	}
	
	
	
}
