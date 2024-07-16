package example_threads;

import java.util.concurrent.Semaphore;

public class H2OVersion2 {

    private final Semaphore hydrogenSemaphore = new Semaphore(2);
    private final Semaphore oxygenSemaphore = new Semaphore(0);
    private int hydrogenCount = 0; // AtomicInteger
    private final Object object = new Object();

    public H2OVersion2() {}

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire(); // Acquire one permit for hydrogen // 0 -> 2
        synchronized (object) {
            releaseHydrogen.run(); // HH
            hydrogenCount++; // 2
            if (hydrogenCount == 2) {
                oxygenSemaphore.release(); // Release one oxygen permit when two hydrogen atoms are ready // 1
            }
        }
    }

    // HHO

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire(); // Acquire one permit for oxygen // 0
        releaseOxygen.run(); // O
        synchronized (object) {
            hydrogenCount = 0; // Reset hydrogen count after forming a water molecule
            hydrogenSemaphore.release(2); // Release two hydrogen permits for the next water molecule
        }
    }

    public static void main(String[] args) {
        H2OVersion2 h2o = new H2OVersion2();

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        // Example input: "OOHHHH" (2 oxygen and 4 hydrogen atoms)
        String input = "OOHHHH";

        for (char c : input.toCharArray()) {
            if (c == 'H') {
                new Thread(() -> {
                    try {
                        h2o.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (c == 'O') {
                new Thread(() -> {
                    try {
                        h2o.oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
