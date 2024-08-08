package com.example.lld1classes.oop6.ex1;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Inside the run method when we implemented Runnable");
    }


    public static void main(String[] args) {
        System.out.println("Main program started");
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        t1.start();
        System.out.println("Main program ended");
    }

}
