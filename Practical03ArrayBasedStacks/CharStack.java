package Practical03;

//Adapt the stack solution for char values by developing a class called CharStack and write a main method that performs the following operations:
//Push(‘Y’), Push(‘P’), Push(‘P’), Push(‘A’), Push(‘H’), Pop(), Pop(), Pop(),Pop(), Pop()
//Print out each value that is popped using System.out.print(...). What does this code do? HINT: Think of the input as the characters from a word. Write a
//comment at the start of the main() method containing your answer.

public class CharStack {

	private char[] array = new char[5];
	private int top = 0;
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public void push(char value) {
		if (top == array.length) throw new StackFullException();
		array[top++] = value;
	}
	
	public char top() {
		if (top == 0) throw new StackEmptyException(); 
		return array[top-1];
	}

	public char pop() {
		if (top == 0) throw new StackEmptyException();
		
		return array[--top];
	}
	
	public String toString() {
		String out = "[" + top + " / " + array.length + "]";
		for (int i=0;i<array.length; i++) {
			out += " " + array[i];
		}
		return out;
	}
	// This code reverses a word
	public static void main(String[] args) {
		CharStack stack = new CharStack();
		
		
		stack.push('Y');
		
		stack.push('P');

		stack.push('P');
		
		stack.push('A');
		
		stack.push('H');
		
		System.out.print(stack.pop()) ;
		System.out.print(stack.pop()) ;
		System.out.print(stack.pop()) ;
		System.out.print(stack.pop()) ;
		System.out.print(stack.pop()) ;
	
	}
}


