package com.my_find_albanil.demo.infraestructure.driven_adapters.application.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.application.ApplicationData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationDataRepository {
    Optional<ApplicationData> findById(Long id);
    List<ApplicationData> findByJobId(Long jobId);
    List<ApplicationData> findByWorkerProfileId(Long workerProfileId);
    Optional<ApplicationData> findByJobIdAndWorkerProfileId(Long jobId, Long workerProfileId);
    List<ApplicationData> findByStatus(String status);
    ApplicationData save(ApplicationData application);
    void deleteById(Long id);
    List<ApplicationData> findAll();
}
