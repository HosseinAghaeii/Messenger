package com.mpj.messenger.server.ws.model.request;

import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class SignupRequest {

    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    @Size(min = 8 , max = 11)
    private String password;

}
