package com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.worker_profile.WorkerProfileData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkerProfileDataRepository {
    Optional<WorkerProfileData> findById(Long id);
    Optional<WorkerProfileData> findByUserId(UUID userId);
    List<WorkerProfileData> findByTrade(String trade);
    List<WorkerProfileData> findByAvailability(Boolean availability);
    WorkerProfileData save(WorkerProfileData workerProfile);
    void deleteById(Long id);
    List<WorkerProfileData> findAll();
}
