package com.mpj.messenger.server.rabbitmq.publisher;

import com.mpj.messenger.server.ws.model.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonPublisher {

    @Value("${rabbitmq.pv.exchange}")
    private String pvExchange;

    @Value("${rabbitmq.routing.pv.key}")
    private String pvRoutingKey;

    private static  final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonPublisher.class);
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQJsonPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendPVMessage(MessageDto messageDto){
        LOGGER.info(String.format("pv message sent -> %s",messageDto.toString()));
        rabbitTemplate.convertAndSend(pvExchange,pvRoutingKey,messageDto);
    }


}
