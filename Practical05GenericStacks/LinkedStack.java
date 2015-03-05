package Practical05;


public class LinkedStack<T> implements Stack<T> {

	   private Node top = null;
	   private int size = 0;
	   
	   public int size() {
	      return size;
	   }

	   public boolean isEmpty() {
	      return size == 0;
	   }

	   public void push( T value ) {
	      Node n = new Node( value );
	      n.next = top;
	      top = n;
	      size++;
	   }

	   public T top() {
	      if ( isEmpty() ) {
	         throw new StackEmptyException();
	      }
	      return top.element;
	   }

	   public T pop() {
	      if ( isEmpty() ) {
	         throw new StackEmptyException();
	      }
	      T toReturn = top.element;
	      
	      top = top.next;
	      size--;
	      return toReturn;
	   }
	   
	   private class Node {
	      T element;
	      Node next;
	      
	      public Node( T value ) {
	         element = value;
	      }
	   }
	   
	   public String toString() {
	       
	      String out = "[" + size + " element(s)]: ";
	      Node n = top;
	      while ( n != null ) {
	         out += "[" + n.element + "|-]-> ";
	         n = n.next;
	      }
	      return out;
	   }
	   
	   public static void main(String[] args) {
			LinkedStack<Integer> stack =new LinkedStack<Integer>() ;
			stack.push(2) ;
			stack.pop();
			stack.push(4) ;
			stack.push(3) ;
			stack.pop() ;
			stack.push(6) ;
			stack.push(12) ;
			stack.pop() ;
			stack.push(5) ;
			stack.push(9) ;
			stack.pop() ;
			stack.push(3) ;
			System.out.println(stack) ;
			double total = 0  ;
			int count = 0 ;
			while (!stack.isEmpty()) {
					total += stack.pop() ;
					count++ ;
			}
			System.out.println("Average of total left on stack and now popped is: " + total/count) ;   
			
		}
	}

