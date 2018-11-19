package com.kaige.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {


    public static void saveFileByByte(byte[] bytes,String path,String filename) {

        FileOutputStream outputStream = null;

        try {

            outputStream = new FileOutputStream(new File(path,filename));

            outputStream.write(bytes);

            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void saveByUrl(String url){

     //    String savepath =
    }


    public void getRequest(){}


}
