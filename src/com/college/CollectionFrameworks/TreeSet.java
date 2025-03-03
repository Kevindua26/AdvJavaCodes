package com.college.CollectionFrameworks;

import java.util.*;

public class TreeSet {
    public static void main(String[] args) {
        // creating and adding elements
        java.util.TreeSet<String> al = new java.util.TreeSet<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");
        al.add("Ram");
        al.add("Sham");

        // traversing elements
        Iterator<String> itr = al.iterator();

        while(itr.hasNext()) {
            System.out.print(itr.next() + "\t");
        }
        System.out.println("\n");

        al.remove("Ravi");
        al.remove("Vijay");

        Iterator<String> itr1 = al.iterator();
        System.out.println("After removing: ");

        while(itr1.hasNext()){
            System.out.print(itr1.next() + "\t");
        }
    }
}
