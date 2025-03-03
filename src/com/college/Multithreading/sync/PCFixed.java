package com.college.Multithreading.sync;

class Qq {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class ProducerP implements Runnable {
    Qq q;
    Thread t;

    ProducerP(Qq q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }

    public void run() {
        int i = 0;
        while(true) {
            q.put(i++);
        }
    }
}

class ConsumerC implements Runnable {
    Qq q;
    Thread t;

    ConsumerC(Qq q) {
        this .q = q;
        t = new Thread(this, "Consumer");;
    }

    public void run() {
        while(true) {
            q.get();
        }
    }
}

public class PCFixed {
    public static void main(String[] args) {
        Qq q = new Qq();
        ProducerP p  = new ProducerP(q);
        ConsumerC c = new ConsumerC(q);

        p.t.start();
        c.t.start();

        System.out.println("Press Ctrl+C to stop");
    }
}
