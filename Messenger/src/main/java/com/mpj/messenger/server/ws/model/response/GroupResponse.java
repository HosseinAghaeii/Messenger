package com.mpj.messenger.server.ws.model.response;

import com.mpj.messenger.server.ws.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class GroupResponse extends ChatResponse{
    private List<UserEntity> members = new ArrayList<>();

    public List<UserEntity> getMembers() {
        return members;
    }

    public void setMembers(List<UserEntity> members) {
        this.members = members;
    }
}
