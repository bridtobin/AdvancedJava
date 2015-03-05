package Practical11;

public class PatternMatching {
	public static int bruteForceSearch(String T, String P) {
		int i = 0;
		while (i <= T.length() - P.length()) {
			int j =0;
			while (j < P.length() && T.charAt(i+j) == P.charAt(j)) {
				j++;
			}
			if (j == P.length()) return i;
			i++;
		}
		return -1;
	}
	
	public static void main (String[] args) {
		System.out.println(bruteForceSearch("the theme was their idea","the")) ;
		System.out.println(bruteForceSearch("the theme was their idea","there")) ;
		System.out.println(bruteForceSearch("the theme was their idea","idea")) ;
	}
	
}