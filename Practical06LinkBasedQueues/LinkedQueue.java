//Practical 06. Brid Delap.  
package Practical06;

// Create a class called LinkedQueue that implements the Queue interface
// provided. Copy the inner Node class implementation from the LinkedStack
// class. Implement the five methods specified in the Queue interface

// Override the toString() method to provide a string based representation of the
// state of the queue (use the toString() method on the LinkedStack class as
// inspiration). Try to make the output meet the following format:
// [3] : [“A”]->[“P”]->[“E”]->
// Where this represents a queue that contains 3 values A, P, and E, which were
// enqueued in that order. 


public class LinkedQueue<T> implements Queue<T> {

	   private Node rear = null;
	   private Node front = null;
	   private int size = 0;
	   
	   public int size() {
	      return size;
	   }

	   // check if the queue is empty
	   public boolean isEmpty() {
	      return size == 0;
	   }
	   
	   // add a new value to the rear of the queue
	   public void enqueue( T value ) {
	      Node n = new Node( value );
	      if(rear==null) {
	    	  front=n ;
	      }
	      else {
	    	  rear.next = n ;
	      }
	      rear = n ;
	      size++ ;
	   }

	   // check what item is at the front of the queue
	   public T front() {
	      if ( isEmpty() ) {
	         throw new StackEmptyException();
	      }
	      return front.element;
	   }

	   // Remove element from the front of the queue.
	   public T dequeue() {
	      if ( isEmpty() ) {
	         throw new StackEmptyException();
	      }
	      T e = front.element;
	      front = front.next ;
	      if(front==null) {
	    	  rear=null ;
	      }
	      size--;
	      return e ;
	   }
	   
	   // Define inner class Node
	   private class Node {
	      T element;
	      Node next;
	      
	      public Node( T value ) {
	         element = value;
	      }
	   }
	   
	   // Override toString method for queues
	   public String toString() {
	       
	      String out = "[" + size + "] : ";
	      Node n = front ;
	 	      
	    while ( n != null ) {
	       out += "[" + "\"" + n.element + "\"" + "]->";
	       n = n.next;
	     }
	      return out;
	   }
	   
	   // Test to add strings to queue and make sure they print out correctly
	   public static void main(String[] args) {
			LinkedQueue<Character> queue =new LinkedQueue<Character>() ;
			queue.enqueue('A') ;
			queue.enqueue('P') ;
			queue.enqueue('E') ;
			System.out.println(queue) ;		
				
			
		   
	   }		
	
	}

