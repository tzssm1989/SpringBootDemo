package com.kaige.facetest;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author songsm
 * @data 2018/9/30 上午8:18
 * @desc 用一句话描述此类的作用
 */
public class FaceRemoveFace {

    public static void main(String[] args) {

        String url_create = "https://api-cn.faceplusplus.com/facepp/v3/faceset/removeface";

        RestTemplate rs = new RestTemplate();

        MultiValueMap<String,Object> paramfile = new LinkedMultiValueMap<>();

        paramfile.add("api_key","mAvL7gjoWVkBJDFSmQL4-pQL0ig0NB1k");
        paramfile.add("api_secret","M7egYDNWtPcQpNi_vl0KKlCM47Q7lZ3D");
        paramfile.add("faceset_token","35ae3dd027c2e4a82b23ba9f47389f62");

        paramfile.add("face_tokens","RemoveAllFaceTokens");



        String s = rs.postForObject(url_create,paramfile,String.class);

        System.out.println(s);


    }
}
