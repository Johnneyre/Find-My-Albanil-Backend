package com.my_find_albanil.demo.domain.models.response.worker_skill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerSkillResponseDTO {
    private Long id;
    private Long workerProfileId;
    private Long skillId;
    private Short level;
    private Integer yearsExperience;
}
