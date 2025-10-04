package com.my_find_albanil.demo.infraestructure.driven_adapters.skill.repository;

import com.my_find_albanil.demo.infraestructure.driven_adapters.skill.SkillData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillDataRepository {
    Optional<SkillData> findById(Long id);
    Optional<SkillData> findByName(String name);
    SkillData save(SkillData skill);
    void deleteById(Long id);
    List<SkillData> findAll();
    boolean existsByName(String name);
}
