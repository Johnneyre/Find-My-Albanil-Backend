package com.my_find_albanil.demo.infraestructure.driven_adapters.job;

import com.my_find_albanil.demo.infraestructure.driven_adapters.employer.EmployerData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private EmployerData employer;

    @Column(nullable = false)
    private String title;

    private String description;

    private String location;

    @Column(name = "salary_range")
    private String salaryRange;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "full_time", columnDefinition = "boolean default false")
    private Boolean fullTime;

    @Column(name = "remote_allowed", columnDefinition = "boolean default false")
    private Boolean remoteAllowed;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "text default 'open'")
    private String status;
}
