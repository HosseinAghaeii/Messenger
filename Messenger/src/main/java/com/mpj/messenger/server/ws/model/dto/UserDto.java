package com.mpj.messenger.server.ws.model.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private int id;

    private String userName;

    @Size(min = 8 , max = 11)
    private String password;

    private String encryptedPassword;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String photoLink;


}
