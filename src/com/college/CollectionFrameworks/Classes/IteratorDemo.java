package com.college.CollectionFrameworks.Classes;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        // ArrayList Demonstration
        ArrayList<String> al = new ArrayList<>();
        al.add("Apple");
        al.add("Banana");
        al.add("Cherry");
        System.out.println("ArrayList: " + al);
        al.remove("Banana");
        al.set(1, "Mango");
        System.out.println("Updated ArrayList: " + al);

        // Using Iterator for ArrayList
        Iterator<String> alI = al.iterator();
        System.out.print("ArrayList elements using Iterator: ");
        while (alI.hasNext()) {
            System.out.print(alI.next() + " ");
        }
        System.out.println();
    }
}
