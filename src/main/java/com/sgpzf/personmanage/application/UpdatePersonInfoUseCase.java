package com.sgpzf.personmanage.application;

import java.sql.SQLException;

import com.sgpzf.personmanage.domain.service.PersonService;

public class UpdatePersonInfoUseCase {

    private final PersonService personService;

    public UpdatePersonInfoUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void updatePersonInfoStr(int id, String column, String newValue) throws SQLException {
        personService.updatePersonInfoStr(id, column, newValue);
    }

    public void updatePersonInfoInt(int id, String column, int newValue) throws SQLException {
        personService.updatePersonInfoInt(id, column, newValue);
    }
    
}
