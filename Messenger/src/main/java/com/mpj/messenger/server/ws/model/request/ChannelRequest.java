package com.mpj.messenger.server.ws.model.request;


public class ChannelRequest extends ChatRequest{
    private String adminUserid;
    private String subUserid1;
    private String subUserid2;


    public void setAdminUserid(String adminUserid) {
        this.adminUserid = adminUserid;
    }

    public void setSubUserid1(String subUserid1) {
        this.subUserid1 = subUserid1;
    }

    public void setSubUserid2(String subUserid2) {
        this.subUserid2 = subUserid2;
    }

    public String getAdminUserid() {
        return adminUserid;
    }

    public String getSubUserid1() {
        return subUserid1;
    }

    public String getSubUserid2() {
        return subUserid2;
    }
}
