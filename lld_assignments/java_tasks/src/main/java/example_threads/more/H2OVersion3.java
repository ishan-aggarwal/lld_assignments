package example_threads.more;

import java.util.concurrent.Semaphore;

public class H2OVersion3 {

    private final Semaphore hydrogenSemaphore = new Semaphore(2);
    private final Semaphore oxygenSemaphore = new Semaphore(0);

    public H2OVersion3() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire(); // Acquire one permit for hydrogen
        hydrogenSemaphore.acquire(); // Acquire one permit for hydrogen

        releaseHydrogen.run();
        releaseHydrogen.run();

        oxygenSemaphore.release(); // Release one oxygen permit when two hydrogen atoms are ready
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire(); // Acquire one permit for oxygen
        releaseOxygen.run();
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
