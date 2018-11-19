package com.kaige.Thread;

public class TestThread08 implements Runnable {

    volatile boolean keepRunning = true;

    public void run() {

        while(keepRunning){


            for (int i = 0; i < 5 ; i++) {

                System.out.println(Thread.currentThread().getName()+"攻击的"+i+"次");

                Thread.yield();

            }

        }


    }
}
