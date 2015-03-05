package Practical03;

public class StackMainLinkedNode {
	   public static void main( String[] args ) {
	      LinkedIntegerStack stack = new LinkedIntegerStack();
	      
	      stack.push( 17 );
	      System.out.println( stack );

	      stack.push( 11 );
	      System.out.println( stack );

	      stack.push( 12 );
	      System.out.println( stack );

	      stack.push( 23 );
	      System.out.println( stack );

	      stack.push( 26 );
	      System.out.println( stack );

	      stack.push( 51 );
	      System.out.println( stack );

	      while( stack.size() > 0 ) {
	         System.out.println( stack.pop() );
	         System.out.println( stack );
	      }
	      
	   }
	}
