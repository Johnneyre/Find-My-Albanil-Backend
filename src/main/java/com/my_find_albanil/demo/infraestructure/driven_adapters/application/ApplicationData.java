package com.my_find_albanil.demo.infraestructure.driven_adapters.application;

import com.my_find_albanil.demo.infraestructure.driven_adapters.job.JobData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"job_id", "worker_profile_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private JobData job;

    @ManyToOne
    @JoinColumn(name = "worker_profile_id", nullable = false)
    private WorkerProfileData workerProfile;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "proposed_rate", precision = 10, scale = 2)
    private BigDecimal proposedRate;

    @Column(columnDefinition = "text default 'submitted'")
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
