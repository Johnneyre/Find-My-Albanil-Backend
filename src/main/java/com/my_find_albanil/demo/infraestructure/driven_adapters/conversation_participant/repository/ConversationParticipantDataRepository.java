package com.my_find_albanil.demo.infraestructure.driven_adapters.conversation_participant.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation_participant.ConversationParticipantData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConversationParticipantDataRepository {
    Optional<ConversationParticipantData> findById(Long id);
    List<ConversationParticipantData> findByConversationId(Long conversationId);
    List<ConversationParticipantData> findByUserId(UUID userId);
    Optional<ConversationParticipantData> findByConversationIdAndUserId(Long conversationId, UUID userId);
    ConversationParticipantData save(ConversationParticipantData participant);
    void deleteById(Long id);
    List<ConversationParticipantData> findAll();
}
