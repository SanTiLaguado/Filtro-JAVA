package com.sgpzf.personmanage.domain.service;

import java.sql.SQLException;
import java.util.List;

import com.sgpzf.personmanage.domain.entity.Person;

public interface PersonService {

    void checkAndcreatePerson(Person person) throws SQLException;
    void deletePerson(int id) throws SQLException;

    void updatePersonInfoStr(int id, String column, String newValue) throws SQLException;
    void updatePersonInfoInt(int id, String column, int newValue) throws SQLException;

    List<Person> viewPersonBySkill(int id) throws SQLException;
    
}


