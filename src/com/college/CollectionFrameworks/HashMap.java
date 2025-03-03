package com.college.CollectionFrameworks;

public class HashMap {
    public static void main(String[] args) {
        java.util.HashMap<Integer, String> map = new java.util.HashMap<Integer, String>();
        map.put(100,"Amit");
        map.put(101,"Vijay");
        map.put(102,"Rahul");
        map.put(103,"Gaurav");
        System.out.println("Initial list of elements: " + map);

        // key based removal
        map.remove(100);
        System.out.println("Update list of elements: " + map);

        //value based removal
        map.remove(101);
        System.out.println("Update list of elements: " + map);

        //key value pair based removal
        map.remove (102, "Rahul");
        System.out.println("Update list of elements: " + map);
    }
}
