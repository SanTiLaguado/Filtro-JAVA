package com.sgpzf.personmanage.infrastructure.in;

import java.sql.SQLException;
import java.util.List;

import com.sgpzf.personmanage.application.CreatePersonUseCase;
import com.sgpzf.personmanage.application.DeletePersonUseCase;
import com.sgpzf.personmanage.application.SearchPersonBySkillUseCase;
import com.sgpzf.personmanage.application.UpdatePersonInfoUseCase;
import com.sgpzf.personmanage.domain.entity.Person;
import com.sgpzf.skillsmanage.domain.entity.Skill;
import com.sgpzf.skillsmanage.infrastructure.in.SkillController;
import com.sgpzf.utils.ConsoleUtils;

public class PersonController {

    private CreatePersonUseCase createPersonUseCase;
    private UpdatePersonInfoUseCase updatePersonInfoUseCase;
    private DeletePersonUseCase deletePersonUseCase;
    private SearchPersonBySkillUseCase searchPersonBySkillUseCase;
    private SkillController skillController;


    public PersonController(CreatePersonUseCase createPersonUseCase, UpdatePersonInfoUseCase updatePersonInfoUseCase,
            DeletePersonUseCase deletePersonUseCase, SearchPersonBySkillUseCase searchPersonBySkillUseCase,
            SkillController skillController) {
        this.createPersonUseCase = createPersonUseCase;
        this.updatePersonInfoUseCase = updatePersonInfoUseCase;
        this.deletePersonUseCase = deletePersonUseCase;
        this.searchPersonBySkillUseCase = searchPersonBySkillUseCase;
        this.skillController = skillController;
    }


    public void checkAndcreatePerson() throws SQLException {
        ConsoleUtils.clear();
        System.out.println("Ingresa el Nombre:");
        String name = ConsoleUtils.verifyEntryString(); 

        System.out.println("Ingresa el Apellido:");
        String lastname = ConsoleUtils.verifyEntryString(); 

        System.out.println("Selecciona el Genero:");
        int gender = ConsoleUtils.verifyingIntNoRange(); // VALIDAR

        System.out.println("Ingresa el Numero de Cedula:");
        int id = ConsoleUtils.verifyingIntNoRange(); // VALIDAR

        System.out.println("Ingresa la Edad:");
        int age = ConsoleUtils.verifyEntryInt(1, 100);

        System.out.println("Ingresa el Correo Electronico:");
        String email = ConsoleUtils.verifyEntryString(); 

        System.out.println("Selecciona la ciudad:");
        int city = ConsoleUtils.verifyingIntNoRange(); // VALIDAR

        System.out.println("Ingresa la Direccion:");
        String address = ConsoleUtils.verifyEntryString();

        Person person = new Person(id, name, lastname, city, address, age, email, gender);
        createPersonUseCase.checkAndcreatePerson(person);
        ConsoleUtils.waitWindow();
    }


    public void updatePersonInfo() throws SQLException {
        String column;
        ConsoleUtils.clear();
        System.out.println("Ingresa el Numero de Cedula:");
        int id = ConsoleUtils.verifyingIntNoRange();

        // MOSTRAR TODA LA INFO DE LA PERSONA INGRESADA
        ConsoleUtils.clear();
        System.out.println("--------------------------------------\n" +
        "       Please select an option:       \n" +
        "--------------------------------------\n" +
        "\n" +
        "1. Actualizar Nombre\n" +
        "2. Actualizar Apellido\n" +
        "3. Actualizar Edad\n" +
        "4. Actualizar Genero\n" +
        "5. Actualizar Ciudad\n" +
        "6. Actualizar Direccion\n" +
        "7. Actualizar Correo Electronico\n" +
        "8. Go back"
        );

        
        int op = ConsoleUtils.verifyEntryInt(1, 8);

        switch (op) {
            case 1:
                ConsoleUtils.clear();
                System.out.println("Ingresa el nuevo nombre: ");
                String newName = ConsoleUtils.verifyEntryString();
                column = "name";
                updatePersonInfoUseCase.updatePersonInfoStr(id, column, newName);
                break;
            case 2:
                ConsoleUtils.clear();
                System.out.println("Ingresa el nuevo Apellido: ");
                String newLName = ConsoleUtils.verifyEntryString();
                column = "lastname";
                updatePersonInfoUseCase.updatePersonInfoStr(id, column, newLName);
                break;
            case 3:
                ConsoleUtils.clear();
                System.out.println("Ingresa la nueva Edad: ");
                int newAge = ConsoleUtils.verifyingIntNoRange();
                column = "age";
                updatePersonInfoUseCase.updatePersonInfoInt(id, column, newAge);
                break;
            case 4:
                ConsoleUtils.clear();
                System.out.println("Selecciona el nuevo Genero: ");
                int newGender = ConsoleUtils.verifyingIntNoRange();
                column = "idgender";
                updatePersonInfoUseCase.updatePersonInfoInt(id, column, newGender);
                break;
            case 5:
                ConsoleUtils.clear();
                System.out.println("Selecciona la nueva Ciudad: ");
                int newCity = ConsoleUtils.verifyingIntNoRange();
                column = "idcity";
                updatePersonInfoUseCase.updatePersonInfoInt(id, column, newCity);
                break;
            case 6:
                ConsoleUtils.clear();
                System.out.println("Ingresa la nueva Direccion: ");
                String newAddress = ConsoleUtils.verifyEntryString();
                column = "address";
                updatePersonInfoUseCase.updatePersonInfoStr(id, column, newAddress);
                break;
            case 7:
                ConsoleUtils.clear();
                System.out.println("Ingresa el nuevo Correo Electronico: ");
                String newEmail = ConsoleUtils.verifyEntryString();
                column = "email";
                updatePersonInfoUseCase.updatePersonInfoStr(id, column, newEmail);
                break;
            case 8:
                return;
            default:
                break;
        }
    }

    public void searchPersonBySkill() throws SQLException {
        ConsoleUtils.clear();
        skillController.viewAllSkills();
    
        System.out.println("Selecciona una Skill para buscar:");
        int id = ConsoleUtils.verifyingIntNoRange();

        List<Person> persons = searchPersonBySkillUseCase.viewPersonBySkill(id);
    
        String border = "+------------+----------------------+-----------------+";
        String header = "|     id     |       Nombre         |     Apellido    |";
    
        ConsoleUtils.clear();
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
    
        for (Person person : persons) {
            System.out.printf("| %-10d | %-20s | %-15s |\n",
                              person.getId(), person.getName(), person.getLastname());
        }
        System.out.println(border);

        ConsoleUtils.waitWindow();
    }
    

    public void deletePerson() throws SQLException {
        ConsoleUtils.clear();
        System.out.println("Ingresa el Numero de Cedula:");

        int id = ConsoleUtils.verifyingIntNoRange();

        System.out.println("Are you Sure?\n" +
        "1. NO\n" +
        "2. YES\n");
        int conf = ConsoleUtils.verifyEntryInt(1, 2);
        if (conf == 2) {

            System.out.println("Verificando...");
            deletePersonUseCase.deletePerson(id);
        } else {
            System.out.println("Eliminacion Cancelada");
        }
        ConsoleUtils.waitWindow();


    }




}
