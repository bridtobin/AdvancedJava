package Practical04;
// Write a method called reverse() that uses a stack to reverse a string (HINT:
// Look at question 3 from worksheet 3). This method should return the reversed
// string. You can access the individual characters in a string by using the
// charAt(i) method, and you can get the length of a string by using the length()
// method. Test your answer by writing a main program that asks the user to
// input a string and then print the input string out in reverse.
// Example output:
// Input a string: HAPPY
// Reverse is: YPPAH
import java.util.Scanner;


public class W4Q3 {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack();
		System.out.print("Enter string: ") ;
		Scanner getInput = new Scanner(System.in);
		String userString = getInput.nextLine() ;
		for(int i=0; i<userString.length();i++) {
			stack.push(userString.charAt(i));
		}
		reverse(stack) ;
		getInput.close();

	}

	public static void reverse(ArrayStack stack) {
		int sizeStack = stack.size() ;
		for(int i=0; i<sizeStack; i++) {
			System.out.print(stack.pop()) ;
		}
	}


}
