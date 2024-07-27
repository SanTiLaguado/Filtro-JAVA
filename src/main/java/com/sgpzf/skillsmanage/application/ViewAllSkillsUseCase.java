package com.sgpzf.skillsmanage.application;

import java.sql.SQLException;
import java.util.List;

import com.sgpzf.skillsmanage.domain.entity.Skill;
import com.sgpzf.skillsmanage.domain.service.SkillService;

public class ViewAllSkillsUseCase {

    private final SkillService skillService;

    public ViewAllSkillsUseCase(SkillService skillService) {
        this.skillService = skillService;
    }

    public List<Skill> viewAllSkills() throws SQLException {
        List<Skill> allSkills = skillService.viewAllSkills();
        return allSkills;
    }
}
