package com.mpj.messenger.server.ws.service.impl;

import com.mpj.messenger.server.ws.model.request.PVRequest;
import com.mpj.messenger.server.ws.service.ChatService;
import com.mpj.messenger.server.exception.ServiceException;
import com.mpj.messenger.server.ws.model.dto.ChatDto;
import com.mpj.messenger.server.ws.model.entity.ChannelEntity;
import com.mpj.messenger.server.ws.model.entity.PVEntity;
import com.mpj.messenger.server.ws.model.entity.UserEntity;
import com.mpj.messenger.server.ws.model.request.ChannelRequest;
import com.mpj.messenger.server.ws.repository.ChatRepository;
import com.mpj.messenger.server.ws.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ChatServiceImpl(UserRepository userRepository, ChatRepository chatRepository) {
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
    }

    @Override
    public ChatDto createPV(PVRequest pvRequest) {
        UserEntity user1 = userRepository.findByUserName(pvRequest.getUserId1());
        UserEntity user2 = userRepository.findByUserName(pvRequest.getUserId2());
        if (user1 == null || user2 == null) throw new ServiceException("invalid userid");

        List<UserEntity> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        ChatDto chatDto = new ChatDto();
        chatDto.setName(pvRequest.getName());
        chatDto.setUsers(users);

        PVEntity pvEntity = new PVEntity();
        pvEntity.setName(chatDto.getName());
        pvEntity.setUsers(users);

        PVEntity storedPV = chatRepository.save(pvEntity);

        return modelMapper.map(storedPV,ChatDto.class);
    }

    @Override
    public ChatDto createChannel(ChannelRequest channelRequest) {
        UserEntity admin = userRepository.findByUserName(channelRequest.getAdminUserid());
        UserEntity sub1 = userRepository.findByUserName(channelRequest.getSubUserid1());
        UserEntity sub2 = userRepository.findByUserName(channelRequest.getSubUserid2());
        if (admin == null || sub1 == null || sub2 == null ) throw  new ServiceException("invalid userId");

        List<UserEntity> admins = new ArrayList<>();
        admins.add(admin);

        List<UserEntity> subscribers = new ArrayList<>();
        subscribers.add(sub1);
        subscribers.add(sub2);

        ChannelEntity channelEntity = new ChannelEntity();
        channelEntity.setName(channelRequest.getName());
        channelEntity.setAdmins(admins);
        channelEntity.setSubscribers(subscribers);

        ChannelEntity storedDetails = chatRepository.save(channelEntity);

        return modelMapper.map(storedDetails,ChatDto.class);
    }
}
