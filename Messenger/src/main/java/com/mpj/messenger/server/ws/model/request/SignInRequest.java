package com.mpj.messenger.server.ws.model.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInRequest {
    private String userName;

    @Size(min = 8 , max = 11)
    private String password;
}
