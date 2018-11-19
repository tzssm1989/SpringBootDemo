package com.kaige.facetest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

/**
 * @author songsm
 * @data 2018/9/30 上午8:18
 * @desc 用一句话描述此类的作用
 */
public class FaceSearch {

    public static void main(String[] args) {

        String url_search = "https://api-cn.faceplusplus.com/facepp/v3/search";

        RestTemplate rest = new RestTemplate();

        MultiValueMap<String,Object> paramfile = new LinkedMultiValueMap<>();

        paramfile.add("api_key","mAvL7gjoWVkBJDFSmQL4-pQL0ig0NB1k");
        paramfile.add("api_secret","M7egYDNWtPcQpNi_vl0KKlCM47Q7lZ3D");
        paramfile.add("faceset_token","35ae3dd027c2e4a82b23ba9f47389f62");
        paramfile.add("face_token","c02fa171ec0738d3eff22814f5669fcc");



     //   File file = new File("/Users/songsm/Downloads/faceCompareImg-Test/m.png");

      //  FileSystemResource fileresource = new FileSystemResource(file);
        //    ByteArrayResource fileresource = new ByteArrayResource();
     //   paramfile.add("image_file",fileresource);

        String s = rest.postForObject(url_search,paramfile,String.class);

        System.out.println(s);


    }
}
