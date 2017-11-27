/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example, given linked list 1->2->3->4->5 and n = 2, the result is 1->2->3->5.


 */

package com.nitin.algo;

import com.nitin.algo.LinkedListUtils.Node;

public class RemoveNthLastNode {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Node head = LinkedListUtils.createLinkedList(arr);
		LinkedListUtils.printList(head);
		int n = 6;
		head = removeNthFromLast(head, n);
		LinkedListUtils.printList(head);
	}

	private static Node removeNthFromLast(Node head, int n) {
		if(head == null || head.next == null)
			return head;
		
		Node p1 = head;
		Node pre = new Node(0);
		pre.next = head;
		Node p2 = head;
		
		while(n-- > 0) {
			if(p1 == null)
				return head;
			p1 = p1.next;
		}
		
		if(p2 == head) { // n is equal to size of list
			return p2.next;
		}
		
		while(p1 != null) {
			pre = pre.next;
			p2 = p2.next;
			p1 = p1.next;
		}
		
		
		//now p2 is nth from last and pre is one before p2, so need to remove p2
		pre.next = p2.next;
		
		return head;
		
	}

}
