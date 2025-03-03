package com.college.CollectionFrameworks.Classes;

import java.util.*;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<String> list = new ArrayList<String>();

        // adding elements to the ArrayList
        list.add("Java");
        list.add("C++");
        list.add("Python");

        // here rwe are mentioning the index
        list.add(2, "JavaScript");

        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);

        System.out.println("Initial list: " + list);
        System.out.println("Initial Array: " + arr1);

        arr1.remove(4);
        arr1.remove(3);

        System.out.println("Array After Edit: " + arr1);

        // displaying the elements
        System.out.println(list);
    }
}
