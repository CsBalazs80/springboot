package com.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {


    @Value("rabbitmq.queue")
    private String qName;


    @Value("rabbitmq.exchange")
    private String exchange;


    @Value("rabbitmq.routingkey")
    private String routingKey;

    /**
     * Queue definition with queue name. You may need more if you want more queue to use
     * */
    @Bean
    Queue queue() {
        return new Queue(qName, false);
    }

    /**
     * TopicExchange may define behaviour parameters
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(exchange);
    }

    /**
     * Topic binding to routing key
     */
    @Bean
    Binding binding(final Queue q, final TopicExchange topicExchange) {
        return BindingBuilder.bind(q).to(topicExchange).with(routingKey);
    }
}
