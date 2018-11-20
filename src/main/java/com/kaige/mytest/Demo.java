package com.kaige.mytest;

/**
 * @author songsm
 * @data 2018/11/19 上午8:44
 * @desc 用一句话描述此类的作用
 */
public class Demo {

    public static Integer count=0;

    public Demo(){
        count++;
    }

    public static void main(String[] args) {

        for (int i = 0; i <10 ; i++) {

            new Demo();
        }

        System.out.println(count);
        System.out.println(count);
    }
}
