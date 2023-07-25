package com.mpj.messenger.server.ws.service;

import com.mpj.messenger.server.ws.model.request.PVRequest;
import com.mpj.messenger.server.ws.model.dto.ChatDto;
import com.mpj.messenger.server.ws.model.request.ChannelRequest;

public interface ChatService {

    ChatDto createPV(PVRequest pvRequest);
    ChatDto createChannel(ChannelRequest channelRequest);
}
