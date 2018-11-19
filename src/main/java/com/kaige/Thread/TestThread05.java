package com.kaige.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class TestThread05 {

    public static void main(String[] args) {

        System.out.println("begintime="+System.currentTimeMillis()/1000);

        final BlockingQueue<String> queue = new SynchronousQueue<String>();

        final Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i <10 ; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {


                        try {
                            semaphore.acquire();
                            String input=queue.take();
                            String s= TestDo.doSome(input);
                            System.out.println(Thread.currentThread().getName()+"=="+s);
                            semaphore.release();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

            }).start();

        }

        System.out.println("开始添加数据");
        for (int i = 0; i < 100 ; i++) {

            String input = ""+(i+1);

            try {
                queue.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        System.out.println("数据添加完毕");

    }


}


class TestDo{


    public static String doSome(String input){


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input+"=="+System.currentTimeMillis()/1000;
        return output;
    }


        }
