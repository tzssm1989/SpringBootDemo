package com.kaige.Thread;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author songsm
 * @data 2018/10/16 下午2:13
 * @desc 用一句话描述此类的作用
 */
public class TestAtomic implements Runnable {

    private static Integer count =0;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void run() {

     //   synchronized ("a"){

            for (int i = 0; i <10000 ; i++) {
                atomicInteger.getAndIncrement();
                System.out.println(Thread.currentThread().getName()+"="+atomicInteger.get());
            }

            System.out.println(Thread.currentThread().getName()+"="+atomicInteger.get());

       //}


    }

    public static void main(String[] args) {

        TestAtomic[] atomics = new TestAtomic[10];

        for (int i = 0; i <10 ; i++) {

            atomics[i]=new TestAtomic();
        }

        for(TestAtomic atomic:atomics){

            new Thread(atomic).start();
        }
    }
}
