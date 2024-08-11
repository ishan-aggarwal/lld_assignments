package com.example.lld1classes.oop8.executor_and_callables;

import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {

    int a;
    int b;

    public MyCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        return a + b;
    }
}


public class ExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable myCallable = new MyCallable(1, 2);

//        ExecutorService ex = Executors.newSingleThreadExecutor(); // only 1 thread
//        ExecutorService ex = Executors.newFixedThreadPool(5); // it will tell how many threads to create
        // so it will create a pool of n threads
//        ExecutorService ex = Executors.newScheduledThreadPool(5);
        // 3rd and 2nd are same... both create a pool of n threads given in the input...
        // in 3rd one there is extra functionality you can tell when to start... it is scheduled thread pool
        ExecutorService ex = Executors.newCachedThreadPool(); // synchonous queue
        // 4th one is cached thread pool... which is having unlimited number of threads..
        // but it gives one thread at any point of time.. and is used to do small small tasks

        Future<Integer> futureResult = ex.submit(myCallable);

//        ex.execute(myCallable);

        System.out.println(futureResult.get());

        ex.shutdownNow();
    }
}
