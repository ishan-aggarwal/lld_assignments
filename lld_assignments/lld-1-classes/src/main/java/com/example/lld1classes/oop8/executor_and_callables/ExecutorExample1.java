package com.example.lld1classes.oop8.executor_and_callables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

class MyCallable1 implements Callable<List<Integer>> {

    private int n;

    public MyCallable1(int n) {
        this.n = n;
    }

    @Override
    public List<Integer> call() throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }
}

public class ExecutorExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        MyCallable1 myCallable1 = new MyCallable1(n);
        ExecutorService ex = Executors.newSingleThreadExecutor();

        Future<List<Integer>> futureTask = ex.submit(myCallable1);
        System.out.println(futureTask.get());

        ex.shutdownNow();

        Runnable r = () -> System.out.println("Hello World");
        Thread t = new Thread(r);

//        Thread t1 = new Thread(myCallable1);

        t.start();
    }
}

//class MyRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println("Hello World");
//    }
//}
