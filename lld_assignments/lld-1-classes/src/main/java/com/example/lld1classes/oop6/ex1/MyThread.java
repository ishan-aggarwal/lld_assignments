package com.example.lld1classes.oop6.ex1;

public class MyThread extends Thread {

    public void run() {
        System.out.println("Inside the run method when Thread class is extended");
    }

    public static void main(String[] args) {
        System.out.println("Inside main method");
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("Main method ended");
    }
}
