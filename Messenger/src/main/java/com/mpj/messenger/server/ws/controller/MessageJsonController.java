package com.mpj.messenger.server.ws.controller;

import com.mpj.messenger.server.ws.model.dto.MessageDto;
import com.mpj.messenger.server.ws.model.request.MessageRequest;
import com.mpj.messenger.server.rabbitmq.publisher.RabbitMQJsonPublisher;
import com.mpj.messenger.server.ws.model.response.MessageResponse;
import com.mpj.messenger.server.ws.service.impl.MessageServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
public class MessageJsonController {

    private final RabbitMQJsonPublisher jsonPublisher;
    private final MessageServiceImpl messageService;
    private final ModelMapper modelMapper = new ModelMapper();

    public MessageJsonController(RabbitMQJsonPublisher jsonPublisher, MessageServiceImpl messageService) {
        this.jsonPublisher = jsonPublisher;
        this.messageService = messageService;
    }

    //localhost:8080/msg/publish
    @PostMapping("/publish")
    public ResponseEntity<MessageResponse> sendJsonMessage(@RequestBody MessageRequest messageRequest){
        MessageDto messageDto = messageService.messageValidation(messageRequest);
        jsonPublisher.sendPVMessage(messageDto);
        messageService.saveMessageToDB(messageDto);

        MessageResponse returnValue = modelMapper.map(messageDto, MessageResponse.class);

        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

}
