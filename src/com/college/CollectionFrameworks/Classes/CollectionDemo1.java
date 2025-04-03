package com.college.CollectionFrameworks.Classes;

import java.util.*;

public class CollectionDemo1 {
    public static void main(String[] args) {
        // HashSet Demonstration
        HashSet<String> hs = new HashSet<>();
        hs.add("Apple");
        hs.add("Banana");
        hs.add("Cherry");
        System.out.println("HashSet: " + hs);
        hs.remove("Banana");
        hs.remove("Apple");
        System.out.println("Updated HashSet: " + hs);

        // LinkedHashSet Demonstration
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Dog");
        lhs.add("Cat");
        lhs.add("Horse");
        System.out.println("LinkedHashSet: " + lhs);
        lhs.remove("Cat");
        System.out.println("Updated LinkedHashSet: " + lhs);

        // TreeSet Demonstration
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(5);
        ts.add(1);
        ts.add(10);
        System.out.println("TreeSet: " + ts);
        ts.remove(1);
        System.out.println("Updated TreeSet: " + ts);
    }
}
