//Brid Delap Practical 8. 
package Practical08;
// Create a class called ArrayVector that implements the Vector interface
// provided. Include two constructors: a default constructor (no parameters) that
// creates a vector with a fixed capacity of 50; and a second constructor that
// takes a capacity as a parameter so that you can set the capacity of the vector
// when you create it. Implement the size methods specified in the Vector
// interface (10% per method). For the remaining 10%, override the toString()
// method to provide a string based representation of the state of the vector (use
// the toString() method on the ArrayStack and ArrayQueue classes as
// inspiration). Try to make the output meet the following format:
// [3] : “A”, “P”, “E”, null, null, ...
// Where this represents a vector that contains 3 values A, P, and E, which were
// enqueued in that order.
// HINT: Implement this method before you implement the 4 main Vector
// methods (insertAtRank, removeAtRank, elementAtRank and replaceAtRank)
// and use it to check that each method implementation is working correctly.

public class ArrayVector<T> implements Vector<T> {
	   private T[] A ;  // vector
	   private int n ; // holds size

	   // Default constructor - set array length to 20
	   public ArrayVector() {
	         this(6) ;
	   }
	   // Constructor - set array length to value entered
	   public ArrayVector(int value) {
		   A = (T[]) new Object[value];
		   System.out.println(A.length + " Value is " + value);
			
	   }
	   public T elemAtRank(int r) {
		   if(r<0 || r > n-1) throw new RankOutOfBoundsException() ;
		   return A[r] ;
	   }
	   
	   public T replaceAtRank(int r, int e) {
		   if(r<0 || r > n-1) throw new RankOutOfBoundsException() ;
		   T temp = A[r];
		   A[r] = A [e] ;
		   return temp ;
		}
	   
	   public void insertAtRank(int r, T e ) {
		   if(n==A.length) {
			    
			    System.out.println(n + " is size " + A.length + " is length of  array" + r) ;
				T [] tempArray = (T[]) new Object[A.length * 2];
				// If array has reach max capacity create a new
				// array with double the capacity and copy the contents.
				// Then array becomes equal to the temporary array
				for(int i = 0; i < A.length; i++) {
					tempArray[i] = A[i] ;
				}
				A = tempArray ;
		        
		   }
		   if(r > n || r < 0) throw new RankOutOfBoundsException() ;
		   if(r < n ) {
		   	  for(int i=n;i>r;i--) {
     			   System.out.println("i = " + i) ;

		   		  A[i] = A[i-1] ;
		   	  }
	
		    }
		    A [r]=e;
		    n++ ;
	   }
	   
	   public T removeAtRank(int r) {
		   if(r<0 || r>n-1) throw new RankOutOfBoundsException() ;
		   T e = A[r] ;
		   for(int i=r;i<n-1;i++ ) {
			   A[i]=A[i+1] ;
		   }
		   A[n-1]=null;
		   n=n-1;
		   for(int iter=0;iter<A.length;iter++) {
			   System.out.print(A[iter]) ;
		   }
		   System.out.println();
		   System.out.println(e + " rank is " + r);
		   return e;
	   }
	   
	   public int size() {
		   return n;
	   }
	   
	   public boolean isEmpty() {
		   return n==0;
	   }
	   
	   public String toString() {
			String out = "[" + n + "] : " ;
			for (int i=0;i<A.length; i++) {
				out = out + A[i] + "," ;
			}
			return out;
		}
	   
	   // Test to add strings to queue and make sure they print out correctly
		public static void main(String[] args) {
			ArrayVector<Character> brid = new ArrayVector<Character>(5);
			brid.insertAtRank(0,'B');
			brid.insertAtRank(1, 'r');
			brid.insertAtRank(2, 'i');
			brid.insertAtRank(3, 'd');
			brid.insertAtRank(4,'D');
			brid.insertAtRank(2, 'e');
			System.out.println(brid);
			brid.removeAtRank(0);
			brid.removeAtRank(0);
			brid.removeAtRank(0);
			brid.removeAtRank(0);
			brid.removeAtRank(0);
			brid.removeAtRank(0);
			
			
			System.out.println(brid);
		}	
}