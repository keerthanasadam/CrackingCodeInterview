package org.com.linkedlist;

import java.util.Hashtable;

class Node {
	private Node next;
	private char data;

	public Node(char data) {
		this.data = data;
		next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}
}

public class RemoveDuplicates {
	static Node head;

	public static void insert(char insert_ele) {
		if (head == null) {
			Node new_node = new Node(insert_ele);
			head = new_node;
		} else {
			Node after = head;
			Node new_node = new Node(insert_ele);
			while (after.getNext() != null) {
				after = after.getNext();
			}
			after.setNext(new_node);
		}
	}

	public static void remove() {
		Node after = head;
		//int size=RemoveDuplicates.size();
		char curr_data = after.getData();
		for (int i = 0; i <RemoveDuplicates.size(); i++) {
			while (after != null) {
				if (after.getNext() != null && after.getNext().getData() == curr_data) {
					Node temp = after.getNext();
					after.setNext(temp.getNext());
					temp.setNext(null);
				}
				if (after.getNext() == null) {
					after = null;
					break;
				}
				after=after.getNext();
			}
			Node p = head;
			int j = i + 1;
			while (j > 0) {
				if(p!=null){
					p = p.getNext();
				}
				j--;
			}
			if(p!=null){
				curr_data = p.getData();
				after=p;
			}
			
		}
	}
	//using hashtable
	public static void remove1(){
		Hashtable<Character,Boolean> hash=new Hashtable<>();
		Node after=head;
		Node previous=null;
		while(after!=null){
			if(hash.containsKey(after.getData())){
				previous.setNext(after.getNext());
			}
			else{
				hash.put(after.getData(), true);
				previous=after;
			}
			after=after.getNext();
		}
	}
	//using 2 pointers
	public static void remove2(){
		Node current=head;
		while(current!=null){
			Node runner=current;
			while(runner.getNext()!=null){
				if(runner.getNext().getData()==current.getData()){
					runner.setNext(runner.getNext().getNext());
				}else{
					runner=runner.getNext();
				}
				
			}
			current=current.getNext();
		}
	}
	public static int size() {
		Node after = head;
		int count = 1;
		while (after.getNext() != null) {
			count++;
			after = after.getNext();
		}
		return count;
	}

	public static void display() {
		Node after = head;
		while (after != null) {
			System.out.println(after.getData() + "->" + after.getNext());
			after=after.getNext();
		}
	}

	public static void main(String args[]) {
		RemoveDuplicates.insert('F');
		RemoveDuplicates.insert('O');
		RemoveDuplicates.insert('L');
		RemoveDuplicates.insert('L');
		RemoveDuplicates.insert('O');
		RemoveDuplicates.insert('W');
		RemoveDuplicates.insert('U');
		RemoveDuplicates.insert('F');
		RemoveDuplicates.remove2();
		RemoveDuplicates.display();
	}
}
