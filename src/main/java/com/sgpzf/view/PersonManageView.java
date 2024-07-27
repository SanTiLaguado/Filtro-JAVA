package com.sgpzf.view;

import java.sql.SQLException;

import com.sgpzf.personmanage.application.CreatePersonUseCase;
import com.sgpzf.personmanage.application.DeletePersonUseCase;
import com.sgpzf.personmanage.application.SearchPersonBySkillUseCase;
import com.sgpzf.personmanage.application.UpdatePersonInfoUseCase;
import com.sgpzf.personmanage.domain.service.PersonService;
import com.sgpzf.personmanage.infrastructure.in.PersonController;
import com.sgpzf.personmanage.infrastructure.out.PersonRepository;
import com.sgpzf.skillsmanage.application.ViewAllSkillsUseCase;
import com.sgpzf.skillsmanage.domain.service.SkillService;
import com.sgpzf.skillsmanage.infrastructure.in.SkillController;
import com.sgpzf.skillsmanage.infrastructure.out.SkillRepository;
import com.sgpzf.utils.ConsoleUtils;

public class PersonManageView {

    public void showmenu() throws SQLException {
        //services
        PersonService ps = new PersonRepository();
        SkillService ss = new SkillRepository();
        
        //use cases
        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(ps);
        UpdatePersonInfoUseCase updatePersonUseCase = new UpdatePersonInfoUseCase(ps);
        DeletePersonUseCase deletePersonUseCase = new DeletePersonUseCase(ps);
        ViewAllSkillsUseCase viewAllSkillsUseCase = new ViewAllSkillsUseCase(ss);
        SearchPersonBySkillUseCase searchPersonBySkillUseCase = new SearchPersonBySkillUseCase(ps);

        //controllers
        SkillController skillController = new SkillController(viewAllSkillsUseCase);
        PersonController personController = new PersonController(createPersonUseCase, updatePersonUseCase, deletePersonUseCase, searchPersonBySkillUseCase, skillController);

        do {

            ConsoleUtils.clear();
            System.out.println("---------------------------------------\n" +
            "         Gestion de Personas          \n" +
            "        Selecciona una Opcion         \n" +
            "---------------------------------------\n" +
            "\n" +
            "1. Registrar Personas \n" +
            "2. Actualizar Informacion de Personas \n" +
            "3. Buscar Personas por Habilidad \n" +
            "4. Eliminar Personas \n" +
            "5. Volver\n"
            );

            int op = ConsoleUtils.verifyEntryInt(1, 5);


            switch (op) {
                case 1:          
                    personController.checkAndcreatePerson();
                    break;
                case 2:
                    personController.updatePersonInfo();
                    break;
                case 3:
                    personController.searchPersonBySkill();
                    break;
                case 4:
                    personController.deletePerson();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        } while (true);
    }
}

