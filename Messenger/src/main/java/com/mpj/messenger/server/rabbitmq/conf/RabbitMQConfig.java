package com.mpj.messenger.server.rabbitmq.conf;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.pv.exchange}")
    private String pvExchange;

    @Value("${rabbitmq.queue.pv.name}")
    private String pvQueue;
    @Value("${rabbitmq.routing.pv.key}")
    private String pvRoutingKey;

    //spring bean for rabbitmq exchange
    @Bean
    public TopicExchange pvExchange(){
        return new TopicExchange(pvExchange);
    }

    //spring bean for pv queue
    @Bean
    public Queue pvQueue(){
        return new Queue(pvQueue);
    }

    //binding between pv queue and exchange using  pv routing key
    @Bean
    public Binding pvBinding(){
        return BindingBuilder.bind( pvQueue() ).to( pvExchange() ).with(pvRoutingKey);
    }


    @Bean
    public MessageConverter converter(){
            return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }


}
