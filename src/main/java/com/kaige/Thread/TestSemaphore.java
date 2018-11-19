package com.kaige.Thread;

import org.springframework.transaction.TransactionUsageException;
import sun.font.TrueTypeFont;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author songsm
 * @data 2018/10/18 下午6:53
 * @desc 用一句话描述此类的作用
 */
class People{

    String name;

    public  People(String name){
        this.name =name;

    }

    public void onWc(){

        System.out.println(this.name+"正在上厕所");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name+"上完厕所出来了");

    }
}


class Toilet extends Thread{

    BlockingQueue<People> queue;

    Toilet(BlockingQueue<People> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true){

            try {
                People people = queue.take();
                people.onWc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}

public class TestSemaphore {

    public static void main(String[] args) {

        BlockingQueue<People> queue = new ArrayBlockingQueue(10);

        for (int i = 0; i <10 ; i++) {

            People p = new People(i+"");

            queue.add(p);
        }

        for (int i = 0; i <3 ; i++) {

            new Toilet(queue).start();
        }



    }
}
