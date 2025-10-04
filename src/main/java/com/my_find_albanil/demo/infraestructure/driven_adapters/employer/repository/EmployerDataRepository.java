package com.my_find_albanil.demo.infraestructure.driven_adapters.employer.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.employer.EmployerData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployerDataRepository {
    Optional<EmployerData> findById(Long id);
    Optional<EmployerData> findByUserId(UUID userId);
    List<EmployerData> findByCompanyName(String companyName);
    EmployerData save(EmployerData employer);
    void deleteById(Long id);
    List<EmployerData> findAll();
}
