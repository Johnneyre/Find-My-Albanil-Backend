package com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.ConversationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationDataRepository extends JpaRepository<ConversationData, Long> {
}
