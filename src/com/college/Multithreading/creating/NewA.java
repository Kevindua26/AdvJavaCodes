package com.college.Multithreading.creating;

public class NewA implements Runnable {
    Thread t;

    public static void main(String[] args) {
        NewA a = new NewA();
        a.t = new Thread (a,"Hello new thread");
        a.t.start();
    }
    public void run() {
        System.out.println("Inside run");
    }
}
