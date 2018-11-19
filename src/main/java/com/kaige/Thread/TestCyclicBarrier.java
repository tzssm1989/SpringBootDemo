package com.kaige.Thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author songsm
 * @data 2018/10/18 下午6:40
 * @desc 用一句话描述此类的作用
 */
public class TestCyclicBarrier implements Runnable {
    CyclicBarrier cyclicBarrier;

    public TestCyclicBarrier(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }
    @Override
    public void run() {

        System.out.println("1");

        try {
            Thread.sleep(1000);
            System.out.println("2");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("3");
    }


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i = 0; i <5 ; i++) {

            new Thread(new TestCyclicBarrier(cyclicBarrier)).start();
        }
    }
}
