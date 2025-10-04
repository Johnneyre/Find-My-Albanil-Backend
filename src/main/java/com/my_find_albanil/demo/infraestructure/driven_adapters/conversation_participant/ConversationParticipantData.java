package com.my_find_albanil.demo.infraestructure.driven_adapters.conversation_participant;

import com.my_find_albanil.demo.infraestructure.driven_adapters.conversation.ConversationData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "conversation_participants", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"conversation_id", "user_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationParticipantData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    private ConversationData conversation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserData user;
}
