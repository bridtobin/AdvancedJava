Worksheet 9: Lists
In this worksheet you will implement a link-based version of the List interface. For
this implementation, you should use the pseudo code provided in the lecture.
Do all the questions below (Q1 is worth 70%, Q2 is worth 30%). Submit 2 files:
LinkedList.java and LinkedListQueue.java (which contains the answer to Q3).

1. Download the class called LinkedList that implements the List interface
provided. Implement the 5 missing methods (10% per method). For the
remaining 10%, override the toString() method to provide a string based
representation of the state of the vector (use the toString() method on the
LinkedStack and LinkedQueue classes as inspiration). Try to make the
output meet the following format:
[3] : “A”, “P”, “E”
Where this represents a list that contains 3 values A, P, and E, which were
inserted in that order.
HINT: Implement this method before you implement the 5 missing List
methods and use it to check that each method implementation is working
correctly.

2. Develop an implementation of the Queue interface called LinkedListQueue
that uses your List implementation (20%) include a main method that tests
your implementation by performing the following operations:
Enqueue(10), Enqueue(5), Dequeue(), Enqueue(15), Enqueue(3), Dequeue(),
Enqueue(7), Dequeue(), Enqueue(20).
Print out the state of the queue after each operation.
Add a loop at the end that clears the queue and calculates the total value of the
numbers were left in the queue at the end of the above sequence of operations. 