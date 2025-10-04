package com.my_find_albanil.demo.domain.models.request.conversation_participant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationParticipantRequestDTO {
    private Long id;
    private Long conversationId;
    private UUID userId;
}
