//Brid Delap Practical 8. 

package Practical08;

public interface Vector <T>{
		// accessor methods
		public int size(); 
		public boolean isEmpty();
		public T elemAtRank(int r) ;
		
		// update methods
		public void insertAtRank (int r, T e);
		public T replaceAtRank(int r, int e) ;
		public T removeAtRank(int r) ;
				
				
		
}



