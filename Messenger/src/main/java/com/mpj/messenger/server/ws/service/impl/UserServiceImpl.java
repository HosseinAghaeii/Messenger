package com.mpj.messenger.server.ws.service.impl;

import com.mpj.messenger.server.exception.ServiceException;
import com.mpj.messenger.server.ws.service.UserService;
import com.mpj.messenger.server.ws.model.dto.UserDto;
import com.mpj.messenger.server.ws.repository.UserRepository;
import com.mpj.messenger.server.ws.model.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public UserServiceImpl(UserRepository userRepository ) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDto signup(UserDto userDto) {
        if (userRepository.findByPhoneNumber(userDto.getPhoneNumber()) != null)
            throw new ServiceException("Already registered with this phone number");
        if (userRepository.findByUserName(userDto.getUserName()) != null)
            throw new ServiceException("This username has already been used");

        UserEntity userEntity = modelMapper.map(userDto,UserEntity.class);

        UserEntity storedUserEntity = userRepository.save(userEntity);

        return modelMapper.map(storedUserEntity,UserDto.class);
    }

    @Override
    public UserDto signIn(String username , String password) {
        UserEntity userEntity = userRepository.findByUserNameAndPassword(username , password);
        if (userEntity == null) throw new ServiceException("There is no user with this username and password!");

        return modelMapper.map(userEntity,UserDto.class);
    }

}
