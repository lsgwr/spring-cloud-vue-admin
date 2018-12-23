package com.huawei.l00379880.examservice.service;

import com.alibaba.fastjson.JSON;
import com.huawei.l00379880.examservice.config.RabbitConfig;
import com.huawei.l00379880.examservice.entity.SysLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liangshanguang at 2018-12-23 21：29
 */
@Service
public class LoggerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void log(SysLog sysLog){
        rabbitTemplate.convertAndSend(RabbitConfig.queueName, JSON.toJSONString(sysLog));
    }
}
