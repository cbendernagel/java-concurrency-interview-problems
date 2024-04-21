package Synchronization;

import java.util.concurrent.TimeUnit;

public class Synchronization {
    

    public static void main(String[] args) throws InterruptedException {
        LongRunningThread thread = new LongRunningThread();

        thread.start();

        TimeUnit.MILLISECONDS.sleep(10000);

        thread.cancel();
    }
}
