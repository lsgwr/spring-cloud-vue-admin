package com.huawei.l00379880.userservice.service;

import com.alibaba.fastjson.JSON;
import com.huawei.l00379880.userservice.config.RabbitConfig;
import com.huawei.l00379880.userservice.entity.SysLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void log(SysLog sysLog){
        rabbitTemplate.convertAndSend(RabbitConfig.queueName, JSON.toJSONString(sysLog));
    }
}
