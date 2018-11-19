package com.kaige.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author songsm
 * @data 2018/10/12 上午9:24
 * @desc 用一句话描述此类的作用
 */
public class TestThread10  {

    public static void parseLog(String log){

        System.out.println(log+"+"+System.currentTimeMillis()/1000);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        System.out.println("begin:"+System.currentTimeMillis()/1000);

        BlockingQueue<String>  queue = new ArrayBlockingQueue<String>(16);

        for (int k=0 ; k<4 ; k++){

            new Thread(new Runnable() {

                public void run() {

                    String log;

                    while(true){

                        try {
                            log = queue.take();
                            parseLog(log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();

        }

        for(int i = 0;i<16;i++){

            String log = ""+(i+1);

            queue.add(log);
        }
    }


}
