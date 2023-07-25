package ir.mpj.client1.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf {
    @Value("${rabbitmq.pv.exchange}")
    private String pvExchange;

    @Value("${rabbitmq.queue.pv.name}")
    private String pvQueue;

    @Value("${rabbitmq.routing.pv.key}")
    private String pvRoutingKey;

    @Bean
    public TopicExchange pvExchange(){
        return new TopicExchange(pvExchange);
    }

    @Bean
    public Queue pvQueue(){
        return new Queue(pvQueue);
    }

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
