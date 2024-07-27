package com.sgpzf.skillsmanage.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.sgpzf.skillsmanage.domain.entity.Skill;

public interface SkillService {

    void createSkill(Skill skill) throws SQLException;   
    List<Skill> viewAllSkills() throws SQLException;
    void AssingSkills(int idObj, int idSkill) throws SQLException;
    
}
