package com.mpj.messenger.server.ws.model.response;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mpj.messenger.server.ws.model.entity.ChatEntity;
import com.mpj.messenger.server.ws.model.entity.UserEntity;
import lombok.Data;


@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class MessageResponse {

    private long id ;

    private UserEntity publisher;

    private ChatEntity consumer; // user - group - channel

    private String consumerType;

    private String body;



    private String messageStatus;
}
