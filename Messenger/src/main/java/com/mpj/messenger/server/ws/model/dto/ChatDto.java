package com.mpj.messenger.server.ws.model.dto;

import com.mpj.messenger.server.ws.model.entity.MessageEntity;
import com.mpj.messenger.server.ws.model.entity.UserEntity;
import lombok.Data;

import java.util.*;

@Data
public class ChatDto  {
    private long id;
    private String name;
    private List<MessageEntity> receiveMessagesIds = new ArrayList<>();
    private List<UserEntity> admins = new ArrayList<>() ;
    private List<UserEntity> subscribers = new ArrayList<>();
    private List<UserEntity> members = new ArrayList<>();
    private List<UserEntity> users = new ArrayList<>();

}
