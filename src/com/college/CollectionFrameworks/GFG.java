package com.college.CollectionFrameworks;

import java.util.*;

public class GFG {
    // Driver code
    public static void main(String[] args) {
        // creating object of the class linked list
        LinkedList<String> ll = new LinkedList<String>();

        // Adding elements to the linked list
        ll.add("A");
        ll.add("B");
        ll.addLast("C");
        ll.addFirst("D");
        ll.add(2, "E");

        System.out.println("Initial LinkedList: " + ll);

        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        System.out.println("After Edit: " + ll);


        // creating object of the class Vector
        Vector v1 = new Vector();

        // Adding custom elements using add() method
        v1.add(1);
        v1.add(2);
        v1.add("hello");
        v1.add("uwu");
        v1.add(3);

        // Displaying the Vector
        System.out.println("Vector v1 is " + v1);

        Vector<Integer> v2 = new Vector<Integer>();
        v2.add(1);
        v2.add(2);
        v2.add(3);

        System.out.println("Vector v2 is " + v2);
    }
}
