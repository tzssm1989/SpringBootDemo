package com.kaige.Thread;

import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.GET;

/**
 * @author songsm
 * @data 2018/10/16 上午11:08
 * @desc 用一句话描述此类的作用
 */
@Setter
@Getter
class VolatileDemo implements Runnable {

  private boolean flag = true;

    @Override
    public void run() {

        System.out.println("子线程开始。。。。。。。");

        while(flag){
            try {
                Thread.sleep(1000);
                System.out.println("循环运算中。。。。。。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("子线程结束。。。。。。。");

    }
}

public class TestVolatile {

    public static void main(String[] args) throws Exception {

        VolatileDemo demo = new VolatileDemo();

        Thread.sleep(3000);

        new Thread(demo).start();

        Thread.sleep(3000);

        demo.setFlag(false);

        System.out.println("flag="+demo.isFlag());

    }
}
