package com.mpj.messenger.server.ws.controller;

import com.mpj.messenger.server.ws.model.dto.ChatDto;
import com.mpj.messenger.server.ws.model.request.PVRequest;
import com.mpj.messenger.server.ws.model.response.PVResponse;
import com.mpj.messenger.server.ws.service.impl.ChatServiceImpl;
import com.mpj.messenger.server.ws.model.request.ChannelRequest;
import com.mpj.messenger.server.ws.model.response.ChannelResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatServiceImpl chatService;
    private final ModelMapper modelMapper = new ModelMapper();

    public ChatController(ChatServiceImpl chatService) {
        this.chatService = chatService;
    }

    @PostMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<PVResponse> createPV(@RequestBody PVRequest pvRequest){

        ChatDto chatDto = chatService.createPV(pvRequest);
        PVResponse returnValue = modelMapper.map(chatDto,PVResponse.class);

        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @PostMapping("/channel")
    public ResponseEntity<ChannelResponse> createChannel(@RequestBody ChannelRequest channelRequest){
        ChatDto chatDto = chatService.createChannel(channelRequest);
        ChannelResponse returnValue = modelMapper.map(chatDto,ChannelResponse.class);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }
}
