DROP DATABASE IF EXISTS sgpzf;
CREATE DATABASE sgpzf;

USE sgpzf;

CREATE TABLE sgpzf.stack (
id INT auto_increment,
name VARCHAR(50),
CONSTRAINT Pk_stack_id PRIMARY KEY(id)
);

CREATE TABLE sgpzf.skill (
id INT auto_increment,
name VARCHAR(50),
CONSTRAINT Pk_skill_id PRIMARY KEY(id)
);

CREATE TABLE sgpzf.stack_skill (
idskill INT,
idstack INT,
CONSTRAINT Pk_StackSkill_Id PRIMARY KEY (idskill, idstack),
CONSTRAINT FK_skillstack_skill_Id FOREIGN KEY (idskill) REFERENCES sgpzf.skill(id),
CONSTRAINT FK_skillstack_stack_Id FOREIGN KEY (idstack) REFERENCES sgpzf.stack(id)
);

CREATE TABLE sgpzf.gender (
id INT auto_increment,
name VARCHAR(50),
CONSTRAINT Pk_gender_id PRIMARY KEY(id)
);

CREATE TABLE sgpzf.country (
id INT auto_increment,
name VARCHAR(50),
CONSTRAINT Pk_country_id PRIMARY KEY(id)
);

CREATE TABLE sgpzf.region (
id INT auto_increment,
name VARCHAR(50),
idcountry INT,
CONSTRAINT Pk_region_id PRIMARY KEY(id),
CONSTRAINT FK_region_country_id FOREIGN KEY (idcountry) REFERENCES sgpzf.country(id)
);

CREATE TABLE sgpzf.city (
id INT auto_increment,
name VARCHAR(50),
idregion INT,
CONSTRAINT Pk_city_id PRIMARY KEY(id),
CONSTRAINT FK_city_region_id FOREIGN KEY (idregion) REFERENCES sgpzf.region(id)
);

CREATE TABLE sgpzf.person (
id INT,
name VARCHAR(50),
lastname VARCHAR(50),
idcity INT,
address VARCHAR(50),
age INT,
email VARCHAR(100),
idgender INT,
CONSTRAINT Pk_person_id PRIMARY KEY(id),
CONSTRAINT Fk_person_city_id FOREIGN KEY (idcity) REFERENCES sgpzf.city(id),
CONSTRAINT Fk_person_gender_id FOREIGN KEY (idgender) REFERENCES sgpzf.gender(id)
);

CREATE TABLE sgpzf.person_skill (
id INT AUTO_INCREMENT,
registration_date DATE,
idperson INT,
idskill INT,
CONSTRAINT Pk_regperson_skill_id PRIMARY KEY(id),
CONSTRAINT FK_personskill_person_id FOREIGN KEY (idperson) REFERENCES sgpzf.person(id),
CONSTRAINT FK_personskill_skill_Id FOREIGN KEY (idskill) REFERENCES sgpzf.skill(id)
);









