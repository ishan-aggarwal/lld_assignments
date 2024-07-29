package example_threads.mentee1;

import example_threads.H2OVersion2;

import java.util.concurrent.Semaphore;

public class H2O {
    private static final Semaphore h2 = new Semaphore(2);
    private static final Semaphore ox = new Semaphore(0);
    private int hydrogenCount = 0;
    private static final Object object = new Object();

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h2.acquire();
        releaseHydrogen.run();
        synchronized (object) {
            hydrogenCount++;
            if (hydrogenCount == 2) {
                ox.release();
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        ox.acquire();
        releaseOxygen.run();
        synchronized (object) {
            hydrogenCount = 0;
            h2.release(2);
        }
    }

    public static void main(String[] args) {
        H2OVersion2 h2o = new H2OVersion2();

        // lamda operators
        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        // Example input: "OOHHHH" (2 oxygen and 4 hydrogen atoms)
        String input = "HOOHHH";
        //HH0HH0

        for (char c : input.toCharArray()) {
            if (c == 'H') {
                new Thread(() -> {
                    try {
                        h2o.hydrogen(releaseHydrogen); // 4 times
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (c == 'O') {
                new Thread(() -> {
                    try {
                        h2o.oxygen(releaseOxygen); // 2 times
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}