package com.college.Generics;

class Gen <T> {
    T ob; // declare an object of type T

    // Pass the constructor a reference to an object of type T
    Gen (T o) {
        ob = o;
    }

    // Return ob
    T getob() {
        return ob;
    }

    // Show type of T
    void showType () {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<Integer>(88);

        iOb.showType();
        System.out.println("Value: " + iOb.getob());
        System.out.println();

        Gen<String> strOb = new Gen<String>("Generics Test");

        strOb.showType();
        System.out.println("Value: " + strOb.getob());
    }
}
