package com.college.Multithreading.currentThread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Current thread: " + t);

        // change the name of the thread
        t.setName("My Thread"); // also getName() method used to get the name of the thread
        System.out.println("After name change: " + t);

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000); // 1s
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
