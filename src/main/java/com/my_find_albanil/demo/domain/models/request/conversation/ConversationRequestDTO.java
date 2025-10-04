package com.my_find_albanil.demo.domain.models.request.conversation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationRequestDTO {
    private Long id;
    private LocalDateTime createdAt;
}
