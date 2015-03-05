Worksheet 10: List-Based Maps
The goal of this worksheet is to complete the implementation of the ListMap class
covered in the lectures.
A slightly modified version of the class is available on moodle. The main differences
are:
 The test code I used to show how the iterators work has been removed (to
avoid confusion).
 The key and value iterators are implemented as anonymous classes.
 I have added a toString() method to both the ListMap and the ListMayEntry
classes to allow you to print out the state of the map.
You task for this worksheet is to implement the 5 missing methods:
 size() 15%
 isEmpty() 15%
 get(K k) 15%
 put(K k, V v) 15%
 remove(K k) 15%
Pseudo Code for most of these methods can be found in the lecture notes.
To implement the last 3 methods, as discussed in the lecture, you should first
implement a variation of the linear search algorithm as a method with signature:
 find(K k) 15%
For the remaining 10% of the worksheet, you must implement a main method that
performs the following operations on the map:
1. put(“ie”, “Ireland”)
2. put(“uk”, “United Kingdom”)
3. put(“us”, “USA”)
4. put(“de”, “Germany”)
5. put(“fr”, “France”)
6. remove(“uk”)
7. put(“us”, “United States of America”)
8. put(“es”, “Spain”)
9. put(“uk”, “United Kingdom”)
10. get(“us”) - print out the value returned by this operation
NOTE: Even if some of your core methods do not work, you should attempt the main
method.
Everything for this worksheet should be written in the existing ListMap.java file
(including the main method). Please submit only this file.