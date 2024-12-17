package com.learn.LinkedLists;

//temp pointer is to keep advancing until the data is distinct
// curr.next is then made to point to temp 

public class RemoveDuplicatedFromSortedLL {
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}		
	}
	
	public static void main(String[] args) {
		
		Node node = new Node(20);
		node.next = new Node(20);
		node.next.next = new Node(30);
		node.next.next.next = new Node(30);
		node.next.next.next.next = new Node(40);
		
		Node modifiedNode = removeDuplicates(node);
		
		while(modifiedNode != null) {
			System.out.println(modifiedNode.data);
			modifiedNode = modifiedNode.next;
		}
		
	}

	private static Node removeDuplicates(Node node) {
		
		Node head = node;
		Node temp = head;
		Node curr = head;
		
		while(curr != null) {
			
			while(temp != null && curr.data == temp.data) {
				temp = temp.next;
			}
			curr.next = temp;
			curr = curr.next;
		}	
		
		return head;
	}
}
