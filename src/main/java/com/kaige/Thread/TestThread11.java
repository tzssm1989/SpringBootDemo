package com.kaige.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @author songsm
 * @data 2018/10/12 上午10:11
 * @desc 用一句话描述此类的作用
 */
public class TestThread11 {


    public static void main(String[] args) {

        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
        final Semaphore semaphore = new Semaphore(1);

        for(int k=0 ; k < 16 ; k++){

           new Thread(new Runnable() {



               public void run() {
                      String in;
                   try {
                       semaphore.acquire();
                       in = queue.take();
                       System.out.println(Thread.currentThread().getName()+"======"+Test01.dothing(in));
                       semaphore.release();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }
           }).start();
        }



        for(int i =0 ;i<10; i++){

            String input = i+"";

            queue.add(input);

          //  System.out.println(Thread.currentThread().getName()+"======"+Test01.dothing(input));
        }


    }
}


class Test01{

    public static String dothing(String input ){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String out = input+"+"+System.currentTimeMillis()/1000;
        return out;

    }

}
