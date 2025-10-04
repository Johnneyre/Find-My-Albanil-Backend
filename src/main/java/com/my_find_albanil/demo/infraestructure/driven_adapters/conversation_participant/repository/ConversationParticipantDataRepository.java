package com.my_find_albanil.demo.infraestructure.driven_adapters.conversation_participant.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation_participant.ConversationParticipantData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConversationParticipantDataRepository extends JpaRepository<ConversationParticipantData, Long> {
    @Query("SELECT cp FROM ConversationParticipantData cp WHERE cp.conversation.id = :conversationId")
    List<ConversationParticipantData> findByConversationId(Long conversationId);
    
    @Query("SELECT cp FROM ConversationParticipantData cp WHERE cp.user.id = :userId")
    List<ConversationParticipantData> findByUserId(UUID userId);
    
    @Query("SELECT cp FROM ConversationParticipantData cp WHERE cp.conversation.id = :conversationId AND cp.user.id = :userId")
    Optional<ConversationParticipantData> findByConversationIdAndUserId(Long conversationId, UUID userId);
}
