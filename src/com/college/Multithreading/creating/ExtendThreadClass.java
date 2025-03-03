package com.college.Multithreading.creating;

// creating new thread by extending Thread class
class NewThread extends Thread {
    // creating new thread
    NewThread() {
        super("Demo Thread");
        System.out.println("Child thread: " + this);
    }

    // entry point of the thread
    public void run() {
        System.out.println("Inside run method");
    }
}

public class ExtendThreadClass {
    public static void main(String[] args) {
        NewThread nt = new NewThread();

        nt.start(); // start the thread

        System.out.println("Main thread: " + Thread.currentThread());
    }
}
