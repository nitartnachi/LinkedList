/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

The program should run in O(1) space complexity and O(nodes) time complexity.

Example:

Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.
 */

package com.nitin.algo;

import com.nitin.algo.LinkedListUtils.Node;

public class OddEvenList {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Node head = LinkedListUtils.createLinkedList(arr);
		LinkedListUtils.printList(head);
		head = reorderOddEven(head);
		LinkedListUtils.printList(head);
	}

	private static Node reorderOddEven(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node first = head;
		Node second = head.next;
		Node secondHead = head.next;
		
		while(first != null && first.next != null) {
			first.next = second.next;
			if(first.next != null) {
				second.next = first.next.next;
				first = first.next;
			}
			second = second.next; 
		}
		first.next = secondHead;
		return head;
	}

}
