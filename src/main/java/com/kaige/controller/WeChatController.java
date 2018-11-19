package com.kaige.controller;

import com.kaige.model.InMsgEntity;
import com.kaige.model.OutMsgEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author songsm
 * @data 2018/9/26 下午1:51
 * @desc 用一句话描述此类的作用
 */
@Controller
public class WeChatController {


    /**
     * 消息处理
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "weChat",method = RequestMethod.GET)
    @ResponseBody
     public String weChat(String signature,String timestamp,String nonce,String echostr){


        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        System.out.println("123============================");


        return echostr;
     }


    @RequestMapping(value = "weChat",method = RequestMethod.POST)
    @ResponseBody
    public Object handleMessage(@RequestBody InMsgEntity inMsgEntity){

        OutMsgEntity outMsg = new OutMsgEntity();
        outMsg.setFromUserName(inMsgEntity.getToUserName());
        outMsg.setToUserName(inMsgEntity.getFromUserName());
        outMsg.setCreateTime(new Date().getTime());
        if(inMsgEntity.getMsgType().equals("text")){
            outMsg.setMsgType("text");
            outMsg.setContent("我是来练级的");

        }else if(inMsgEntity.getMsgType().equals("image")){
            outMsg.setMsgType("image");
            outMsg.setMediaId(new String[]{inMsgEntity.getMediaId()});

        }



        return outMsg;
    }
}
