package com.mpj.messenger.server.ws.repository;

import com.mpj.messenger.server.ws.model.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity,Long> {
    ChatEntity findByName(String name);
}
