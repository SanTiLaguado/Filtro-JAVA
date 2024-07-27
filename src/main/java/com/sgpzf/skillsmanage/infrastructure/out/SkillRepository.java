package com.sgpzf.skillsmanage.infrastructure.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.DocumentType;

import com.sgpzf.infrastructure.config.DatabaseConfig;
import com.sgpzf.skillsmanage.domain.entity.Skill;
import com.sgpzf.skillsmanage.domain.service.SkillService;
import com.sgpzf.utils.ConsoleUtils;

public class SkillRepository implements SkillService{

    private Connection connection;

    public SkillRepository() {
        try {
            this.connection = DatabaseConfig.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createSkill(Skill skill) throws SQLException {
        String query = "{CALL checkAndInsertSkill(?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, skill.getName());
            cs.registerOutParameter(2, java.sql.Types.BOOLEAN);
            cs.execute();

            boolean inserted = cs.getBoolean(2);
            
            if (inserted) {
                ConsoleUtils.clear();
                System.out.println("La Habilidad fue insertada exitosamente.");
            } else {
                ConsoleUtils.clear();
                System.out.println("ERROR! Esa Habilidad ya existe!");
            }

        } catch (SQLException e) {
        e.printStackTrace();
        throw e;
        }
        
    }

    @Override 
    public List<Skill> viewAllSkills() throws SQLException {
        String query = "{CALL showInformationTable(?)}";
        String tableName = "skill";

        List<Skill> allSkills = new ArrayList<>();
        
        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setString(1, tableName);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Skill skill = new Skill();
                    skill.setId(rs.getInt("id"));
                    skill.setName(rs.getString("name"));
                    allSkills.add(skill);
                    
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return allSkills;
    }

    @Override
    public void AssingSkills(int idObj, int idSkill) throws SQLException {
        String query = "{CALL AssignSkills(?, ?, ?)}";

        try (CallableStatement cs = connection.prepareCall(query)) {
            cs.setInt(1, idObj);
            cs.setInt(2, idSkill);
            
            cs.registerOutParameter(3, java.sql.Types.BOOLEAN);

            cs.execute();

            boolean success = cs.getBoolean(3);
            
            if (success) {
                System.out.println("La habilidad fue asignada exitosamente.");
            } else {
                System.out.println("ERROR! La habilidad ya esta asignada a la persona!.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
