package com.mpj.messenger.server.ws.repository;

import com.mpj.messenger.server.ws.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
   UserEntity findByPhoneNumber(String phoneNumber);
   UserEntity findByUserName(String userName);
   UserEntity findByUserNameAndPassword(String username,String password);
}
