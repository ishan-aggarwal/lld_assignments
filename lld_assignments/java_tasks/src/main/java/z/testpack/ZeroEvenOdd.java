package z.testpack;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    Semaphore evenSema = new Semaphore(0);
    Semaphore oddSema = new Semaphore(0);
    Semaphore zeroSema = new Semaphore(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {

            zeroSema.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                oddSema.release();
            } else {
                evenSema.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSema.acquire();
            printNumber.accept(i);
            zeroSema.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSema.acquire();
            printNumber.accept(i);
            zeroSema.release();
        }
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