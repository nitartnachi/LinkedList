/*
 * Manage creation, deletion, updates in linked list.
 */

package com.nitin.algo;

public class LinkedListUtils {

	// Node
	static class Node{
		int data;
		Node next;

		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public static Node createLinkedList(int[] arr) {
		Node head = new Node(arr[0]);
		Node curr = head;
		for(int i = 1; i < arr.length; i++) {
			Node temp = new Node(arr[i]);
			curr.next = temp;
			curr = curr.next;
		}
		return head;
		
	}
	
	public static void printList(Node head) {
		System.out.println("====================================Linked List====================================");
		while(head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println("NULL");
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		Node head = createLinkedList(arr);
		printList(head);
	}


}
