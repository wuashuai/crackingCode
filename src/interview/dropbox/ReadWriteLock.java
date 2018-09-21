package interview.dropbox;

import java.util.concurrent.Semaphore;

public class ReadWriteLock {

    private int read = 0;
    private int request = 0;
    private final Semaphore write = new Semaphore(1);

    public synchronized void lockRead() throws InterruptedException {
        while(write.availablePermits() > 0 && request > 0) {
            wait();
        }
        read++;
    }

    public synchronized void unlockRead() throws InterruptedException {
        read--;
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        request++;

        while(read > 0){
            wait();
        }

        write.acquire();
    }

    public synchronized void unlockWrite() throws InterruptedException {
        request--;
        write.release();
    }
}
