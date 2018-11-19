package com.kaige.Thread;

import com.kaige.model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestThread {

    public static void main(String[] args) {

//        HelloThread h1 = new HelloThread("线程一");
//        h1.start();
//        HelloThread h2 = new HelloThread("线程二");
//        h2.start();
//        Date date1 = new Date();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Date date2 = new Date();
//
//
//        System.out.println(new Date().getTime());
//        System.out.println(date2.getTime()-date1.getTime());

//
//
//           double d1 =5/3;
//        System.out.println(d1);
//
//           float f1 = 5/3;
//        System.out.println(f1);
//
//        char c1='w';
//        char c2= 's';
//
//        System.out.println((int)c1);
//
//         String s ="/abc/bcd/cdf/ff.jpg";
//
//        System.out.println(s.lastIndexOf("/"));
//        System.out.println(s.lastIndexOf("/",s.lastIndexOf("/")-1));
//        System.out.println(s.indexOf("/"));
//        System.out.println(s.indexOf("/",3));

//        for (Money money:Money.values()) {
//
//            System.out.println(money);
//            System.out.println(money.ordinal());
//        }
//
//        System.out.println(new Random().nextInt(4) / 100.0);
//
//           Field[] filelds=Student.class.getDeclaredFields();
//
//           for (Field field:filelds){
//
//               System.out.println(field.getName());
//           }

         File file  = new File("/Users/songsm/Downloads/NavicatPremium12015.dmg");

         System.out.println();
         System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));


         File filezip = new File("/Users/songsm/Downloads/NavicatPremium12015.zip");

         long time =System.currentTimeMillis();

        try {
            FileInputStream fis = new FileInputStream(file);

            ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(filezip));

            zipout.putNextEntry(new ZipEntry(file.getName()));

            int len = 0;

            while((len=fis.read())!= -1){

                zipout.write(len);
            }
            zipout.flush();

            fis.close();
            zipout.close();

            System.out.println(System.currentTimeMillis()-time);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
