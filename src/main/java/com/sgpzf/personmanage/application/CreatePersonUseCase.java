package com.sgpzf.personmanage.application;

import java.sql.SQLException;

import com.sgpzf.personmanage.domain.entity.Person;
import com.sgpzf.personmanage.domain.service.PersonService;

public class CreatePersonUseCase {

    private final PersonService personService;

    public CreatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void checkAndcreatePerson(Person person) throws SQLException {
        personService.checkAndcreatePerson(person);
    }
}
