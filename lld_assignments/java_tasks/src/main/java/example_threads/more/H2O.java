package example_threads.more;

import java.util.concurrent.Semaphore;

public class H2O {

    public int h_count = 0;
    public int o_count = 0;


    Semaphore h_sem = new Semaphore(1);
    Semaphore o_sem = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        h_sem.acquire();
        if (this.h_count > 1 && this.o_count > 0) {
            this.h_count -= 2;
            this.o_count -= 1;
            releaseHydrogen.run();
        } else {
            this.h_count += 1;
        }
        o_sem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        o_sem.acquire();
        if (this.h_count > 1 && this.o_count > 0) {
            this.h_count -= 2;
            this.o_count -= 1;
            releaseOxygen.run();
        } else {
            this.o_count += 1;
        }
        h_sem.release();
    }
}