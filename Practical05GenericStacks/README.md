Worksheet 5: Generic Stacks
In this worksheet, you are going to introduce generics into the general Stack
implementations covered in the course so far. Specifically, you will modify your
array-based and link-based steack implementations to implement a new genericised
Stack interface provided with this worksheet.
You should then test your code by modifying the main methods you wrote on the
previous worksheet to use the new genericised version of the stacks.
Main methods should be written in files of the form W5Qx.java where x is the
question number. For Q1 and Q2, please submit updated versions of ArrayStack.java
and LinkedStack.java.

1. Create a class called ArrayStack that implements the new generic Stack
interface using an array based approach.

2. Create a class called LinkedStack that implements the new generic Stack
interface using a linked-based approach.

3. Write a method called reverse() that uses a stack to reverse a string (HINT:
Look at question 3 from worksheet 3). This method should return the reversed
string. You can access the individual characters in a string by using the
charAt(i) method, and you can get the length of a string by using the length()
method. Test your answer by writing a main program that asks the user to
input a string and then print the input string out in reverse.
Example output:
Input a string: HAPPY
Reverse is: YPPAH

4. In the course notes, you will find a slide on parenthesis matching (Lecture 4).
Implement this algorithm. Test your answer on the following string:
SEQ(PAR(boil kettle, wash cup), add teabag, WAIT({kettle boiled}, add
water, add milk)