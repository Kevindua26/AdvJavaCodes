package com.college.CollectionFrameworks;

// importing required classes
import java.util.LinkedHashSet;

public class GFG2 {
    // main driver method
    public static void main(String[] args) {
        // creating an empty LinkedHashSet of string type
        LinkedHashSet<String> linkedset = new LinkedHashSet<String>();

        // adding element to LinkedHashSet using add() method
        linkedset.add("A");
        linkedset.add("B");
        linkedset.add("C");
        linkedset.add("D");

        // Note: This will not add new element as a already exists
        linkedset.add("A");
        linkedset.add("E");

        // getting size of LinkedHashSet using size() method
        System.out.println("Size of LinedHashSet= " + linkedset.size());
        System.out.println("Original LinedHashSet= " + linkedset);

        // remove existing entry from above set using remove() method
        System.out.println("Removing D from LinedHashSet= " + linkedset.remove("D"));

        // remove existing entry from above set that doesn't exist in set
        System.out.println("Trying to remove Z which is not present= " + linkedset.remove("Z"));

        // checking for element whether it is present inside set or not using contains() methods
        System.out.println("Checking of A is present= " + linkedset.contains("A"));

        // now lastly printing the updated LinkedHashMap
        System.out.println("Updated LinkedHashSet= " + linkedset);
    }
}
