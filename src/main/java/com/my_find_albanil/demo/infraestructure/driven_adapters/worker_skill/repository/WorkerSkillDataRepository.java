package com.my_find_albanil.demo.infraestructure.driven_adapters.worker_skill.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_skill.WorkerSkillData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerSkillDataRepository extends JpaRepository<WorkerSkillData, Long> {
    @Query("SELECT ws FROM WorkerSkillData ws WHERE ws.workerProfile.id = :workerProfileId")
    List<WorkerSkillData> findByWorkerProfileId(Long workerProfileId);
    
    @Query("SELECT ws FROM WorkerSkillData ws WHERE ws.skill.id = :skillId")
    List<WorkerSkillData> findBySkillId(Long skillId);
    
    @Query("SELECT ws FROM WorkerSkillData ws WHERE ws.workerProfile.id = :workerProfileId AND ws.skill.id = :skillId")
    Optional<WorkerSkillData> findByWorkerProfileIdAndSkillId(Long workerProfileId, Long skillId);
}
