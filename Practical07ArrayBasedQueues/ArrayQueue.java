package Practical07;
// Create a class called ArrayQueue that implements the Queue interface
// provided. Include two constructors: a default constructor (no parameters) that
// creates a queue with a fixed capacity of 50; and a second constructor that takes
// a capacity as a parameter so that you can set the capacity of the queue when
// you create it. Implement the five methods specified in the Queue interface.

// Override the toString() method to provide a string based representation of the
// state of the queue (use the toString() method on the ArrayStack class as
// inspiration). Try to make the output meet the following format:
// [3] : “A”, “P”, “E”, null, null, ...
// Where this represents a queue that contains 3 values A, P, and E, which were
// enqueued in that order.
import Practical06.LinkedQueue;


public class ArrayQueue<T> implements Queue<T> {
	   private int N;
	   private T[] Q;
	   private int front = 0;
	   private int rear = 0;

	   //Default constructor that creates an array size of 50
	   public ArrayQueue() {
	    	this(50) ;
	     }
       //Constructor to create object with capacity
	   public ArrayQueue(int cap) {
		   N = cap;
		   Q = (T[]) new Object[N];
	   }

	   //Get size of queue
	   public int size() {
		   return (N+rear-front)%N;
	   }
 
	   //Add an item to the back of the queue
	   public void enqueue(T o) {
		   if((rear+1)%N==front) throw new QueueFullException() ;
		   Q[rear]=o;
		   rear=(rear+1)%N ;
	   }
	   
	   //Remove an item from the front of the queue
	   public T dequeue() {
		   if(isEmpty()) throw new QueueEmptyException() ;
		   T e = Q[front] ;
		   Q[front]=null;
		   front = (front+1)%N ;
		   return e ;
	   }
	   
	   //Check if queue is empty
	   public boolean isEmpty(){
		   return front==rear;
	   }
	   
	   //return the value of the item at the front of the queue
	   public T front() {
		   return Q[front] ;
	   }
	
       //override toString method
	   public String toString() {
		   String out = "[" + size() + "] : " ;
		   for (int i=front;((N+i+1)%N != front) ; i=((i+1)%N)) {
			   out = out + (Q[i]) + "," ;
		   }
		   return out;
	   }
	  
	   // Test to add strings to queue and make sure they print out correctly
	   public static void main(String[] args) {
			ArrayQueue<Character> queue =new ArrayQueue<Character>() ;
			queue.enqueue('A') ;
			queue.enqueue('P') ;
			queue.enqueue('E') ;
				
			System.out.println(queue) ;		
				
			
		   
	   }	
}
