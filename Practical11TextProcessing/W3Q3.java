//Worksheet 11. Question 3. Brid Delap. 
package Practical11;

// Create a class called W3Q3.java and copy the search algorithms you
// implemented in Q1 and Q2. Instrument your search algorithms (add code) to
// counting the number of comparisons that take place and to print this value to
// the console when each algorithm terminates.
// Implement a main method that performs the tests carried out in Q1 and Q2 and
// compare the number of comparisons. Add a comment at the top of the class
// that identifies, for each test, which algorithm took the least number of
// comparisons.
// HINT: the comment should look something like this:
//**
//* This is my answer…
//*/
public class W3Q3 { … }

/* This is my answer. Using the string 'the theme was their idea'
 * 
 * To find 'the' Boyce Moore and KMP Algorithm were the same with 3 comparisons.
 * To find 'there' (which did not match) Boyce Moore did 7 comparisons whereas KMP did 27 comparisons.
 * To find 'idea' Boyce Moore did 11 comparisons whereas KMP did 25 comparisons.
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class W3Q3 {
	static int countBM;
	static int countkmpSearch;
	public static int boyerMooreSearch(String T, String P) {
		if(P.length()>T.length()) {
			return -1;
		}
		countBM=0;
		Map<Character,Integer> L = lastOccurrenceMap(P);

		int m=P.length();
		int n=T.length();
		int i=m-1;
		int j=m-1;
		int l;
		do {
			countBM++ ;
			if(T.charAt(i)==P.charAt(j)) {
				if(j==0) {
					return i;
				} else	{
					i--;
					j--;
				} // if(j==0)
			} else { // if(T.chatAt....)
				l=lastOccurrence(L,T.charAt(i)) ;
				i=i+m-Math.min(j,l+1);
				j=m-1;
			} // else...if(T.charAt(i)
		} while (! (i>(n-1))) ;
		return -1;
	} // boyerMooreSearch method
	

	public static Map<Character,Integer> lastOccurrenceMap(String P) {
		Map<Character,Integer> L = new HashMap<Character, Integer>() ;
		for(int i=P.length()-1;i>=0;i--) {
			if(!L.containsKey(P.charAt(i)))
				L.put(P.charAt(i), i) ;
		}
		return L;
	}
	
	public static int lastOccurrence(Map<Character, Integer> L, char mismatchedChar) {
		if(L.containsKey(mismatchedChar)) {
			return L.get(mismatchedChar) ;
		} else {
			return -1;
		}
	}
	public static int kmpSearch(String T, String P) {
		countkmpSearch=0;
		int [] F = failureFunction(P) ;
		int i=0;
		int j=0;
		int n=T.length();
		int m=P.length();
		while(i<n) {
			countkmpSearch++;
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
		String P = "the" ;
		System.out.println("The position of pattern '" + P + "' in the string '" + T +"' using the Boyer Moore Search Algorithm is " +
		boyerMooreSearch(T,P) + " with "  + countBM+ " comparisons " ) ;
		System.out.println("The position of pattern '" + P + "' in the string '" + T +"' using the KMP Algorithm is " +
		kmpSearch(T,P) + " with " + countkmpSearch + " comparisons ");
		P = "there" ;
		System.out.println("The position of pattern '" + P + "' in the string '" + T +"' using the Boyer Moore Search Algorithm is " +
		boyerMooreSearch(T,P) + " with "  + countBM+ " comparisons " ) ;
		System.out.println("The position of pattern '" + P + "' in the string '" + T +"' using the KMP Algorithm is " +
		kmpSearch(T,P) + " with " + countkmpSearch + " comparisons ");
		P = "idea" ;
		System.out.println("The position of pattern '" + P + "' in the string '" + T +"' using the Boyer Moore Search Algorithm is " +
		boyerMooreSearch(T,P) + " with "  + countBM+ " comparisons " ) ;
		System.out.println("The position of pattern '" + P + "' in the string '" + T +"' using the KMP Algorithm is " +
		kmpSearch(T,P) + " with " + countkmpSearch + " comparisons ");


	}
}
