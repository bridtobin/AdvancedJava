//W6Q3. Brid Delap. 
//Main method to test adding items to queue and removing items from queue
//and at the end dequeue the last items and total them.
package Practical06;

public class W6Q3 {

	public static void main(String[] args) {
			LinkedQueue<Integer> queue =new LinkedQueue<Integer>() ;
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
