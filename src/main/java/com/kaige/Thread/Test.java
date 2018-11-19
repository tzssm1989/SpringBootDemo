package com.kaige.Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class Test {
    public static void main(String[] args) {

        final SynchronousQueue<String> queue = new SynchronousQueue<String>();
        final Semaphore semaphore = new Semaphore(1);//10个线程，分别消费数据，依旧是从阻塞队列中获取数据
        for (int i = 0; i < 10; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        String input = queue.take();
                        String output = TestDo1.doSome(input);
                        System.out.println(Thread.currentThread().getName() + ":" + output);
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }).start();


        System.out.println("begin:" + (System.currentTimeMillis() / 1000));
        for (int i = 0; i < 10; i++) {  //这行不能改动
            String input = i + "";  //这行不能改动，不断产生数据
            try {
                queue.put(input);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

class TestDo1 {


    public static String doSome(String input) {


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + "==" + System.currentTimeMillis() / 1000;
        return output;
    }


}
