package com.demo.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitReceiver.class);

    @Autowired
    Queue qu;

    @RabbitListener(queues = "#{qu.getName()}")
    public void getMsg(final String message) {
        LOGGER.info("RabbitReceiver received the message: " + message);
    }

}
