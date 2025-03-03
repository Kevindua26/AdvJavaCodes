package com.college.Multithreading.creating;

// creating new thread by implementing Runnable interface
class NewThread01 implements Runnable {
    Thread t;

    // creating new thread
    NewThread01() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
    }

    public void run() {
        System.out.println("Inside run method");
    }
}

public class ImplementingRunnableInterface {
    public static void main(String[] args) {
        NewThread01 nt = new NewThread01();

        nt.t.start(); // start the thread

        System.out.println("Main thread: " + Thread.currentThread());
    }
}
