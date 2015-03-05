package Practical05;

public class genericLongStack {
	public static void main(String[] Args) {
		ArrayStack<Long> stack = new ArrayStack<Long>(6) ;
		stack.push(2l);
		stack.pop() ;
		stack.push(2000000l);
		stack.push(3000000l);
		long total = 0 ;
		while (!stack.isEmpty()) {
			total += stack.pop() ;
		}
		System.out.println(total) ;

	}

}
