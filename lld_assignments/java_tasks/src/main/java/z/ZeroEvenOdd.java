package z;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    Semaphore sema0;
    Semaphore sema1;
    Semaphore sema2;
    int even = 2;
    int odd = 1;
    int count = 1;

    public ZeroEvenOdd(int n) {
        this.n = n;
        sema0 = new Semaphore(1);
        sema1 = new Semaphore(0);
        sema2 = new Semaphore(0);

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        sema0.acquire();
        printNumber.accept(0);
        if (count % 2 == 0)
            sema2.release(1);
        else
            sema1.release(1);
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        count++;
        sema2.acquire();
        printNumber.accept(even);
        even += 2;
        sema0.release(1);
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        count++;
        sema1.acquire();
        printNumber.accept(odd);
        odd += 2;
        sema0.release(1);
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