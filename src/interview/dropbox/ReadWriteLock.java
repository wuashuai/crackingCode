package interview.dropbox;

import java.util.concurrent.Semaphore;

public class ReadWriteLock {

    private int read = 0;
    private int request = 0;
    private int write = 0;

    public synchronized void lockRead() throws InterruptedException {
        while(write > 0 && request > 0) {
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

        while(write > 0 || read > 0){
            wait();
        }
        request--;
        write++;
    }

    public synchronized void unlockWrite() throws InterruptedException {
        write--;
        notifyAll();
    }
}
