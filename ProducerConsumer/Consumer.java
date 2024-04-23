package ProducerConsumer;

import java.util.concurrent.TimeUnit;

public class Consumer extends Thread {
    private DataQueue queue;
    private static int count;
    private final String prefix = "CONSUMER_";
    private final String consumerId;

    public Consumer(DataQueue queue) {
        this.queue = queue;
        this.consumerId = prefix + ++count;
    }

    @Override
    public void run() {
        System.out.println(consumerId + "- STARTED");
        while(true) {
            try {
                int val = queue.remove();
                System.out.println(consumerId + "- REMOVED " + val);
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (Exception e) {
                System.out.println(consumerId + "- INTERRUPTED");
                break;
            }
        }

        System.out.println(consumerId + "- COMPLETED");
    }
}