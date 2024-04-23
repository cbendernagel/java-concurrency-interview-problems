package ProducerConsumer;

import java.util.concurrent.TimeUnit;

public class Producer extends Thread {
    private DataQueue queue;
    private static int count;
    private final String prefix = "PRODUCER_";
    private String producerId;

    public Producer(DataQueue queue) {
        this.queue = queue;
        this.producerId = prefix + ++count;
    }

    @Override
    public void run() {
        System.out.println(this.producerId + "- STARTED");
        for(int i = 0; i < 20; i++) {
            try {
                int val = (int) (Math.random() * 100);
                queue.add(val);
                System.out.println(producerId + "- ADDED " + val);
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(producerId + "- INTERRUPTED");
            }
        }
        System.out.println(this.producerId + "- COMPLETED");
    }
}