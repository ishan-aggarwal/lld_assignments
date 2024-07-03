package z;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd1 {
    private int n;
    Semaphore sema0;
    Semaphore sema1;
    Semaphore sema2;
    int count = 1;

    int odd = 1;
    int even = 2;

    public ZeroEvenOdd1(int n) {
        this.n = n;
        sema0 = new Semaphore(1);
        sema1 = new Semaphore(0);
        sema2 = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            sema0.acquire();
            printNumber.accept(0);
            if (count % 2 == 0) {
                sema2.release();
            } else {
                sema1.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            sema2.acquire();
            printNumber.accept(i);
            count++;
            sema0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            sema1.acquire();
            printNumber.accept(i);
            count++;
            sema0.release();
        }
    }

    public static void main(String[] args) {
        int n = 8;  // Change this value to test with different n
        ZeroEvenOdd1 ZeroEvenOdd1 = new ZeroEvenOdd1(n);

        IntConsumer printNumber = x -> System.out.print(x + " ");

        Thread zeroThread = new Thread(() -> {
            try {
                ZeroEvenOdd1.zero(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                ZeroEvenOdd1.even(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                ZeroEvenOdd1.odd(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        zeroThread.start();
        evenThread.start();
        oddThread.start();
    }
}
