package Practical07;
// Write a main method that performs the following operations on an integer
// queue (you must use the ArrayQueue implementation here):
// Enqueue(10), Enqueue(5), Dequeue(), Enqueue(15), Enqueue(3), Dequeue(),
// Enqueue(7), Dequeue(), Enqueue(20).
// Print out the state of the queue after each operation.
// Add a loop at the end that clears the queue and calculates the total value of the
// numbers were left in the queue at the end of the above sequence of operations.

public class W7Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Add and remove items from queue
		ArrayQueue<Integer> queue =new ArrayQueue<Integer>(10) ;
		queue.enqueue(10) ;
		System.out.println(queue) ;		
		queue.enqueue(5) ;
		System.out.println(queue) ;		
		queue.dequeue() ;
		System.out.println(queue) ;		
		queue.enqueue(15) ;
		System.out.println(queue) ;		
		queue.enqueue(3) ;
		System.out.println(queue) ;		
		queue.dequeue() ;
		System.out.println(queue) ;		
		queue.enqueue(7) ;
		System.out.println(queue) ;		
		queue.dequeue() ;
		System.out.println(queue) ;		
		queue.enqueue(20) ;
		System.out.println(queue) ;	

		int value = 0;
		
		// print the total value  of the items left in queue and dequeue them
		while (!queue.isEmpty()) {
			value+=queue.dequeue() ;
		}
		System.out.println("Total Value = " + value) ;


	}

}
