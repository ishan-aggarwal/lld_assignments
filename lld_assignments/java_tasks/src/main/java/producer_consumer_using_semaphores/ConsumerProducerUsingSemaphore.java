package producer_consumer_using_semaphores;

import java.util.concurrent.Semaphore;

public class ConsumerProducerUsingSemaphore {

    public static void main(String[] args) {

        Semaphore semaphoreProducer = new Semaphore(1);
        Semaphore semaphoreConsumer = new Semaphore(0);
        System.out.println("semaphoreProducer permit=1 | semaphoreConsumer permit=0");

        Producer producer = new Producer(semaphoreProducer, semaphoreConsumer);
        Consumer consumer = new Consumer(semaphoreConsumer, semaphoreProducer);

        Thread producerThread = new Thread(producer, "ProducerThread-1");
        Thread producerThread1 = new Thread(producer, "ProducerThread-2");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");

        producerThread.start();
        producerThread1.start();
        consumerThread.start();

    }
}


/**
 * Producer Class.
 */
class Producer implements Runnable {

    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;


    public Producer(Semaphore semaphoreProducer, Semaphore semaphoreConsumer) {
        this.semaphoreProducer = semaphoreProducer;
        this.semaphoreConsumer = semaphoreConsumer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                semaphoreProducer.acquire(); // acquire decrease count by 1.. producer ka permit will be 0 now.
                System.out.println(Thread.currentThread().getName() + " Produced : " + i);
                semaphoreConsumer.release(); // release increase the count by 1... consumer count will now be 1

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Consumer Class.
 */
class Consumer implements Runnable {

    Semaphore semaphoreConsumer;
    Semaphore semaphoreProducer;

    public Consumer(Semaphore semaphoreConsumer, Semaphore semaphoreProducer) {
        this.semaphoreConsumer = semaphoreConsumer;
        this.semaphoreProducer = semaphoreProducer;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            try {
                semaphoreConsumer.acquire();
                System.out.println(Thread.currentThread().getName() + " Consumed : " + i);
                semaphoreProducer.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
