package com.kaige.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class TestThread04  {

    public static void paseLog(String log){

        System.out.println(log+":"+System.currentTimeMillis()/1000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        System.out.println("begintime="+System.currentTimeMillis()/1000);

        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

        for (int i = 0; i <3; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {

                    while(true){

                        String log;

                        try {
                            log = queue.take();
                            TestThread04.paseLog(log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }).start();
        }

        System.out.println("开始添加数据了");

        for (int i = 0; i <16 ; i++) {

            final String log = ""+(i+1);
            try {
                queue.put(log);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(queue.size());
        System.out.println("数据添加完毕");
    }
}
