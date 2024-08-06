package semaphore_example;

import java.util.concurrent.Semaphore;

public class TestClass {

    private Semaphore first;
    private Semaphore second;
    private Semaphore third;

    TestClass() {
        first = new Semaphore(1);
        second = new Semaphore(0);
        third = new Semaphore(0);
    }

    public void printFirst() throws InterruptedException {
        first.acquire(); // decrease the value by 1 (0) -> T1 was able to start...
        System.out.println("first");
        second.release(); // increase the value by 1 -> (1)
    }

    public void printSecond() throws InterruptedException {
        second.acquire(); // decrease the value by 1 -> (0) -> T2 got stuck here because the permit value was 0/
        System.out.println("second");
        third.release(); // increase the value by 1 -> (0 -> 1)
    }

    public void printThird() throws InterruptedException {
        third.acquire(); // decrease the value by 1 -> (1 -> 0) - T3 got stuck here because there was no permit.
        System.out.println("third");
        first.release(); // increase the value by 1 -> (0 -> 1)
    }

    public static void main(String[] args) {

        TestClass obj = new TestClass();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printFirst();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printSecond();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.printThird();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t3.start();

        t2.start();

        t1.start();
        // T1, T2, T3
        // T1
        // T2
        // T3
    }
}
