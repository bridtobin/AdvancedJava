package Practical09;

	public interface Queue<T> {
		// accessor methods
		public int size(); 
		public boolean isEmpty();
//		public T rear();
		public T front();

		// update methods
		public void enqueue (T element);
		public T dequeue();
	}
