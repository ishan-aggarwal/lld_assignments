package example_threads.water;

import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;

public class H2O {

    private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;
    private CyclicBarrier barrier;

    public H2O() {
        hydrogenSemaphore = new Semaphore(2);
        oxygenSemaphore = new Semaphore(1);
        barrier = new CyclicBarrier(3, () -> {
            hydrogenSemaphore.release(2);
            oxygenSemaphore.release();
        });
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
