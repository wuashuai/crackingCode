package interview.dropbox;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ServiceImpl {
    Map<String, String> map;
    ReadWriteLock rw;

    ServiceImpl(){
        map = new HashMap<String, String>(){{
            put("0", "a");
        }};

        rw = new ReadWriteLock();
    }


    void write() throws InterruptedException {
        rw.lockWrite();

        System.out.println(Thread.currentThread().getName() + " write! ");
        Thread.sleep((long) (Math.random() * 1000));

        Date date = new Date(System.currentTimeMillis());

        String time = new SimpleDateFormat("HH:mm:ss.SSS").format(date);

        map.put("0", Thread.currentThread().getName() + " " + time);

        rw.unlockWrite();
    }

    String read() throws InterruptedException {
        rw.lockRead();

        System.out.println(Thread.currentThread().getName() + " read! ");

        String res = map.get("0");

        rw.unlockRead();

        return res;

    }

    public static void main(String[] args){
        ServiceImpl service = new ServiceImpl();

        for(int i = 0; i < 3; i++){
            Thread t = new Thread(new PrintWorker(service));
            t.start();

            Thread t2 = new Thread(new WriteWorker(service));
            t2.start();
        }

    }
}

class PrintWorker implements Runnable{
    ServiceImpl service;

    PrintWorker(ServiceImpl service){
        this.service = service;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < 3; i++){
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(service.read());
            }
        }catch(InterruptedException e){
            System.out.println("InterruptedException " + e);
        }
    }
}

class WriteWorker implements Runnable{
    ServiceImpl service;

    WriteWorker(ServiceImpl service){
        this.service = service;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < 10; i++){
                Thread.sleep((long) (Math.random() * 1000));
                service.write();
            }
        }catch(InterruptedException e){
            System.out.println("InterruptedException " + e);
        }
    }
}