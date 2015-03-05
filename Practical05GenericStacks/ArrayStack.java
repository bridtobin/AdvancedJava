package Practical05;


public class ArrayStack<T> implements Stack<T> {
    private int capacity;
    private T[] array;
    private int top = 0;
 
    public ArrayStack() {
    	this(20) ;
     }
    
    public ArrayStack(int cap) {
        capacity = cap;
        array = (T[]) new Object[capacity];
   }
    
   

   		
	public int size() {
		return top;
	}
		
	public boolean isEmpty() {
		return top == 0;
	}
	
	
	public void push(T value) {
		if(size()==capacity) {
		    throw new StackFullException();
		}
		array[top++] = value;
	}
		
	public T top() {
		if (top == 0) throw new StackEmptyException(); 
		return array[top-1];
	}

	public T pop() {
		if (top == 0) throw new StackEmptyException();
		T temp = array[--top] ;
		array[top] = null ;
		return temp ;
	}
		
	public String toString() {
		String out = "[" + top + " / " + array.length + "]";
		for (int i=0;i<array.length; i++) {
			out += " " + array[i];
		}
		return out;
	}


public static void main(String[] args) {
	ArrayStack<Double> stack =new ArrayStack<Double>(4) ;
	stack.push(13.2) ;
	stack.push(4.2) ;
	stack.push(3.0) ;
	stack.push(2.6) ;
	stack.pop() ;
	stack.pop() ;
	stack.push(1.2) ;
	stack.pop() ;
	stack.push(5.4) ;
	stack.push(6.9) ;
	System.out.println(stack) ;
	double total = 0 ;
	while (!stack.isEmpty()) {
			total += stack.pop() ;
	}
	System.out.println("Total left on stack and now popped is: " + total) ;   
	
}

}
	