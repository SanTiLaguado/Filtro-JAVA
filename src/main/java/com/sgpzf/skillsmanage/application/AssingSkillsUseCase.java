package com.sgpzf.skillsmanage.application;

import java.sql.SQLException;

import com.sgpzf.skillsmanage.domain.service.SkillService;

public class AssingSkillsUseCase {

    private final SkillService skillService;

    public AssingSkillsUseCase(SkillService skillService) {
        this.skillService = skillService;
    }

    public void assingSkillsUseCase(int idObj, int idskill) throws SQLException {
        skillService.AssingSkills(idObj, idskill);
    }
}
