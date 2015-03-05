package Practical03;
// Adapt the stack solution for double values by developing a class called
// DoubleStack and write a main method that performs the following operations:
// Push(3.2), Pop(), Push(4.2), Push(3.0), Push(2.6), Pop(), Push(1.2), Pop(),
// Pop()

public class DoubleStack {

	private double[] array = new double[3];
	private int top = 0;
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public void push(double value) {
		if (top == array.length) throw new StackFullException();
		array[top++] = value;
	}
	
	public double top() {
		if (top == 0) throw new StackEmptyException(); 
		return array[top-1];
	}

	public double pop() {
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
	
	public static void main(String[] args) {
		DoubleStack stack = new DoubleStack();
		
		stack.push(3.2);
		System.out.println(stack);
		
		stack.pop();
		System.out.println(stack);
		
		stack.push(4.2);
		System.out.println(stack);
		
		stack.push(3.0);
		System.out.println(stack);
		
		stack.push(2.6);
		System.out.println(stack);
		
		stack.pop();
		System.out.println(stack);
					
		stack.push(1.2);
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);
			
		stack.pop();
		System.out.println(stack);
			

	}
}


