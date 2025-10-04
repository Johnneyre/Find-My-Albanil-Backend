package com.my_find_albanil.demo.infraestructure.driven_adapters.review;

import com.my_find_albanil.demo.infraestructure.driven_adapters.user.UserData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"reviewer_user_id", "target_user_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reviewer_user_id", nullable = false)
    private UserData reviewer;

    @ManyToOne
    @JoinColumn(name = "target_user_id", nullable = false)
    private UserData target;

    @Column(nullable = false)
    private Short rating;

    private String title;

    private String body;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
