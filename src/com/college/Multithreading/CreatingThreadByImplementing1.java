package com.college.Multithreading;

public class CreatingThreadByImplementing1 implements Runnable {
    public static void main(String[] args) {
        CreatingThreadByImplementing1 obj = new CreatingThreadByImplementing1();
        Thread thread = new Thread(obj); // obj is the target object
        thread.start();
        System.out.println("This code is outside of the run()");
    }

    @Override
    public void run() {
        System.out.println("This code is running in a run()");
    }
}
