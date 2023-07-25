package com.mpj.messenger.server.ws.model.dto;

import com.mpj.messenger.server.ws.model.entity.ChatEntity;
import com.mpj.messenger.server.ws.model.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;


@Data
public class MessageDto implements Serializable {

    private long id ;

    private UserEntity publisher;

    private ChatEntity consumer; // user - group - channel

    private String consumerType;

    private String body;

    private String messageStatus;
}
