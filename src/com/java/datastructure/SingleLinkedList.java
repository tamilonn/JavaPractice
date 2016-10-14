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
		
		public Node(){}
		
		
		public Node(String name){
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
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
			System.out.println("--");
		}
		
		
	
	}
	

	/**
	 * A single linked list demo
	 * This creates a linked List with A,B,C,D,E,F
	 */
	public static void main(String[] args) {
		
		//when no list add new node as A
		Node top = null;
		top = addNode(top, "A");
		print(top);
		
		//add new node B
		top = addNext(top, "B");
		print(top);
		
		//add one more node as A B C
		top = addNext(top, "C");
		print(top);
		

		//add new node Z as TOP. as Z A B C
		top = addNode(top, "Z");
		print(top);
		
		//add new node Y as TOP. as  Y Z A B C
		top = addNode(top, "Y");
		print(top);
        
		//add new node X after A as Y Z A X B C (between A and B)
		top = addAfter(top, "A", "X");
		print(top);
		
		//add new node W after Z as Y Z W A X B C (between A and B)
		top = addAfter(top, "Z", "W");
		print(top);

	    //Reversion as C B X A W Z Y
		top = reverse(top);
		print(top);
	    
		

	}

//Y Z W A X B C 
	private static Node reverse(Node top) {
		
		//find last null node and make it top node
		int noOfNodes = 0;
		Node temp = top;
		while (temp.next != null){
			temp = temp.next;
			++noOfNodes;
		}
		System.out.println(noOfNodes);
		temp = top;
		Node move = null;
		for(int i=0; i < noOfNodes; i++ ){
			move = temp.next;
			move.setNext(temp);
			temp = temp.next;
		}
		
		System.out.println(noOfNodes);
	
		
		
		return move;
	}


	private static Node addAfter(Node top, String afterNodeName, String name) {
		
		Node temp = top;
		while(temp.name != null && !afterNodeName.equals(temp.name)){//A
			temp = temp.next;
		}
		
		Node temp2 = temp.next;// (B)
		Node newNode = new Node(name);//X
		newNode.next = temp2;
		temp.next = newNode;//add new node in after node
		return top;
	}


	private static Node addNode(Node top, String name) {
		if (top == null){
			top = new Node(name);
			return top;
		}
		Node temp = top;
		Node newNode = new Node(name);
		newNode.setNext(temp);
		top = newNode;
		return top;
	}


	/**
	 * Adds a new node to the linked list
	 * @param top
	 * @param string
	 * @return Top Linked list
	 */
	private static Node addNext(Node top, String name) {
		
		//If first node then return immediately
		if ( top == null ) {
			return addNode(top, name);
		} 
		
		//find last node and add new node
		Node temp = top;
		while(temp.next != null){
			temp = temp.next;
		}
		Node newNode = new Node(name);
		temp.next = newNode;
		return top;
	}

}
