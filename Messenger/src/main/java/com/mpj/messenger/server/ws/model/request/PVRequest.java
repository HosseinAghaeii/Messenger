package com.mpj.messenger.server.ws.model.request;

public class PVRequest extends ChatRequest {
    private String userId1;
    private String userId2;

    public void setUserId1(String userId1) {
        this.userId1 = userId1;
    }

    public void setUserId2(String userId2) {
        this.userId2 = userId2;
    }

    public String getUserId1() {
        return userId1;
    }

    public String getUserId2() {
        return userId2;
    }
}
