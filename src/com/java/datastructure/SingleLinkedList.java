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
		public String toString(){
			return this.name;
		}
		
	}
	
	private static void print(Node node){
		if (node != null){
			System.out.print("[ "+node.getName()+" ]");
			
			Node temp = node;
			while (temp.getNext() != null){
				System.out.print("[ "+temp.getNext().getName()+" ]");
				temp = temp.getNext();
			}
			System.out.println("");
		}
		
		
	
	}
	

	/**
	 * A single linked list demo
	 * This creates a linked List 
	 */
	public static void main(String[] args) {
		
		//when no list add new node as A
		Node top = null;
		top = addNode(top, "Tamil");
		print(top);
		
		//add new node B
		top = addNext(top, "Padmini");
		print(top);
		
		

		
        
		//add new node X after A as Y Z A X B C (between A and B)
		top = addAfter(top, "Padmini", "Tarun");
		print(top);
		
		//add new node W after Z as Y Z W A X B C (between A and B)
		top = addAfter(top, "Tarun", "Navya");
		print(top);

	    //Reversion as C B X A W Z Y
		top = reverseUgly(top);
		print(top);
		
		top = reverse1(top);
		print(top);
		
		top = reverseRecursive(top);
		print(top);
		

	}

	private static Node delete(Node top, String string) {
		Node temp = top;
		Node prev = null;
		
		while (temp.name != null && !temp.name.equals(string)){
			prev = temp;
			temp = temp.next;
		}
		
		Node childOfDeleteNode = temp.next;
		if (prev == null){
			prev = childOfDeleteNode;
			return prev;
		}else{
			prev.next = childOfDeleteNode;
		}
		
		return top;
	}
	
	private static Node reverseRecursive(Node currNode) {
		System.out.println("Starting...");
		if (currNode == null || currNode.next == null){
			return currNode;
		}
		System.out.println("call recursive function...");
		Node remaining = reverseRecursive(currNode.next);
		
		System.out.println("remaining = " + remaining);
		System.out.println("currNode = " + currNode);
		currNode.next.next = currNode;
		currNode.next = null;
		
		System.out.println("Return recursive function...");
		return remaining;
	}
	
	
	private static Node reverse1(Node currNode) {
		
		
		Node prevNode = null;
		Node nextNode = null;
		
		while (currNode != null){
			
			nextNode = currNode.next;
			
			currNode.next = prevNode;	
			
			
			prevNode = currNode;
			
			currNode = nextNode;		

		}
		
	   
		
		return prevNode;
	}
	



//Y Z W A X B C 
	private static Node reverseUgly(Node top) {
		
		//find last null node and make it top node
		int noOfNodes = 1;
		Node temp = top;
		
		while (temp.next != null){
			temp = temp.next;
			++noOfNodes;

		}
		
	    temp = top;
	    Node newTop = null;
		for(int i=0; i < noOfNodes; i++){
			while (temp.next != null){
				temp = temp.next;
				Node deleteNode = temp;
				if (deleteNode.next == null){
					newTop = addNext(newTop, deleteNode.name);
					temp = top;
					temp = delete(temp, deleteNode.name);
				}
			}
		}
		if (temp != null){//if last node
			newTop = addNext(newTop, temp.name);
		}
		System.out.println(noOfNodes);
		
		return newTop;
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
