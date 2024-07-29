package z.mentee1.m2;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private int i;

    private Semaphore zeroSemaphore;
    private Semaphore oddSemaphore;
    private Semaphore evenSemaphore;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.i = 0;

        this.zeroSemaphore = new Semaphore(1);
        this.oddSemaphore = new Semaphore(0);
        this.evenSemaphore = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        this.zeroSemaphore.acquire();
        printNumber.accept(0);
        this.i++;
        if (this.i % 2 == 1) {
            this.oddSemaphore.release();
        } else {
            this.evenSemaphore.release();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        this.evenSemaphore.acquire();
        printNumber.accept(this.i);
        this.zeroSemaphore.release();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        this.oddSemaphore.acquire();
        printNumber.accept(this.i);
        this.zeroSemaphore.release();
    }

    public static void main(String[] args) {
        int n = 8;  // Change this value to test with different n
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

//        IntConsumer printNumber = System.out::print;
        IntConsumer printNumber = x -> System.out.print(x + " ");

        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        zeroThread.start();
        evenThread.start();
        oddThread.start();
    }
}