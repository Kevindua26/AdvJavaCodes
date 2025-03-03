package com.college.Multithreading.join;

class NewThread implements Runnable {
    String name;
    Thread t;

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
    }

    public void run() {
        try {
            for(int i = 1; i <= 10; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
        System.out.println("Inside run method");
    }
}

public class JoinByImplementingRunnable {
    public static void main(String[] args) {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("Two");
        NewThread nt3 = new NewThread("Three");

        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        System.out.println("Thread One is alive: " + nt1.t.isAlive());
        System.out.println("Thread Two is alive: " + nt2.t.isAlive());
        System.out.println("Thread Three is alive: " + nt3.t.isAlive());

        try {
            System.out.println("Waiting for thread to finish");
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
            System.out.println("All threads are dead");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Thread One is alive: " + nt1.t.isAlive());
        System.out.println("Thread Two is alive: " + nt2.t.isAlive());
        System.out.println("Thread Three is alive: " + nt3.t.isAlive());

        System.out.println("Main thread: " + Thread.currentThread());
    }
}
