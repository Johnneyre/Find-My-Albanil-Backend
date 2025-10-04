package com.my_find_albanil.demo.domain.models.request.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestDTO {
    private Long id;
    private Long conversationId;
    private UUID senderId;
    private String body;
    private LocalDateTime sentAt;
}
