DELIMITER $$

DROP PROCEDURE IF EXISTS checkAndInsertPerson$$
CREATE PROCEDURE checkAndInsertPerson(
    IN p_id INT,
    IN p_name VARCHAR(50),
    IN p_lastname VARCHAR(50),
    IN p_idcity INT,
    IN p_address VARCHAR(50),
    IN p_age INT,
    IN p_email VARCHAR(100),
    IN p_idgender INT,
    OUT p_inserted BOOLEAN
)
BEGIN
    DECLARE personExists INT;

    SET p_inserted = FALSE;

    SELECT COUNT(*) INTO personExists
    FROM person
    WHERE id = p_id;

    IF personExists = 0 THEN

        INSERT INTO person (id, name, lastname, idcity, address, age, email, idgender)
        VALUES (p_id, p_name, p_lastname, p_idcity, p_address, p_age, p_email, p_idgender);

        SET p_inserted = TRUE;
    END IF;
END$$

DELIMITER ;

SELECT * FROM person;



DELIMITER $$

CREATE PROCEDURE EditColumnidVarAndInt(
    IN p_table_name VARCHAR(64),
    IN p_column_name VARCHAR(64),
    IN p_new_value VARCHAR(255),
    IN p_data_type VARCHAR(20),
    IN p_object_id VARCHAR(30)
)
BEGIN
    DECLARE sql_query VARCHAR(1000);

    SET @table_name = p_table_name;
    SET @column_name = p_column_name;
    SET @new_value = p_new_value;
    SET @object_id = p_object_id;
    
    SET @query = CONCAT('UPDATE ', @table_name, ' SET ', @column_name, ' = ');
    
    IF p_data_type = 'INT' THEN
        SET @query = CONCAT(@query, 'CAST(? AS SIGNED)');
    ELSE
        SET @query = CONCAT(@query, '?');
    END IF;
    
    SET @query = CONCAT(@query, ' WHERE id = ?');
    
    PREPARE stmt FROM @query;
    EXECUTE stmt USING @new_value, @object_id;
    DEALLOCATE PREPARE stmt;
    
    SELECT 1;
END $$
DELIMITER ;

USE sgpzf;
SELECT * FROM person;

DELIMITER $$

CREATE PROCEDURE showInformationTable(
    IN table_name VARCHAR(30)
)
BEGIN
    SET @query = CONCAT('SELECT * FROM ', table_name);
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;



DELIMITER $$
DROP PROCEDURE IF EXISTS checkAndInsertSkill$$
CREATE PROCEDURE checkAndInsertSkill(
    IN s_name VARCHAR(50),
    OUT wasInserted BOOLEAN
)
BEGIN
    DECLARE skillExists INT;

    SET wasInserted = FALSE;

    SELECT COUNT(*) INTO skillExists
    FROM skill
    WHERE name = s_name;

    IF skillExists = 0 THEN
        INSERT INTO skill (name)
        VALUES (s_name);

        SET wasInserted = TRUE;
    END IF;
END$$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS viewPersonBySkill $$
CREATE PROCEDURE viewPersonBySkill(
	IN in_idskill INT
)
BEGIN
    SELECT p.id,
           p.name,
           p.lastname
    FROM person p
    JOIN person_skill ps ON p.id = ps.idperson
    WHERE ps.idskill = in_idskill;
    
END $$

DELIMITER ;



DELIMITER $$

DROP PROCEDURE IF EXISTS AssignSkills$$
CREATE PROCEDURE AssignSkills(
    IN object_id INT,
    IN skill_id INT,
    OUT success BOOLEAN
)
BEGIN
    DECLARE idexists INT;
    
    SET success = FALSE;
    
    SELECT COUNT(*) INTO idexists
    FROM person_skill
    WHERE idperson = object_id AND idskill = skill_id;

    IF idexists = 0 THEN
        INSERT INTO person_skill (registration_date, idperson, idskill)
        VALUES (CURDATE(), object_id, skill_id);
        
        SET success = TRUE;
    END IF;
END $$

DELIMITER ;


DELIMITER $$
DROP PROCEDURE IF EXISTS DeleteById$$
CREATE PROCEDURE DeleteById(
    IN table_name VARCHAR(64),
    IN object_id INT,
    OUT wasDeleted BOOLEAN
)
BEGIN
    DECLARE idexists INT;
    DECLARE check_query VARCHAR(255);
    DECLARE delete_query VARCHAR(255);

    SET wasDeleted = FALSE;

    SET check_query = CONCAT('SELECT COUNT(*) INTO @idexists FROM ', table_name, ' WHERE id = ', object_id);

    SET @query = check_query;
    PREPARE stmt_check FROM @query;
    EXECUTE stmt_check;
    DEALLOCATE PREPARE stmt_check;

    SELECT @idexists INTO idexists;


    IF idexists = 1 THEN
        SET delete_query = CONCAT('DELETE FROM person_skill WHERE idperson = ', object_id);
        
        SET @query = delete_query;
        PREPARE stmt_delete_dependent FROM @query;
        EXECUTE stmt_delete_dependent;
        DEALLOCATE PREPARE stmt_delete_dependent;

        SET delete_query = CONCAT('DELETE FROM ', table_name, ' WHERE id = ', object_id);
        
        SET @query = delete_query;
        PREPARE stmt_delete FROM @query;
        EXECUTE stmt_delete;
        DEALLOCATE PREPARE stmt_delete;
        
        SET wasDeleted = TRUE;
    END IF;
END $$

DELIMITER ;

