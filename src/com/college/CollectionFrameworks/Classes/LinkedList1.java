package com.college.CollectionFrameworks.Classes;

import java.util.*;

public class LinkedList1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        list.add("Java");
        list.add("C++");
        list.add("Python");

        list.addFirst("JavaScript");
        list.addLast("C");

        System.out.println("Initial list: " + list);

        list.remove("C++");
        list.remove(2);
        list.removeFirst();
        list.removeLast();

        System.out.println("After Edit: " + list);
    }


}
