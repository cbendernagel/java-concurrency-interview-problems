package ProducerConsumer;

import java.util.LinkedList;

public class DataQueue {
    private final LinkedList<Integer> queue;
    private final int capacity;

    public DataQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<Integer>();
    }

    public synchronized void add(int data) throws InterruptedException {
        while(queue.size() >= capacity) {
            wait();
        }
        queue.add(data);
        notifyAll();
    }

    public synchronized int remove() throws InterruptedException {
        while(queue.isEmpty()) {
            wait();
        }
        int data = (int) queue.poll();
        notifyAll();
        return data;
    }
}
