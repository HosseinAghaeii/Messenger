package ir.mpj.client1.rabbitmq;

import com.rabbitmq.client.Channel;
import ir.mpj.client1.data.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitmqConsume {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqConsume.class);
    @RabbitListener(queues = "${rabbitmq.queue.pv.name}" , ackMode = "MANUAL")
    public void consumeJsonMessage(MessageDto messageDto, Channel channel ,
                                   @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        if(messageDto.getPublisher().getUserName().equals("hossA")){
            channel.basicAck(tag,false);
        }else {
            channel.basicAck(tag,true);
            LOGGER.info(String.format("c1 Received message -> %s",messageDto.toString()));

        }
    }
}
