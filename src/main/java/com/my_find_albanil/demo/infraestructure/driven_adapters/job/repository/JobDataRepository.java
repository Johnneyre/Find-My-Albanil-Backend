package com.my_find_albanil.demo.infraestructure.driven_adapters.job.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.job.JobData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobDataRepository {
    Optional<JobData> findById(Long id);
    List<JobData> findByEmployerId(Long employerId);
    List<JobData> findByStatus(String status);
    List<JobData> findByLocation(String location);
    JobData save(JobData job);
    void deleteById(Long id);
    List<JobData> findAll();
}
