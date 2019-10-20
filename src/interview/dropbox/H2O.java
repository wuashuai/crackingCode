package interview.dropbox;

import java.util.concurrent.Semaphore;

class H2O {

    Semaphore sem, semO, semH;

    public H2O() {
        semH = new Semaphore(0);
        semO = new Semaphore(2);
        sem = new Semaphore(0);
    }
    public void hydrogen() throws InterruptedException {
        sem.release(1);
        semH.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        System.out.println("H");
        semO.release(1);
    }
    public void oxygen() throws InterruptedException {
        semO.acquire(2);
        sem.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        System.out.println("O");
        semH.release(2);
    }
}

class Test {
    public static void main(String[] args) {
        String input = "HHOHHOH";

        System.out.println("test");

        H2O p = new H2O();
        for(char c : input.toCharArray()){

            Thread t;

            if(c == 'H') t = new Thread(new ReleaseHydrogen(p));
            else t = new Thread(new ReleaseOxygen(p));

            t.start();
        }
    }
}

class ReleaseHydrogen implements Runnable {

    H2O p;

    ReleaseHydrogen(H2O p){
        this.p = p;
    }

    @Override
    public void run() {
        try {
            p.hydrogen();
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
}

class ReleaseOxygen implements Runnable {
    H2O p;

    ReleaseOxygen(H2O p){
        this.p = p;
    }

    @Override
    public void run() {
        try {
            p.oxygen();
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
}