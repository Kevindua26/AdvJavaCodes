package com.college.CollectionFrameworks.Classes;

public class ArrayList {
    public static void main(String[] args) {
        java.util.ArrayList<Integer> arr1 = new java.util.ArrayList<Integer>();
        java.util.ArrayList<String> list = new java.util.ArrayList<String>();

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
