package Practical05;
// In the course notes, you will find a slide on parenthesis matching (Lecture 4).
// Implement this algorithm. Test your answer on the following string:
// SEQ(PAR(boil kettle, wash cup), add teabag, WAIT({kettle boiled}, add
// water, add milk)
public class W5Q4 {
public static void main(String[] args) {
	// create an array to hold the characters
	char [] X = new char [100] ;
	String inputString = "SEQ(PAR(boil kettle, wash cup), add teabag,"
			+ " WAIT({kettle boiled}, add water, add milk)" ;
	// Assign the string to the character array
	for(int i=0;i<inputString.length();i++) {
		X[i] = inputString.charAt(i) ;
	}
	// Call the ParenMatch method and print message accordingly.
	if(ParenMatch(X,X.length) == true) {
		System.out.println("Grouping symbols matched") ;
	}
	else {
		System.out.println("Grouping symbols didn't match") ;
	}
} // main


public static boolean ParenMatch(char[] X,int n) {
	LinkedStack<Character> stack = new LinkedStack<Character>() ;
	char compareChar = ' ';

	for(int i=0;i<n;i++) {
		// Check if the character is an opening grouping symbol
		if(X[i] == '(' || X[i] == '{' || X[i]=='[') {
			stack.push(X[i]) ;
		}  // if(X[i]==''('
		else {
			// Check if the character is a closing grouping symbol
			if (X[i] == ')' || X[i] == '}' || X[i]==']') {
				// If the stack is empty, then a corresponding opening grouping symbol hasn't been added
				if(stack.isEmpty()) {
					return false ;
				} // (X[i] == ')'
				// Store the opening grouping symbol that you want to compare with the closing grouping symbol to a temporary variable
				switch(X[i]) {
					case ')': compareChar = '('; break ; 
					case '}': compareChar = '{'; break ;
					case ']': compareChar = '['; break ;
				} // switch
				// Compare that variable to the character popped off the stack.  If they don't match return false
				if(stack.pop().toString().charAt(0) != compareChar) {
					return false ;
				} /// if(stack.pop()
			} // if (X[i] == ')
		} // else
	} // for loop
	// if the stack is empty at the end then the grouping symbols matched - return true otherwise return false
	return stack.isEmpty() ;
} // parenMatch

}