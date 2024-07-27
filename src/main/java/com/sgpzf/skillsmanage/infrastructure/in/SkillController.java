package com.sgpzf.skillsmanage.infrastructure.in;

import java.sql.SQLException;
import java.util.List;

import com.sgpzf.skillsmanage.application.AssingSkillsUseCase;
import com.sgpzf.skillsmanage.application.CreateSkillUseCase;
import com.sgpzf.skillsmanage.application.ViewAllSkillsUseCase;
import com.sgpzf.skillsmanage.domain.entity.Skill;
import com.sgpzf.utils.ConsoleUtils;

public class SkillController {

    private CreateSkillUseCase createSkillUseCase;
    private AssingSkillsUseCase assingSkillsUseCase;
    private ViewAllSkillsUseCase viewAllSkillsUseCase;

    public SkillController(CreateSkillUseCase createSkillUseCase, AssingSkillsUseCase assingSkillsUseCase,
            ViewAllSkillsUseCase viewAllSkillsUseCase) {
        this.createSkillUseCase = createSkillUseCase;
        this.assingSkillsUseCase = assingSkillsUseCase;
        this.viewAllSkillsUseCase = viewAllSkillsUseCase;
    }

    public SkillController(ViewAllSkillsUseCase viewAllSkillsUseCase) {
        this.viewAllSkillsUseCase = viewAllSkillsUseCase;
    }


    public void checkAndCreateSkill() throws SQLException {
        ConsoleUtils.clear();
        System.out.println("Ingresa el Nombre:");
        String name = ConsoleUtils.verifyEntryString();

        Skill skill = new Skill(name);
        createSkillUseCase.createSkill(skill);
        ConsoleUtils.waitWindow();
    }

    public List<Skill> viewAllSkills() throws SQLException{
        List<Skill> allSkills = viewAllSkillsUseCase.viewAllSkills();
        ConsoleUtils.clear();
        String border = "+------+--------------------------------+";
        String header = "|  id  |              name              |";

        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);

        for (Skill skill : allSkills) {
            System.out.printf("| %-4d | %-30s |\n",
            skill.getId(), skill.getName());
        }
        System.out.println(border);

        return allSkills;
    }

    public void AssingSkills() throws SQLException{
        ConsoleUtils.clear();
        System.out.println("Ingresa el Numero de Cedula de la Persona:");
        int idObj = ConsoleUtils.verifyingIntNoRange();

        viewAllSkills();
        System.out.println("Selecciona la skill a Asignar: ");
        int idSkill = ConsoleUtils.verifyingIntNoRange();
        assingSkillsUseCase.assingSkillsUseCase(idObj, idSkill);
        ConsoleUtils.waitWindow();

    }
}
