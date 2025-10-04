package com.my_find_albanil.demo.infraestructure.driven_adapters.message.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.message.MessageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageDataRepository extends JpaRepository<MessageData, Long> {
    @Query("SELECT m FROM MessageData m WHERE m.conversation.id = :conversationId")
    List<MessageData> findByConversationId(Long conversationId);
    
    @Query("SELECT m FROM MessageData m WHERE m.sender.id = :senderId")
    List<MessageData> findBySenderId(UUID senderId);
}
