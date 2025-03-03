package com.college.Multithreading;

public class GetThreadName {
    public static void main(String[] args) {
        // Creating an object of the Thread class using the constructor Thread(String name)
        Thread t = new Thread("My First thread");

        // the start() method moves the thread top the active state;
        t.start();

        // getting the thread name by invoking the getName() method
        String str = t.getName();
        System.out.println(str);
    }
}
