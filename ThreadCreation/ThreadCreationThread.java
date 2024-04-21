package ThreadCreation;

import java.util.concurrent.TimeUnit;

public class ThreadCreationThread extends Thread {

    public static int count;
    private final String idPrefix = "Runnable-";
    private String threadId;

    public ThreadCreationThread() {
        this.threadId = idPrefix + ++count;
    }

    @Override
    public void run() {
        System.out.println("[" + threadId + "] STARTED");
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println("[" + threadId + "] counter=" + i);
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("[" + threadId + "] COMPLETED");
    }
}
