package com.sgpzf.view;

import java.sql.SQLException;

import com.sgpzf.utils.ConsoleUtils;

public class MainView {

    public void Start() throws SQLException {

        ConsoleUtils.clear();
        System.out.println("--------------------------------------\n" +
        "          Bienvenido a sgpzf!         \n" +
        "        Selecciona una Opcion:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Gestionar Personas\n" +
        "2. Gestionar Habilidades\n" +
        "3. Exit\n"
        );

        int op = ConsoleUtils.verifyEntryInt(1, 3);
        System.out.println("Loading...");
        
        switch (op) {
            case 1:
                PersonManageView personMngView = new PersonManageView();
                personMngView.showmenu();
                break;
            case 2:
                SkillsManageView skillsMngView = new SkillsManageView();
                skillsMngView.showmenu();
                break;
            case 3:
                System.out.println("Bye!");
                break;
            default:
                break;
        }
    }
}
