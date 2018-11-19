package com.kaige.Thread;

import java.util.concurrent.Semaphore;

/**
 * @author songsm
 * @data 2018/10/19 下午4:00
 * @desc 用一句话描述此类的作用
 */
class Number extends Thread{

     Object pre;
     Object self;
     String name;

    Number(String name,Object pre,Object self){

        this.pre=pre;
        this.self=self;
        this.name=name;
    }

    @Override
    public void run() {

        int i=10;

        while(i>0){

            synchronized (pre){

                synchronized (self){
                    try {
                        self.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.name);
                    i--;

                }

                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

    }
}


public class Test001 {

    public static void main(String[] args)throws Exception {

         Object A = new Object();
         Object B = new Object();
         Object C = new Object();

         Number number1 = new Number("A",C,A);
         Number number2 = new Number("B",A,B);
         Number number3 = new Number("C",B,C);

         number1.start();
         number2.start();
         Thread.sleep(10);
         number3.start();






    }
}
