package com.mpj.messenger.server.ws.service;

import com.mpj.messenger.server.ws.model.dto.MessageDto;
import com.mpj.messenger.server.ws.model.request.MessageRequest;

public interface MessageService {
    MessageDto messageValidation(MessageRequest messageRequest);

    MessageDto saveMessageToDB(MessageDto messageDto);
}
