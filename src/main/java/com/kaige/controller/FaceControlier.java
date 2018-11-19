package com.kaige.controller;

import com.alibaba.fastjson.JSONObject;
import com.kaige.model.FaceAliPoJo;
import com.kaige.utils.AESDecode;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * @author songsm
 * @data 2018/9/27 上午10:53
 * @desc 用一句话描述此类的作用
 */
@Controller
public class FaceControlier {

    @RequestMapping(value="/face")
    @ResponseBody
    public String getFace(){

        String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";

        RestTemplate rest = new RestTemplate();

        MultiValueMap<String,Object> paramfile = new LinkedMultiValueMap<>();

        paramfile.add("api_key","mAvL7gjoWVkBJDFSmQL4-pQL0ig0NB1k");
        paramfile.add("api_secret","M7egYDNWtPcQpNi_vl0KKlCM47Q7lZ3D");
        paramfile.add("return_landmark",2);
        paramfile.add("return_attributes","none");


        File file = new File("/Users/songsm/Downloads/15192533166_20180523210634_99_dermisOriginal.jpg");

        FileSystemResource fileresource = new FileSystemResource(file);
      //    ByteArrayResource fileresource = new ByteArrayResource();
        paramfile.add("image_file",fileresource);

        String s = rest.postForObject(url,paramfile,String.class);

        System.out.println(s);

        return s;

    }

    @RequestMapping(value = "/facecompare")
    @ResponseBody
    public String getAliFaceCompare(@RequestParam("image1") CommonsMultipartFile image1 ,@RequestParam("image2") CommonsMultipartFile image2){

        String ak_id = "LTAIPhxB8TkMsC1W"; //用户ak
        String ak_secret = "nHBsJ4RQYAdGmoCXe9pE88vfViTfbw"; // 用户ak_secret
        String url = "https://dtplus-cn-shanghai.data.aliyuncs.com/face/verify";
        String content1 = AESDecode.getImagebyte(image1.getBytes());
        String content2 = AESDecode.getImagebyte(image2.getBytes());
        FaceAliPoJo faceAliPoJo = new FaceAliPoJo();
        faceAliPoJo.setType(1);
        faceAliPoJo.setContent_1(content1);
        faceAliPoJo.setContent_2(content2);

        String body = JSONObject.toJSONString(faceAliPoJo);

        String result = null;

        try{
            result = AESDecode.sendPost(url, body, ak_id, ak_secret);

        }catch (Exception e){

            e.printStackTrace();
        }


        System.out.println("response body:" +result);

        if(result != null){

            return result;
        }


        return null;
    }
}
