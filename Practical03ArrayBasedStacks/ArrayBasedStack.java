package Practical03;


public class ArrayBasedStack {
		Object [] s = new Object [1000] ;
		int t = -1;

		
		public void push(Object o) {
			t++ ;
			s[t]=o ;
		}
		
		public int size() {
			return t + 1 ;
		}
		
		boolean isEmpty() {
			return t==-1; 
		}
		
		public Object pop() {
			Object e = new Object() ;
			if(t!=-1){
				e = s[t] ;
				s[t] = null ;
				t --;
			}
			return e ;
		}
		
		public Object top() {
			if(t!=-1) {
				return s[t] ;
			} 
			else {
				return null;
			}
				
		}
		
		
	}



