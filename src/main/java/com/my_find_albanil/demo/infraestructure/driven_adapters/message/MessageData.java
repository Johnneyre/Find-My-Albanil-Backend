package com.my_find_albanil.demo.infraestructure.driven_adapters.message;

import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.ConversationData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    private ConversationData conversation;

    @ManyToOne
    @JoinColumn(name = "sender_user_id", nullable = false)
    private UserData sender;

    private String body;

    @CreationTimestamp
    @Column(name = "sent_at", updatable = false)
    private LocalDateTime sentAt;
}
