package com.college.Multithreading;

public class SetThreadName {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t);

        t.setName("Main Thread");
        System.out.println(t);
    }
}
