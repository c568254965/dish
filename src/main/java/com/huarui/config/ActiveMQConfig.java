package com.huarui.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created by sloan on 2019/7/11.
 */

@Component
@EnableJms
public class ActiveMQConfig {


    @Value("${orderQueue}")
    private  String queueName;


    @Bean
    public Queue queue(){

        return  new ActiveMQQueue(queueName);
    }


}
