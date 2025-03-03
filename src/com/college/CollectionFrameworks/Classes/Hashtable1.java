package com.college.CollectionFrameworks.Classes;

import java.util.Hashtable;

public class Hashtable1 {
    public static <HashTable> void main(String[] args) {
        Hashtable<Integer, String> map = new Hashtable<Integer, String>();
        map.put(100, "Amit");
        map.put(102, "Ravi");
        map.put(101, "Vijay");
        map.put(103, "Rahul");

        System.out.println("Before remove: " + map);

        // remove value for key 102
        map.remove(102);
        System.out.println("After remove: " + map);
    }
}
