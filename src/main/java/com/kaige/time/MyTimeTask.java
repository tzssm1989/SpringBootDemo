package com.kaige.time;

import lombok.Getter;
import lombok.Setter;

import java.util.TimerTask;

/**
 * @author songsm
 * @data 2018/11/16 上午11:01
 * @desc 用一句话描述此类的作用
 */

@Setter
@Getter
public class MyTimeTask extends TimerTask {

    private String name;

    public MyTimeTask(String name){

        this.name=name;
    }

    public void run() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"CurrentName:"+name);

    }


}
