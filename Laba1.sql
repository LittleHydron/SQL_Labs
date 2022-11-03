use GYM_Database;

DROP TABLE IF EXISTS program_contains;
DROP TABLE IF EXISTS set_of_exercises;
DROP TABLE IF EXISTS trainer_works_in;
DROP TABLE IF EXISTS trainee;
DROP TABLE IF EXISTS trainer;
DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS program;
DROP TABLE IF EXISTS simulator;
DROP TABLE IF EXISTS gym;
DROP TABLE IF EXISTS simulatorLog;

DROP PROCEDURE IF EXISTS CallMaxSalary;
DROP PROCEDURE IF EXISTS InsertIntoSimulator;
DROP PROCEDURE IF EXISTS InsertLinesToSimulator;
DROP PROCEDURE IF EXISTS InsertNamesIntoTrainerWorksIn;
DROP PROCEDURE IF EXISTS ProcCursor;

DROP FUNCTION IF EXISTS GetMaxSalary;

CREATE TABLE gym(
	id int NOT NULL auto_increment,
    name varchar(45) NOT NULL,
    date_of_creation date NOT NULL,
    address varchar(45) NOT NULL,
    CONSTRAINT gym_pk PRIMARY KEY (id)
);

CREATE TABLE trainer_works_in(
	id int NOT NULL auto_increment,
	trainer_id int NOT NULL,
    trainer_name varchar(50),
    gym_id int NOT NULL,
    gym_name varchar(50),
    CONSTRAINT trainer_works_in_pk PRIMARY KEY (id)
);

CREATE TABLE program_contains (
	id int NOT NULL auto_increment,
    exercise_id int  NOT NULL,
    program_id int  NOT NULL,
    CONSTRAINT program_contains_pk PRIMARY KEY (id)
);

-- Table: exercise
CREATE TABLE exercise (
    id int  NOT NULL auto_increment,
    name varchar(50)  NOT NULL,
    number_of_reps int  NULL,
    distance_in_meters real  NULL,
    duration_in_min int  NULL,
    simulator_id int NOT NULL,
    CONSTRAINT exercise_pk PRIMARY KEY (id)
);

-- Table: program
CREATE TABLE program (
    id int  NOT NULL auto_increment,
    name varchar(50)  NOT NULL,
    difficulty_level int  NOT NULL,
    CONSTRAINT program_pk PRIMARY KEY (id)
);

-- Table: set_of_exercises
CREATE TABLE set_of_exercises (
    id int  NOT NULL auto_increment,
    program_id int  NOT NULL,
    trainer_id int  NOT NULL,
    trainee_id int  NOT NULL,
    date_of_start date  NOT NULL,
    date_of_end date  NOT NULL,
    CONSTRAINT set_of_exercises_pk PRIMARY KEY (id)
);

-- Table: trainee
CREATE TABLE trainee (
    id int  NOT NULL auto_increment,
    name varchar(50)  NOT NULL,
    date_of_registration date  NOT NULL,
    telephone_number varchar(10)  NOT NULL,
    trainer_id int  NOT NULL,
    CONSTRAINT trainee_pk PRIMARY KEY (id)
);

-- Table: trainer
CREATE TABLE trainer (
    id int  NOT NULL auto_increment,
    name varchar(50)  NOT NULL,
    date_of_registration date  NOT NULL,
    salary_in_dollars real  NOT NULL,
    CONSTRAINT trainer_pk PRIMARY KEY (id)
);

-- Table: simulator
CREATE TABLE simulator(
	id int NOT NULL auto_increment,
    name varchar(50) NOT NULL,
    CONSTRAINT simulator_pk PRIMARY KEY (id)
);

-- Table: simulatorLog
CREATE TABLE simulatorLog(
	id int not null auto_increment primary key,
    action varchar(6) NOT NULL,
    dateTime datetime NOT NULL
);

-- foreign keys
-- Reference: program_contains_exercise (table: program_contains)
ALTER TABLE program_contains ADD CONSTRAINT program_contains_exercise
    FOREIGN KEY (exercise_id)
    REFERENCES exercise (id)
    ON DELETE CASCADE
;

-- Reference: program_contains_program (table: program_contains)
ALTER TABLE program_contains ADD CONSTRAINT program_contains_program
    FOREIGN KEY (program_id)
    REFERENCES program (id)
    ON DELETE CASCADE
;

ALTER TABLE trainer_works_in ADD CONSTRAINT trainer_works_in_trainer
    FOREIGN KEY (trainer_id)
    REFERENCES trainer (id)
    ON DELETE CASCADE
;

ALTER TABLE trainer_works_in ADD CONSTRAINT trainer_works_in_gym
    FOREIGN KEY (gym_id)
    REFERENCES gym (id)
    ON DELETE CASCADE
;


-- Reference: Set_program (table: set_of_exercises)
ALTER TABLE set_of_exercises ADD CONSTRAINT Set_program
    FOREIGN KEY (program_id)
    REFERENCES program (id)
    ON DELETE CASCADE
;

-- Reference: Set_trainee (table: set_of_exercises)
ALTER TABLE set_of_exercises ADD CONSTRAINT Set_trainee
    FOREIGN KEY (trainee_id)
    REFERENCES trainee (id)
    ON DELETE CASCADE
;

-- Reference: Set_trainer (table: set_of_exercises)
ALTER TABLE set_of_exercises ADD CONSTRAINT Set_trainer
    FOREIGN KEY (trainer_id)
    REFERENCES trainer (id)
    ON DELETE CASCADE
;

-- Reference: trainee_trainer (table: trainee)
ALTER TABLE trainee ADD CONSTRAINT trainee_trainer
    FOREIGN KEY (trainer_id)
    REFERENCES trainer (id)
    ON DELETE CASCADE
;

CREATE INDEX trainer_name_idx
ON trainer(name);

CREATE INDEX trainer_date_idx
ON trainer(date_of_registration);

CREATE INDEX gym_name_idx
ON gym(name);

CREATE INDEX gym_date_idx
ON gym(date_of_creation);

CREATE INDEX gym_address_idx
ON gym(address);

CREATE INDEX program_difficulty_idx
ON program(difficulty_level);

CREATE INDEX trainee_name_idx
ON trainee(name);

CREATE INDEX trainee_date_idx
ON trainee(date_of_registration);

CREATE INDEX trainee_trainer_idx
ON trainee(trainer_id);

CREATE INDEX exercise_name_idx
ON exercise(name);

-- Insertions:

-- Table trainer:
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Valera", '2002-01-01', 12
);
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Sasha", '2001-02-01', 120
);
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Andriy", '1991-02-01', 1120
);
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Illia", '2004-02-01', 1999991
);
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Lera", '2003-08-02', 101932
);
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Clown", '1981-01-01', 1
);
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Zenyk", '2019-01-12', 69
);
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Marichka", '2020-12-01', 0
);
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Voos", '2019-04-18', 1999991
);
insert into trainer(name, date_of_registration, salary_in_dollars)
values(
	"Anton", '1945-01-01', 10921
);

-- Table trainee

insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Anton", '1945-01-01', "0979897971", 4
);
insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Clown", '2000-05-02', "1234567890", 3
);
insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Booka", '1945-04-10', "0987654321", 1
);
insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Chrome", '1900-02-01', "0979897971", 10
);
insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Sasha", '1845-01-01', "0979897971", 9
);
insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Illia", '2018-09-11', "0979897971", 2
);
insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Kokojamba", '2020-11-11', "0979897971", 8
);
insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Krokodyl", '2000-12-12', "0979897971", 3
);
insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Aboba", '1948-08-15', "0979897971", 5
);
insert into trainee(name, date_of_registration, telephone_number, trainer_id)
values(
	"Vovan", '2024-12-12', "0979897971", 5
);

-- Table simulator:

insert into simulator(name)
values
	("gogol"),
    ("hipster"),
    ("kokojamba")
;

-- Table exercise:
insert into exercise(name, number_of_reps, distance_in_meters, duration_in_min, simulator_id)
values(
	"Dips", 1, null, null, 1
),(
	"Dips", 15, null, null, 2
),(
	"Pull-Ups", 15, null, null, 2
),(
	"Running", null, 1000, null, 3
),(
	"Running", null, null, 1, 2
),(
	"Leg-Rises", 127, null, null, 1
),(
	"Jumps", 150, null, 15, 3
),(
	"Twerk", null, null, 888, 1
),(
	"Push-Ups", 105, null, null, 2
),(
	"Kokojamba", 15, 10, 17, 4
);

-- Table program

insert into program(name, difficulty_level)
values(
	"Monster", 100000
);
insert into program(name, difficulty_level)
values(
	"Child", 1000
);
insert into program(name, difficulty_level)
values(
	"Parent", 9999
);
insert into program(name, difficulty_level)
values(
	"Kokojamba", 12
);
insert into program(name, difficulty_level)
values(
	"Cockroach", 8996
);
insert into program(name, difficulty_level)
values(
	"Krokodyl", 19
);
insert into program(name, difficulty_level)
values(
	"Denys", 80
);
insert into program(name, difficulty_level)
values(
	"Bebra", 189
);
insert into program(name, difficulty_level)
values(
	"Mom", 17
);
insert into program(name, difficulty_level)
values(
	"Mobster", 167
);

-- Table program_contains
insert into program_contains(exercise_id, program_id)
values(
	1, 1
);insert into program_contains(exercise_id, program_id)
values(
	2, 1
);insert into program_contains(exercise_id, program_id)
values(
	3, 2
);insert into program_contains(exercise_id, program_id)
values(
	10, 1
);insert into program_contains(exercise_id, program_id)
values(
	3, 2
);insert into program_contains(exercise_id, program_id)
values(
	2, 2
);insert into program_contains(exercise_id, program_id)
values(
	6, 6
);insert into program_contains(exercise_id, program_id)
values(
	10, 6
);insert into program_contains(exercise_id, program_id)
values(
	10, 10
);insert into program_contains(exercise_id, program_id)
values(
	3, 7
);

-- Table set_of_exercises:
insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	1, 1, 1, '2019-01-01', '2020-01-01'
);
insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	1, 2, 3, '2010-01-01', '2030-01-01'
);insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	10, 1, 7, '2011-11-01', '2020-01-01'
);insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	10, 10, 10, '2029-01-01', '2050-01-01'
);insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	1, 1, 1, '2019-01-01', '2020-01-01'
);insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	1, 10, 8, '2019-08-10', '2023-10-01'
);insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	7, 9, 9, '2019-11-11', '2021-01-01'
);insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	10, 7, 3, '2008-10-11', '2020-01-01'
);insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	6, 8, 10, '2019-01-01', '2020-01-01'
);insert into set_of_exercises(program_id, trainer_id, trainee_id, date_of_start, date_of_end)
values(
	5, 4, 3, '2015-11-01', '2021-01-11'
);

insert into gym(name, date_of_creation, address)
values(
	"Vasyl", "1212-12-12", "aboba"
);insert into gym(name, date_of_creation, address)
values(
	"Adrenaline", "1223-12-12", "ameoba"
);

insert into trainer_works_in(gym_id, trainer_id)
values(
	1, 2
);insert into trainer_works_in(gym_id, trainer_id)
values(
	2, 9
);insert into trainer_works_in(gym_id, trainer_id)
values(
	1, 10
);insert into trainer_works_in(gym_id, trainer_id)
values(
	1, 9
);

-- Triggers:

DELIMITER //
CREATE TRIGGER BeforeCreateExercise
BEFORE INSERT
ON exercise FOR EACH ROW
BEGIN
	IF (SELECT name FROM simulator WHERE id=new.simulator_id) IS NULL
    THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid simulator ID';
	END IF;
END //

CREATE TRIGGER AfterDeleteSimulator
AFTER DELETE
ON simulator FOR EACH ROW
BEGIN
	DELETE FROM exercise WHERE exercise.simulator_id=old.id;
END //

CREATE TRIGGER BeforeUpdateExercise
BEFORE UPDATE
ON exercise FOR EACH ROW
BEGIN
	IF (SELECT name FROM simulator WHERE id=new.simulator_id) IS NULL
    THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid simulator ID';
	END IF;
END //

CREATE TRIGGER BeforeSimulatorDelete
BEFORE DELETE
ON simulator FOR EACH ROW
BEGIN
	IF (SELECT COUNT(*) FROM simulator) < 3 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Delete error MIN cardinality';
    END IF;
END //

CREATE TRIGGER BeforeUpdateSimulatorLog
BEFORE UPDATE
ON simulatorLog FOR EACH ROW
BEGIN
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = 'You cannot modify logs';
END //

CREATE TRIGGER AfterUpdateSimulator
AFTER UPDATE
ON simulator FOR EACH ROW
BEGIN
	INSERT INTO simulatorLog(action, dateTime) values('UPDATE', NOW());
END //
DELIMITER ;

-- Functions:
SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER //
CREATE FUNCTION GetMaxSalary()
RETURNS int
BEGIN
	RETURN (SELECT MAX(salary_in_dollars) from trainer);
END //
DELIMITER ;

-- Procedures:

DELIMITER //
CREATE PROCEDURE InsertIntoSimulator(in simulatorName varchar(50))
BEGIN
	INSERT INTO simulator(name) VALUES(simulatorName);
END //

CREATE PROCEDURE InsertNamesIntoTrainerWorksIn(in trainer_id int, in gym_id int)
BEGIN
	update trainer_works_in
    set trainer_name = (select name from trainer where id=trainer_id),
		gym_name = (select name from gym where id=gym_id)
    where trainer_works_in.trainer_id = trainer_id and trainer_works_in.gym_id = gym_id;
END //

CREATE PROCEDURE InsertLinesToSimulator(in numberOfLines int)
BEGIN
	DECLARE line int;
    SET line = 0;
	WHILE line < numberOfLines DO
        SET line = line + 1;
        CALL InsertIntoSimulator(CONCAT("Noname", line));
	END WHILE;
END //

CREATE PROCEDURE CallMaxSalary(out ans double)
BEGIN
	SELECT GetMaxSalary() into ans;
END //

CREATE PROCEDURE ProcCursor()
BEGIN
	DECLARE simulatorName varchar(50);
    DECLARE tablesCount int;
    DECLARE done boolean default false;
	DECLARE nameCur CURSOR 
    FOR SELECT name FROM simulator;
    DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET done = true;
    OPEN nameCur;
    myloop: LOOP
		FETCH nameCur INTO simulatorName;
		IF done THEN
			leave myloop;
        END IF;
        SET @tmpQuery = CONCAT('CREATE DATABASE IF NOT EXISTS ', simulatorName);
        PREPARE compiled FROM @tmpQuery;
        EXECUTE compiled;
        DEALLOCATE PREPARE compiled;
        SET tablesCount = 0;
        WHILE tablesCount < 5 DO
			SET tablesCount = tablesCount + 1;
            SET @tmpQuery = CONCAT('CREATE TABLE IF NOT EXISTS ', simulatorName, '.', simulatorName, (tablesCount), '(id int not null auto_increment, CONSTRAINT ', simulatorName, '_pk PRIMARY KEY (id))');
			PREPARE compiled FROM @tmpQuery;
			EXECUTE compiled;
			DEALLOCATE PREPARE compiled;
        END WHILE;
    END LOOP;
    CLOSE namecur;
END //

CREATE PROCEDURE DropTables()
BEGIN
	DECLARE simulatorName varchar(50);
    DECLARE done boolean default false;
	DECLARE nameCur CURSOR 
    FOR SELECT name FROM simulator;
    DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET done = true;
    OPEN nameCur;
    myloop: LOOP
		FETCH nameCur INTO simulatorName;
		IF done THEN
			leave myloop;
        END IF;
        SET @tmpQuery = CONCAT('DROP DATABASE IF EXISTS ', simulatorName);
        PREPARE compiled FROM @tmpQuery;
        EXECUTE compiled;
        DEALLOCATE PREPARE compiled;
    END LOOP;
    CLOSE namecur;
END //
DELIMITER ;

-- Selects:
select * from gym;
select * from trainer;
select * from trainee;
select * from exercise;
select * from program;
select * from program_contains;
select * from set_of_exercises;
select * from trainer_works_in;
select * from simulator;
select * from simulatorLog;