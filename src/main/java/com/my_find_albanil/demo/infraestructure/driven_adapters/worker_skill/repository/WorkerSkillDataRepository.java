package com.my_find_albanil.demo.infraestructure.driven_adapters.worker_skill.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_skill.WorkerSkillData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerSkillDataRepository {
    Optional<WorkerSkillData> findById(Long id);
    List<WorkerSkillData> findByWorkerProfileId(Long workerProfileId);
    List<WorkerSkillData> findBySkillId(Long skillId);
    Optional<WorkerSkillData> findByWorkerProfileIdAndSkillId(Long workerProfileId, Long skillId);
    WorkerSkillData save(WorkerSkillData workerSkill);
    void deleteById(Long id);
    List<WorkerSkillData> findAll();
}
