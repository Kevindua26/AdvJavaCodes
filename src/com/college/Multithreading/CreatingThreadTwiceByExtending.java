package com.college.Multithreading;

public class CreatingThreadTwiceByExtending extends Thread {
    public static void main(String[] args) {
        CreatingThreadTwiceByExtending t1 = new CreatingThreadTwiceByExtending();
        t1.start();
        t1.start(); // IllegalThreadStateException
    }

    @Override
    public void run() {
        System.out.println("Running...");
    }
}
