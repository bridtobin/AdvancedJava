//Brid Delap.   Practical 09. Question 1.

// Download the class called LinkedList that implements the List interface
// provided. Implement the 5 missing methods (10% per method). For the
// remaining 10%, override the toString() method to provide a string based
// representation of the state of the vector (use the toString() method on the
// LinkedStack and LinkedQueue classes as inspiration). Try to make the
// output meet the following format:
// [3] : “A”, “P”, “E”
// Where this represents a list that contains 3 values A, P, and E, which were
// inserted in that order.
// HINT: Implement this method before you implement the 5 missing List
// methods and use it to check that each method implementation is working
// correctly. 
package Practical09;




public class LinkedList<T> implements List<T> {
	private class Node implements Position<T> {
		T element;
		Node next, prev;
		
		public Node(T element) {
			this.element = element;
		}

		@Override
		public T element() {
			return element;
		}
	}
	
	Node front, rear;
	int size = 0;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Position<T> first() {
		if (front == null) throw new ListEmptyException();
		return front;
	}

	@Override
	public Position<T> last() {
		if (rear == null) throw new ListEmptyException();
		return rear;
	}

	@Override
	public Position<T> prev(Position<T> p) {
		// TODO Auto-generated method stub
    	if(((Node)p)==front) throw new ListOutOfBounds() ;
    	return ((Node)p).prev ;
	}

	@Override
	public Position<T> next(Position<T> p) {
		if(((Node)p)==rear) throw new ListOutOfBounds() ;
		return ((Node) p).next;
	}

	@Override
	public Position<T> insertFirst(T e) {
		Node n = new Node(e);
		if (front == null) {
			rear = n;
		} else {
			n.next = front;
			front.prev = n;
		}
		front = n;
		size++;
		return n;
	}

	@Override
	public Position<T> insertLast(T e) {
	   	Node node = new Node(e) ;
    	if (rear==null) {
    		front = node;
    	}
    	else {
    		rear.next = node ;
    		node.prev = rear ;
    	}
    	rear = node ;
    	size++ ;
    	return node;
    }
	

	@Override
	public Position<T> insertBefore(Position<T> p, T e) {
		// TODO Auto-generated method stub
	    if(p==front) {
	       	return insertFirst(e) ;
	    }
	    else {
	       	Node node = new Node(e) ;
	       	Node position = (Node)p ;
	       	node.prev = position.prev ;
	       	node.next = position ;
	       	position.prev.next = node ;
	       	position.prev = node ;
	       	size++ ;
	       	return node ;
	    }	
	}

	@Override
	public Position<T> insertAfter(Position<T> p, T e) {
		if (p == rear) return insertLast(e);
		
		Node node = (Node) p;
		
		Node n = new Node(e);
		n.next = node.next;
		n.prev = node;
		node.next.prev = n;
		node.next = n;
		size++;
		return n;
	}

	@Override
	public T replace(Position<T> p, T e) {
	   	T temp = p.element() ;
    	((Node)p).element= e;
    	return temp ;
	}

	@Override
	public T remove(Position<T> p) {
	   	Node position = (Node)p ;
    	if(position==front) {
    		front=front.next ;
    	}
    	else {
    		position.prev.next = position.next ;
    	}
    	
    	if(position==rear) {
    		rear=rear.prev ;
    	}
    	else {
    		position.next.prev = position.prev ;
    	}
    	size--;
    	return p.element();
	}
	
	 public String toString() {
	      String out = "[" + size + "]: ";
	      Node n = front;
	      while ( n != null ) {
	         out += n.element + ", ";
	         n = n.next;
	      }
	      return out;
	   }

}