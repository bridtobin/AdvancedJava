// Brid Delap.   Practical 09. Question 2.
// Implementing queue interface using a Linked List

// Develop an implementation of the Queue interface called LinkedListQueue
// that uses your List implementation (20%) include a main method that tests
// your implementation by performing the following operations:
// Enqueue(10), Enqueue(5), Dequeue(), Enqueue(15), Enqueue(3), Dequeue(),
// Enqueue(7), Dequeue(), Enqueue(20).
// Print out the state of the queue after each operation.
// Add a loop at the end that clears the queue and calculates the total value of the
// numbers were left in the queue at the end of the above sequence of operations. 
package Practical09;


public class LinkedListQueue<T> implements Queue<T> {
	LinkedList<T> lista = new LinkedList<T>() ;

	@Override
	public int size() {
		return lista.size();
	}

	@Override
	public boolean isEmpty() {
		return lista.isEmpty() ;
	}

	@Override
	public T front() {
		return lista.first().element() ;
	}

	@Override
	public void enqueue(T element) {
		lista.insertLast(element) ;
	}

	@Override
	public T dequeue() {
		return lista.remove(lista.first()) ;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return lista.toString();
	}
	 public static void main(String[] args) {
			LinkedListQueue<Integer> testlist =new LinkedListQueue<Integer>() ;
			testlist.enqueue(10);
			System.out.println(testlist) ;
			testlist.enqueue(5);
			System.out.println(testlist) ;
			testlist.dequeue() ;
			System.out.println(testlist) ;
			testlist.enqueue(15);
			System.out.println(testlist) ;
			testlist.enqueue(3);
			System.out.println(testlist) ;
			testlist.dequeue() ;
			System.out.println(testlist) ;
			testlist.enqueue(7);
			System.out.println(testlist) ;
			testlist.dequeue() ;
			System.out.println(testlist) ;
			testlist.enqueue(20);
			System.out.println(testlist) ;
			int totalValue = 0 ;
			while(!testlist.isEmpty()) {
				totalValue += testlist.dequeue() ;
				
			}
			System.out.println("Total Value is: " + totalValue);

	 }
	
}

