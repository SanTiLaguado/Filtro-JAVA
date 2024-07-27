package com.sgpzf.skillsmanage.application;

import java.sql.SQLException;

import com.sgpzf.skillsmanage.domain.entity.Skill;
import com.sgpzf.skillsmanage.domain.service.SkillService;

public class CreateSkillUseCase {

    private final SkillService skillService;

    public CreateSkillUseCase(SkillService skillService) {
        this.skillService = skillService;
    }

    public void createSkill(Skill skill) throws SQLException {
        skillService.createSkill(skill);
    }
    
}
