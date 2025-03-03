package com.college.CollectionFrameworks.Classes;

import java.util.HashSet;

public class HashSet1 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();

        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");
        hs.add("E");
        hs.remove("D");

        System.out.println(hs);
    }
}
