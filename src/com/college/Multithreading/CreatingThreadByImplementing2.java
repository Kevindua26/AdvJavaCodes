package com.college.Multithreading;

public class CreatingThreadByImplementing2 implements Runnable {
    public static void main(String[] args) {
        // creating an object of the class StartThreadByImplementing2
        Runnable r1 = new CreatingThreadByImplementing2();
        Thread th1 = new Thread(r1, "My new Thread");

        // the start() method moves the thread to the active state
        th1.start();

        // getting the thread name by invoking the getName() method
        String str = th1.getName();
        System.out.println(str);
    }

    @Override
    public void run() {
        System.out.println("Now the thread is running-");
    }
}
