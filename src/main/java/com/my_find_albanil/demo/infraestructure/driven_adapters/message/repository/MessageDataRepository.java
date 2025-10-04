package com.my_find_albanil.demo.infraestructure.driven_adapters.message.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.message.MessageData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageDataRepository {
    Optional<MessageData> findById(Long id);
    List<MessageData> findByConversationId(Long conversationId);
    List<MessageData> findBySenderId(UUID senderId);
    MessageData save(MessageData message);
    void deleteById(Long id);
    List<MessageData> findAll();
}
