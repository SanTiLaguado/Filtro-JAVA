package com.sgpzf.personmanage.application;

import java.sql.SQLException;
import java.util.List;

import com.sgpzf.personmanage.domain.entity.Person;
import com.sgpzf.personmanage.domain.service.PersonService;

public class SearchPersonBySkillUseCase {

    private final PersonService personService;

    public SearchPersonBySkillUseCase(PersonService personService) {
        this.personService = personService;
    }

    public List<Person> viewPersonBySkill(int id) throws SQLException {
        List<Person> persons = personService.viewPersonBySkill(id);

        return persons;
    }
}
