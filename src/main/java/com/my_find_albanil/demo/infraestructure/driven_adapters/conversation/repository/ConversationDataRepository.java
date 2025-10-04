package com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.ConversationData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConversationDataRepository {
    Optional<ConversationData> findById(Long id);
    ConversationData save(ConversationData conversation);
    void deleteById(Long id);
    List<ConversationData> findAll();
}
