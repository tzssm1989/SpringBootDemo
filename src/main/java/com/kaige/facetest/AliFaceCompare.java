package com.kaige.facetest;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author songsm
 * @data 2018/9/30 上午8:18
 * @desc 用一句话描述此类的作用
 */
public class AliFaceCompare {

    public static void main(String[] args) {

        String url_create = "https://dtplus-cn-shanghai.data.aliyuncs.com/face/attribute";

        RestTemplate rs = new RestTemplate();

        MultiValueMap<String,Object> paramfile = new LinkedMultiValueMap<>();

        paramfile.add("type",0);
        paramfile.add("image_url_1","http://imgsrc.baidu.com/imgad/pic/item/cf1b9d16fdfaaf511705164c865494eef11f7a5b.jpg");
        paramfile.add("image_url_2","http://imgsrc.baidu.com/imgad/pic/item/cf1b9d16fdfaaf511705164c865494eef11f7a5b.jpg");

        String s = rs.postForObject(url_create,paramfile,String.class);

        System.out.println(s);


    }
}
