package z.mentee1;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    Semaphore fSema = new Semaphore(1);
    Semaphore sSema = new Semaphore(0);
    Semaphore tSema = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            fSema.acquire();
            printNumber.accept(0);
            sSema.acquire();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            sSema.acquire();
            printNumber.accept(i);
            tSema.acquire();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            tSema.acquire();
            printNumber.accept(i);
            fSema.acquire();
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