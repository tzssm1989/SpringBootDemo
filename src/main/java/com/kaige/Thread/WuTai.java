package com.kaige.Thread;

public class WuTai extends Thread{


    @Override
    public void run() {

        TestThread08  r1 = new TestThread08();
        TestThread08  r2 = new TestThread08();

        Thread t1= new Thread(r1,"隋朝军队");

        Thread t2= new Thread(r2,"农民军队");

        t1.start();
        t2.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        r1.keepRunning = false;
        r2.keepRunning = false;


        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new WuTai().start();
    }
}
