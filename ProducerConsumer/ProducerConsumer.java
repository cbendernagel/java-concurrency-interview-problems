package ProducerConsumer;

import java.util.concurrent.TimeUnit;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        String threadId = Thread.currentThread().getName();
        System.out.println(threadId + ": STARTING");
        DataQueue queue = new DataQueue(5);
        Producer prod = new Producer(queue);
        Consumer consume = new Consumer(queue);

        prod.start();
        consume.start();

        while(prod.isAlive()) {
            System.out.println(threadId + "- waiting for producer to complete");
            TimeUnit.MILLISECONDS.sleep(5000);
        }

        consume.interrupt();
        System.out.println(threadId + ": COMPLETED");
    }

}