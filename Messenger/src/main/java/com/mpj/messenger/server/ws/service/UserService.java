package com.mpj.messenger.server.ws.service;

import com.mpj.messenger.server.ws.model.dto.UserDto;

public interface UserService{

     UserDto signup(UserDto userDto);
     UserDto signIn(String username , String password);
}
