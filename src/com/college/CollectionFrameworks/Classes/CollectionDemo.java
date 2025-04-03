package com.college.CollectionFrameworks.Classes;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        // ArrayList Demonstration
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);
        arrayList.remove("Banana");
        arrayList.remove("Apple");
        System.out.println("Updated ArrayList: " + arrayList);

        // Vector Demonstration
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        vector.add(30);
        System.out.println("Vector: " + vector);
        vector.remove(1);
        vector.set(1, 40);
        System.out.println("Updated Vector: " + vector);

        // LinkedList Demonstration
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Cat");
        linkedList.add("Horse");
        System.out.println("LinkedList: " + linkedList);
        linkedList.remove("Cat");
        linkedList.set(1, "Elephant");
        System.out.println("Updated LinkedList: " + linkedList);
    }
}
