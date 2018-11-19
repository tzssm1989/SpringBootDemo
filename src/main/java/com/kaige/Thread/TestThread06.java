package com.kaige.Thread;

public class TestThread06 extends Thread {


    @Override
    public void run() {

        System.out.println(this.getName()+"开始工作了");

        int count = 0;

        while(count < 100){

            System.out.println(this.getName()+"已经连续工作"+(++count)+"小时了");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this.getName()+"下班了");
    }


    public static void main(String[] args) {

        Thread t1 = new TestThread06();

        Thread t2 = new Thread(new TestThread07(),"BUG");

        t1.setName("小宋");

        t1.start();

        t2.start();
    }

}



class TestThread07 implements Runnable {


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"开始工作了");

        int count = 0;

        while(count < 100){

            System.out.println(Thread.currentThread().getName()+"已经连续工作"+(++count)+"小时了");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+"下班了");

    }
}
