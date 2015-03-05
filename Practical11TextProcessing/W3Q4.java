//Worksheet 11. Brid Delap. 
package Practical11;

// Create a class called W3Q4.java and copy the search algorithms you
// implemented in Q1 and Q2. Modify the implementations of all the search
// algorithms to allow the provision of an offset for the text (i.e. so we can say –
// search for this pattern in the text starting at character i).
// public static int kmpSearch(String text, String pattern, int offset) {…}
// Test your implementations by writing a program that finds all the occurrences
// of “the” in “the cat sat on the mat” using each of the three search algorithms.

import java.util.HashMap;
import java.util.Map;

public class W3Q4 {
		public static int bruteForceSearch(String T, String P, int offset) {
			int i = offset;
			while (i <= T.length() - P.length()) {
				int j =0;
				while (j < P.length() && T.charAt(i+j) == P.charAt(j)) {
					j++;
				}
				if (j == P.length()) {
					return i;
				}
				i++;
			}
			return -1;
		}
	
		public static int boyerMooreSearch(String T, String P, int offset) {
			if((offset > T.length()) || (P.length() > (T.length()-offset))) {
				return -1 ;
			}
			Map<Character,Integer> L = lastOccurrenceMap(P);

			int m=P.length();
			// Substract the offset from n
			int n=T.length() - offset;
			// Add the offset to i
			int i=(m-1) + offset;
			int j=m-1;
			int l;
			do {
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
				// subtract the offset from i 
			} while (! ((i-offset)>(n-1))) ;
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
		public static int kmpSearch(String T, String P, int offset) {
			int [] F = failureFunction(P) ;
			// int i=0;
			int i=offset;
			int j=0;
			int n=T.length() - offset;
			int m=P.length();
			while((i-offset)<n) {
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
			String T = "the cat sat on the mat" ;
			String P = "the" ;
				printSearchAlgorithm("bruteForceSearch",T,P,"Brute Force Search - Pattern ") ;
				printSearchAlgorithm("boyerMooreSearch",T,P,"Boyer Moore Search - Pattern ") ;
				printSearchAlgorithm("kmpSearch",T,P,"KMP Search - Pattern ") ;

		}	
		
		public static void printSearchAlgorithm(String typeSearch, String T, String P, String msg ) {
			int indexOfFind = 0 ;
			int counter = 0;
			while (indexOfFind != -1) {
				switch (typeSearch) {
				case "bruteForceSearch" :
					indexOfFind = bruteForceSearch(T,P,indexOfFind) ;
					break;
				case "boyerMooreSearch" :
					indexOfFind = boyerMooreSearch(T,P,indexOfFind) ;
					break;
				case "kmpSearch" :
					indexOfFind = kmpSearch(T,P,indexOfFind) ;
					break;
				} // switch
				// if the string has been found, start searching again at the next character
				if(indexOfFind != -1) {
					counter++;
					if(counter==1) {
						System.out.print("\n" + msg + "at Index: " + indexOfFind) ;
					} else {
						System.out.print(", " + indexOfFind);
					} 
					
					if (indexOfFind + 1 < T.length()) {
						indexOfFind++;
					} else {
						indexOfFind = -1 ;
					}
				} else {
					if(counter==0) {
						System.out.println(msg + "not found") ;
					}
				}
			}  // while 	

		} // method printSearchAlgorithm
} // class
