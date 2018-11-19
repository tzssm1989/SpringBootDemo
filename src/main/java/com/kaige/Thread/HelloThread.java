package com.kaige.Thread;

public class HelloThread implements Runnable {

    public Thread thread;
    public String threadname;

    public HelloThread(String threadname){

        this.threadname = threadname;
        System.out.println(threadname+"构建完成");
    }
    @Override
    public void run() {


        for (int i = 0; i <100 ; i++) {

             TestThread02.b++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.threadname+"====="+TestThread02.b);
        }

        System.out.println(threadname+"方法结束了");
    }

    public void start(){

        if(thread == null){

            thread = new Thread(this,threadname);

            System.out.println("线程创建"+threadname);
            thread.start();
        }
    }
}
