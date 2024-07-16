package example_threads.more;

import example_threads.water.H2O;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        example_threads.water.H2O h2o = new H2O();

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        // Create a thread pool to simulate hydrogen and oxygen atoms arriving
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Example input: "OOHHHH" (2 oxygen and 4 hydrogen atoms)
        String input = "OOHHHH";

        for (char c : input.toCharArray()) {
            if (c == 'H') {
                executor.execute(() -> {
                    try {
                        h2o.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } else if (c == 'O') {
                executor.execute(() -> {
                    try {
                        h2o.oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        // Shutdown the executor service
        executor.shutdown();
    }
}
