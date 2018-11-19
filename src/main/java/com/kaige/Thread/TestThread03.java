package com.kaige.Thread;

public class TestThread03 {

    public static void paseLog(String log){

        System.out.println(log+":"+System.currentTimeMillis()/1000);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        System.out.println("begintime"+System.currentTimeMillis()/1000);

        for (int i = 0; i < 16 ; i++) {

            final String log = ""+(i+1);

            TestThread03.paseLog(log);


        }

    }
}
