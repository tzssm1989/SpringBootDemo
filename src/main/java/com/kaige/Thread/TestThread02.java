package com.kaige.Thread;

public class TestThread02 {

    static int b = 100;


    public static void main(String[] args) {

        HelloThread t1= new HelloThread("1");
        t1.start();
        HelloThread t2= new HelloThread("2");
        t2.start();

        System.out.println("开始的"+b);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t1.thread.join();
            t2.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("最后的"+b);


    }
}
