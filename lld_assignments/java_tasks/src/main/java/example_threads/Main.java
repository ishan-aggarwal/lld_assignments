package example_threads;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            System.out.print("foo");
            barSemaphore.release();
        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            System.out.print("bar");
            fooSemaphore.release();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 2; // You can change this value to test different cases
        FooBar fooBar = new FooBar(n);

        Thread threadA = new Thread(() -> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}
