package com.sgpzf.personmanage.infrastructure.out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;


import com.sgpzf.infrastructure.config.DatabaseConfig;
import com.sgpzf.personmanage.domain.entity.Person;
import com.sgpzf.personmanage.domain.service.PersonService;
import com.sgpzf.utils.ConsoleUtils;

public class PersonRepository implements PersonService {

    private Connection connection;

    public PersonRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkAndcreatePerson(Person person) throws SQLException {
        String query = "{CALL checkAndInsertPerson(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setInt(1, person.getId());
            cs.setString(2, person.getName());
            cs.setString(3, person.getLastname());
            cs.setInt(4, person.getIdcity());
            cs.setString(5, person.getAddress());
            cs.setInt(6, person.getAge());
            cs.setString(7, person.getEmail());
            cs.setInt(8, person.getIdgender());

            cs.registerOutParameter(9, java.sql.Types.BOOLEAN);
            cs.execute();

            boolean inserted = cs.getBoolean(9);
            if (inserted) {
                ConsoleUtils.clear();
                System.out.println("La persona fue insertada exitosamente.");
            } else {
                ConsoleUtils.clear();
                System.out.println("ERROR! La persona ya existe en la base de datos.");
            }

        } catch (SQLException e) {
        e.printStackTrace();
        throw e;
        }
        
    }

    @Override
    public void updatePersonInfoStr(int id, String column, String newValue) throws SQLException {
        String tableName = "person";
        String dataType = "VARCHAR";
        String query = "{CALL EditColumnidVarAndInt(?, ?, ?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, tableName);
            cs.setString(2, column);
            cs.setString(3, newValue);
            cs.setString(4, dataType);
            cs.setInt(5, id);
            cs.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updatePersonInfoInt(int id, String column, int newValue) throws SQLException {
        String tableName = "person";
        String dataType = "INT";
        String query = "{CALL EditColumnidVarAndInt(?, ?, ?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, tableName);
            cs.setString(2, column);
            cs.setInt(3, newValue);
            cs.setString(4, dataType);
            cs.setInt(5, id);
            cs.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deletePerson(int id) throws SQLException {
        String tableName = "person";
        String query = "{call DeleteById(?, ?, ?)}";
    
        try (CallableStatement cs = connection.prepareCall(query)) {

            cs.setString(1, tableName);
            cs.setInt(2, id);

            cs.registerOutParameter(3, java.sql.Types.BOOLEAN);

            cs.execute();

            boolean deleted = cs.getBoolean(3);

            if (deleted) {
                ConsoleUtils.clear();
                System.out.println("Borrado exitosamente.");
            } else {
                ConsoleUtils.clear();
                System.out.println("ERROR! La persona con ese id, NO está registrada.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    

    @Override
    public List<Person> viewPersonBySkill(int id) throws SQLException {
        String query = "{CALL viewPersonBySkill(?)}";
        List<Person> persons = new ArrayList<>();

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setInt(1, id);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Person person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setName(rs.getString("name"));
                    person.setLastname(rs.getString("lastname"));
                    persons.add(person);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } return persons;
    }

}
