package com.mpj.messenger.server.ws.controller;

import com.mpj.messenger.server.ws.model.request.SignInRequest;
import com.mpj.messenger.server.ws.model.dto.UserDto;
import com.mpj.messenger.server.ws.model.request.SignupRequest;
import com.mpj.messenger.server.ws.model.response.UserResponse;
import com.mpj.messenger.server.ws.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE },
            consumes = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE}
    )
    public UserResponse signup(@Valid @RequestBody SignupRequest userDetail){

        UserDto userDto = modelMapper.map(userDetail, UserDto.class);

        UserDto signup = userService.signup(userDto);

        return modelMapper.map(signup, UserResponse.class);
    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE },
            consumes = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE}
    )
    public UserResponse signIn(@Valid @RequestBody SignInRequest user){

        UserDto userDto = userService.signIn(user.getUserName(), user.getPassword());
        return modelMapper.map(userDto,UserResponse.class);
    }


}
