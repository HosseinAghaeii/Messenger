package com.mpj.messenger.server.ws.model.response;

import lombok.Data;

@Data
public class UserResponse {
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
