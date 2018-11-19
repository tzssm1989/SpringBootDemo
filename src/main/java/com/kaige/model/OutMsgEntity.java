package com.kaige.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

/**
 * @author songsm
 * @data 2018/9/26 下午4:12
 * @desc 用一句话描述此类的作用
 */

@Setter
@Getter
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutMsgEntity {

    @XmlElement(name = "ToUserName")
    private String toUserName; //开发者微信号
    private String FromUserName; //发送方帐号（一个OpenID）
    private Long CreateTime; //消息创建时间 （整型）
    private String MsgType; //text
    private Long MsgId; //消息id，64位整型


    private String Content; //文本消息内容

  //  private String PicUrl;    //图片链接（由系统生成）
    @XmlElementWrapper(name="Image")
    private String[] MediaId;    //图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
}
