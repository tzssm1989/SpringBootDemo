package com.kaige.time;

import java.util.Timer;

/**
 * @author songsm
 * @data 2018/11/16 上午11:05
 * @desc 用一句话描述此类的作用
 */

public class MyTimer {

    public static void main(String[] args) {

        MyTimeTask myTimeTask = new MyTimeTask("No1");

        Timer timer = new Timer();

        timer.schedule(myTimeTask,1000L,1000L);
        
    }
}
