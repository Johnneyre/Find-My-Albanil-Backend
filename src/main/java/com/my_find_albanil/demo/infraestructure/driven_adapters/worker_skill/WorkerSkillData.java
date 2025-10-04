package com.my_find_albanil.demo.infraestructure.driven_adapters.worker_skill;

import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import com.my_find_albanil.demo.infraestructure.driven_adapters.skill.SkillData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "worker_skills", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"worker_profile_id", "skill_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerSkillData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "worker_profile_id", nullable = false)
    private WorkerProfileData workerProfile;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private SkillData skill;

    private Short level;

    @Column(name = "years_experience")
    private Integer yearsExperience;
}
