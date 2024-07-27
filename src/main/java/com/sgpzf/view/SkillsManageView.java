package com.sgpzf.view;

import java.sql.SQLException;

import com.sgpzf.skillsmanage.application.AssingSkillsUseCase;
import com.sgpzf.skillsmanage.application.CreateSkillUseCase;
import com.sgpzf.skillsmanage.application.ViewAllSkillsUseCase;
import com.sgpzf.skillsmanage.domain.service.SkillService;
import com.sgpzf.skillsmanage.infrastructure.in.SkillController;
import com.sgpzf.skillsmanage.infrastructure.out.SkillRepository;
import com.sgpzf.utils.ConsoleUtils;

public class SkillsManageView {

        public void showmenu() throws SQLException {
        //services
            SkillService skillService = new SkillRepository();

        //use cases
            CreateSkillUseCase createSkillUseCase = new CreateSkillUseCase(skillService);
            AssingSkillsUseCase assingSkillsUseCase = new AssingSkillsUseCase(skillService);
            ViewAllSkillsUseCase viewAllSkillsUseCase = new ViewAllSkillsUseCase(skillService);

        //controllers

            SkillController skillController = new SkillController(createSkillUseCase, assingSkillsUseCase, viewAllSkillsUseCase);
            
        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "       Gestion de Habilidades          \n" +
            "        Selecciona una Opcion         \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Crear Habilidad \n" +
            "2. Asignar Habilidades a Personas \n" +
            "3. Volver\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 3);


            switch (op) {
                case 1:
                    skillController.checkAndCreateSkill();
                    break;
                case 2:
                    skillController.AssingSkills();
                    break;
                case 3:
                    return;
                default:
                    return;
            }
        } while (true);
    }
}
