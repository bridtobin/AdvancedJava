package Practical04;

//import Practical03.StackEmptyException;

public class ArrayStack implements Stack {
	private Object[] array = new Object[4];
	private int top = -1;
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(Object value) {
		if (top == (array.length -1)) throw new StackFullException();
		array[++top] = value;
		System.out.println(" top = " + top) ;
		for (int i=0;i<array.length;i++) {
			System.out.println(array[i]) ;
		}
	}
	
	public Object top() {
		if (top == -1) throw new StackEmptyException(); 
		return array[top];
	}

	public Object pop() {
		System.out.println("Value of top is: " + top) ;

		if (top == -1) throw new StackEmptyException();
		Object temp = array[top] ;
		array[top--] = null ;
		return temp ;
	}
	
	public String toString() {
		String out = "[" + top + " / " + array.length + "]";
		for (int i=0;i<array.length; i++) {
			out += " " + array[i];
		}
		return out;
	}

}
