package Practical03;
// Adapt the stack solution for String values by developing a class called
// StringStack and write a main method that performs the following operations:
// Push(“mat”), Push(“the”), Push(“the”), Pop(), Push(“on”), Push(“sat”),
// Push(“pat”), Pop(), Push(“cat”), Push(“the”), Pop(), Push(“The”)
// Once you have completed this list of operations, pop all the values off the
// stack until it is empty and print each value out in the order they are popped.
// What is the sentence that is created?
// NOTE: Because this stack deals with objects, you must modify the pop()
// method slightly. This is because when you use objects, you have to make sure
// that any reference to the object is removed. The danger of not doing this is that
// the link forces the JVM to keep the object in memory (even though it may no
// longer be used). This can result in a memory leak that will cause your program
// to crash after a period of time.
// A sketch of the pop method in pseudo code:
// Algorithm pop():
//     top ← top - 1
//     temp ← array[top]
//     array[top] ← null
//     return temp

public class StringStack {

	private String[] array = new String [10];
	private int top = 0;
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public void push(String value) {
		if (top == array.length) throw new StackFullException();
		array[top++] = value;
	}
	
	public String top() {
		if (top == 0) throw new StackEmptyException(); 
		return array[top-1];
	}

	public String pop() {
		if (top == 0) throw new StackEmptyException();
		String temp = array[--top] ;
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
		StringStack stack = new StringStack();
		
		stack.push("mat");
		
		stack.push("the");
		
		stack.push("the");
		
		System.out.print(stack.pop() + " ");
		
		stack.push("on");
			
		stack.push("sat");
		
		stack.push("pat");
		
		System.out.print(stack.pop() + " ");
		
		stack.push("cat");
		
		stack.push("the");
		
		System.out.print(stack.pop() + " ");
		
		stack.push("The");
	
	}
}
