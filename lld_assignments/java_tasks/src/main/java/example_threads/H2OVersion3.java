package example_threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class H2OVersion3 {

    private final Semaphore hydrogenSemaphore = new Semaphore(2);
    private final Semaphore oxygenSemaphore = new Semaphore(0);
    private AtomicInteger hydrogenCount = new AtomicInteger(0); // AtomicInteger

    public H2OVersion3() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire(); // Acquire one permit for hydrogen // 0 -> 2
        hydrogenCount.incrementAndGet();
        releaseHydrogen.run(); // HH
        if (hydrogenCount.get() == 2) {
            oxygenSemaphore.release(); // Release one oxygen permit when two hydrogen atoms are ready // 1
        }
    }

    // HHO

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire(); // Acquire one permit for oxygen // 0

        releaseOxygen.run(); // O
        hydrogenCount.set(0); // Reset hydrogen count after forming a water molecule
        hydrogenSemaphore.release(2); // Release two hydrogen permits for the next water molecule
    }

    public static void main(String[] args) {
        H2OVersion3 h2o = new H2OVersion3();

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
