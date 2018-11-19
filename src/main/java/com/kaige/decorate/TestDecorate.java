package com.kaige.decorate;

/**
 * @author songsm
 * @data 2018/10/23 上午10:13
 * @desc 用一句话描述此类的作用
 */
public class TestDecorate {

    public static void main(String[] args) {


        String s =new ShoeDecorate(new Magic()).describe();

        s = new ShoeDecorate(new HatDecorate(new Magic())).describe();

        System.out.println(s);
    }
}
