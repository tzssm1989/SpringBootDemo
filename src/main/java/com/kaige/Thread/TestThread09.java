package com.kaige.Thread;

import javax.naming.Name;
import javax.sound.midi.Soundbank;

/**
 * @author songsm
 * @data 2018/10/11 下午4:05
 * @desc 用一句话描述此类的作用
 */
public class TestThread09 implements Runnable {

    private String name;
    private Object pre;
    private Object self;

    public TestThread09(String name,Object pre,Object self){

        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    public void run() {

        int count = 10;

        while (count>0) {

            synchronized (pre) {

                synchronized (self) {


                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.name+"==="+count);
                    count--;
                    self.notify();

                }
                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }





    }

    public static void main(String[] args)throws Exception {

        Object A = new Object();
        Object B = new Object();
        Object C = new Object();

        TestThread09 t1 = new TestThread09("A",C,A);
        TestThread09 t2 = new TestThread09("B",A,B);
        TestThread09 t3 = new TestThread09("C",B,C);

        new Thread(t1).start();
        Thread.sleep(100);
        new Thread(t2).start();
        Thread.sleep(100);
        new Thread(t3).start();

        Thread.sleep(10000);
        System.out.println("over");

    }
}
