package com.mpj.messenger.server.ws.model.request;

import lombok.Data;

@Data
public class MessageRequest {

    private String publisherId;
    private String consumerId;
    private String consumeType;
    private String body;

}
