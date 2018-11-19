package com.kaige.Thread;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author songsm
 * @data 2018/10/17 上午9:39
 * @desc 用一句话描述此类的作用
 */
public class TestHashMap implements Runnable  {

    public static Map<String,String> map = new ConcurrentHashMap<>();
    @Override
    public void run() {

        for (int i = 0; i <5000000; i++) {

            map.put(Thread.currentThread().getName()+i,"a"+i);
        }

    }

    public static void main(String[] args) {

        long time = System.currentTimeMillis();



        TestHashMap h1 = new TestHashMap();
        TestHashMap h2 = new TestHashMap();
        TestHashMap h3 = new TestHashMap();

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 =  new Thread(h3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


            System.out.println(h1.map.size());

        System.out.println(System.currentTimeMillis()-time);


    }


}
