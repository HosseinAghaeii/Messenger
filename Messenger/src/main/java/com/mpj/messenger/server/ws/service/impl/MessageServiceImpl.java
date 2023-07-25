package com.mpj.messenger.server.ws.service.impl;

import com.mpj.messenger.server.exception.ServiceException;
import com.mpj.messenger.server.ws.model.dto.MessageDto;
import com.mpj.messenger.server.ws.model.entity.ChatEntity;
import com.mpj.messenger.server.ws.model.entity.MessageEntity;
import com.mpj.messenger.server.ws.model.request.MessageRequest;
import com.mpj.messenger.server.ws.repository.ChatRepository;
import com.mpj.messenger.server.ws.repository.MessageRepository;
import com.mpj.messenger.server.ws.service.MessageService;
import com.mpj.messenger.server.ws.model.entity.UserEntity;
import com.mpj.messenger.server.ws.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public MessageServiceImpl(UserRepository userRepository, ChatRepository chatRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public MessageDto messageValidation(MessageRequest messageRequest) {
        UserEntity publisherUser = userRepository.findByUserName(messageRequest.getPublisherId());
        if (publisherUser == null) throw new ServiceException("wrong publisher userID");
        ChatEntity consumerName = chatRepository.findByName(messageRequest.getConsumerId());
        if (consumerName == null) throw new ServiceException("wrong chatName");
        if (!messageRequest.getConsumeType().equals("PV") &&
                !messageRequest.getConsumeType().equals("CHANNEL") &&
                !messageRequest.getConsumeType().equals("GROUP")
        ) throw new ServiceException("invalid consumer type");

        MessageDto messageDto = new MessageDto();
        messageDto.setPublisher(publisherUser);
        messageDto.setConsumer(consumerName);
        messageDto.setConsumerType(messageRequest.getConsumeType());
        messageDto.setBody(messageRequest.getBody());

        MessageEntity messageEntity = modelMapper.map(messageDto,MessageEntity.class);

        return modelMapper.map(messageEntity,MessageDto.class);
    }

    @Override
    public MessageDto saveMessageToDB(MessageDto messageDto) {
        MessageEntity messageEntity = modelMapper.map(messageDto,MessageEntity.class);
        MessageEntity storedMessage = messageRepository.save(messageEntity);
        return modelMapper.map(storedMessage,MessageDto.class);
    }


}
