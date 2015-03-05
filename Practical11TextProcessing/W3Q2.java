//Worksheet 11. Q2 Brid Delap. 

// create a new static method with the signature given below and implement the
// Boyer-Moore Search Algorithm given in the notes (you may need to create
// additional methods, but these should be declared private because they are part
// of the implementation of the Boyer-Moore Search Algorithm.
// public static int boyerMooreearch(String text, String pattern) {…}
// Again, test your answer by creating a class W3Q2.java that contains a main
// method that searches the text “the theme was their idea” for the following
// patterns:
// the, there, idea
// HINT: Java provides a generic implementation of HashMaps
// (java.util.HashMap) and a Map interface (java.util.Map). Please use these for
// the implementation of the last occurrence function.

package Practical11;
import java.util.HashMap;
import java.util.Map;
public class W3Q2 {
	
	public static int boyerMooreSearch(String T, String P) {
		if(P.length()> T.length()) {
			return -1;
		}
		Map<Character,Integer> L = lastOccurrenceMap(P);

		int m=P.length();
		int n=T.length();
		int i=m-1;
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
	
	public static void main (String[] args) {
		String T = "the theme was their idea" ;
		System.out.println(boyerMooreSearch(T,"the")) ;
		System.out.println(boyerMooreSearch(T,"there")) ;
		System.out.println(boyerMooreSearch(T,"idea")) ;

	}
}


