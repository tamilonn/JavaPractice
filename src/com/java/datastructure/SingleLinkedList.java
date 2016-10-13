/**
 * 
 */
package com.java.datastructure;

/**
 * @author tamil
 *
 */
public class SingleLinkedList {
	
	private static class Node {
		private String name = null;
		private Node next = null;
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the next
		 */
		public Node getNext() {
			return next;
		}
		/**
		 * @param next the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}
		
		@Override
		public String toString(){
			return name;
		}
		
	}
	
	private static void print(Node node){
		if (node != null){
			System.out.print(node.getName());
			
			Node temp = node;
			while (temp.getNext() != null){
				System.out.print(temp.getNext().getName());
				temp = temp.getNext();
			}
			System.out.print("----------------");
		}
		
		
	
	}
	

	/**
	 * A single linked list demo
	 * This creates a linked List with A,B,C,D,E,F
	 */
	public static void main(String[] args) {
		
		//when no list add new node as A
		Node top = null;
		Node newNode = new Node();
		newNode.setName("A");
		top = newNode;
		print(top);
		
		//add new node as A B
				
		newNode = new Node();
		newNode.setName("B");		
		top.setNext(newNode);
		print(top);
		
		//add new node as A B C
		newNode = new Node();
		newNode.setName("C");
		Node temp = top;
		while (temp.getNext() != null){			
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		
		//add new node as Z A B C
		newNode = new Node();
		newNode.setName("Z");
		temp = new Node();
		temp = top;
		newNode.setNext(temp);
		top = newNode;
		print(top);
		
		//add new node as Z A Y B C (between A and B)
		newNode = new Node();
		newNode.setName("Y");
		temp = top;
		
		while(temp.getName()!= null && !temp.getName().equals("A")){			
				temp = temp.getNext();		
		}
		Node temp2 = temp.getNext();//B
		temp.setNext(newNode);
		newNode.setNext(temp2);
		
	    print(top);
		

	}

}
