//Worksheet 11. Q1. Brid Delap. 
package Practical11;

// Copy the PatternMatching class to create a new class called W3Q1.java and
// create a new static method with the signature given below and implement the
// KMP Search Algorithm given in the notes (you may need to create additional
// methods, but these should be declared private because they are part of the
// implementation of the KMP Search Algorithm.
// public static int kmpSearch(String text, String pattern) {…}
// Test your answer by creating main method that searches the text “the theme
// was their idea” for the following patterns:
// the, there, idea

public class W3Q1 {


	public static int kmpSearch(String T, String P) {
		int [] F = failureFunction(P) ;
		int i=0;
		int j=0;
		int n=T.length();
		int m=P.length();
		while(i<n) {
			if(T.charAt(i)==P.charAt(j)) {
				if(j==m-1){
					return i-j;
				} else {
					i++;
					j++;
				} // if(j==m-1)
			} else {
				if(j>0){
					j=F[j-1];
				} else {
					i++;
				} // else...if(j>0)
			} // else...if(T.charAt
			
		} // while(i<n)
		return -1;
	} // function kmpSearch
	
	private static int[] failureFunction(String P) {
		int m = P.length();
		int F [] = new int[m] ;
		int i=1;
		int j=0;
		while(i<m) {
			if (P.charAt(i)==P.charAt(j)) {
				F[i]=j+1;
				i++;
				j++;
			} else {
				if(j>0) {
					j=F[j-1] ;
				} else {
					F[i]=0;
					i++;
				} // if(j>0)
				
				
			} // else...if P[i]
		} // while
	    return F;
	} //failureFunctions

	public static void main (String[] args) {
		String T = "the theme was their idea" ;
		System.out.println(kmpSearch(T,"the")) ;
		System.out.println(kmpSearch(T,"there")) ;
		System.out.println(kmpSearch(T,"idea")) ;
	}
}
