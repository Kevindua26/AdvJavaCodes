package com.college.Multithreading;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CreatingThreadByExtending extends Thread {
    public static void main(String[] args) {
        CreatingThreadByExtending thread = new CreatingThreadByExtending();
//        System.out.println(thread);
        thread.start();
//        System.out.println("Code inside run method " + thread);
    }
    public void run() {
        System.out.println("Code inside run method");
    }
}