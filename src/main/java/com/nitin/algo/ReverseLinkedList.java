/*
 * Reverse a singly linked list. Iterative and recursive.
 */


package com.nitin.algo;

import com.nitin.algo.LinkedListUtils.Node;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node head = LinkedListUtils.createLinkedList(arr);
		LinkedListUtils.printList(head);
		
		head = reverseIterative(head);
		LinkedListUtils.printList(head);
		
		head = reverseRecursive(head);
		LinkedListUtils.printList(head);
	}

	private static Node reverseRecursive(Node head) {
		if (head == null || head.next == null)
			return head;
		
		Node first = head;
		Node second = head.next;
		
		head.next = null;
		
		Node curr = reverseRecursive(second);
	    second.next = head;
	 
	    return curr;
	}

	private static Node reverseIterative(Node head) {
		if (head == null || head.next == null)
			return head;
		
		Node pre = head;
		Node cur = pre.next;
		head.next = null;
		
		while(cur != null && pre != null) {
			Node nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		return pre;
	}

}
