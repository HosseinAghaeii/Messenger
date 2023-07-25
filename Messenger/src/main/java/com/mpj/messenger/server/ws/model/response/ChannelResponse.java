package com.mpj.messenger.server.ws.model.response;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mpj.messenger.server.ws.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class ChannelResponse extends ChatResponse{
    private List<UserEntity> admins = new ArrayList<>();
    private List<UserEntity> subscribers = new ArrayList<>();

    public void setAdmins(List<UserEntity> admins) {
        this.admins = admins;
    }

    public void setSubscribers(List<UserEntity> subscribers) {
        this.subscribers = subscribers;
    }

    public List<UserEntity> getAdmins() {
        return admins;
    }

    public List<UserEntity> getSubscribers() {
        return subscribers;
    }
}
