package com.huarui.service.es;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.MapMessage;

/**
 * Created by sloan on 2019/7/17.
 */

@Component
public class MqConsumer {

    @JmsListener(destination = "orderQueue")
    public void receiveOrder(MapMessage mapMessage) throws Exception{

        if(null != mapMessage){

            System.out.println("接受到的消息...");
            System.out.println("用户名"+mapMessage.getLong("userId"));
            System.out.println("菜的id:"+mapMessage.getLong("dishId"));
        }


    }
}
