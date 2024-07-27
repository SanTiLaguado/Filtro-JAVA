package com.sgpzf.personmanage.application;

import java.sql.SQLException;

import com.sgpzf.personmanage.domain.service.PersonService;

public class DeletePersonUseCase {

    private final PersonService personService;

    public DeletePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void deletePerson(int id) throws SQLException {
        personService.deletePerson(id);
    }
}
