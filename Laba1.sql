-- tables
-- Table: Program_contains
use GYM_Database;

CREATE TABLE Program_contains (
    ID int  NOT NULL auto_increment,
    Excercise_ID int  NOT NULL,
    Program_ID int  NOT NULL,
    CONSTRAINT Program_contains_pk PRIMARY KEY (ID)
);

-- Table: Excercise
CREATE TABLE Excercise (
    ID int  NOT NULL auto_increment,
    Name varchar(50)  NOT NULL,
    Number_of_reps int  NULL,
    Distance_in_meters real  NULL,
    Duration_in_min int  NULL,
    CONSTRAINT Excercise_pk PRIMARY KEY (ID)
);

-- Table: Program
CREATE TABLE Program (
    ID int  NOT NULL auto_increment,
    Name varchar(50)  NOT NULL,
    Dificulty_level int  NOT NULL,
    CONSTRAINT Program_pk PRIMARY KEY (ID)
);

-- Table: Set_of_excercises
CREATE TABLE Set_of_excercises (
    ID int  NOT NULL auto_increment,
    Program_ID int  NOT NULL,
    Trainer_ID int  NOT NULL,
    Trainee_ID int  NOT NULL,
    Date_of_start date  NOT NULL,
    Date_of_end date  NOT NULL,
    CONSTRAINT Set_of_excercises_pk PRIMARY KEY (ID)
);

-- Table: Trainee
CREATE TABLE Trainee (
    ID int  NOT NULL auto_increment,
    Name varchar(50)  NOT NULL,
    Date_of_registration date  NOT NULL,
    Telephone_number varchar(10)  NOT NULL,
    Trainer_ID int  NOT NULL,
    CONSTRAINT Trainee_pk PRIMARY KEY (ID)
);

-- Table: Trainer
CREATE TABLE Trainer (
    ID int  NOT NULL auto_increment,
    Name varchar(50)  NOT NULL,
    Date_of_registration date  NOT NULL,
    Salary_in_dollars real  NOT NULL,
    CONSTRAINT Trainer_pk PRIMARY KEY (ID)
);

-- foreign keys
-- Reference: Program_contains_Excercise (table: Program_contains)
ALTER TABLE Program_contains ADD CONSTRAINT Program_contains_Excercise
    FOREIGN KEY (Excercise_ID)
    REFERENCES Excercise (ID)
;

-- Reference: Program_contains_Program (table: Program_contains)
ALTER TABLE Program_contains ADD CONSTRAINT Program_contains_Program
    FOREIGN KEY (Program_ID)
    REFERENCES Program (ID)
;

-- Reference: Set_Program (table: Set_of_excercises)
ALTER TABLE Set_of_excercises ADD CONSTRAINT Set_Program
    FOREIGN KEY (Program_ID)
    REFERENCES Program (ID)
;

-- Reference: Set_Trainee (table: Set_of_excercises)
ALTER TABLE Set_of_excercises ADD CONSTRAINT Set_Trainee
    FOREIGN KEY (Trainee_ID)
    REFERENCES Trainee (ID)
;

-- Reference: Set_Trainer (table: Set_of_excercises)
ALTER TABLE Set_of_excercises ADD CONSTRAINT Set_Trainer
    FOREIGN KEY (Trainer_ID)
    REFERENCES Trainer (ID)
;

-- Reference: Trainee_Trainer (table: Trainee)
ALTER TABLE Trainee ADD CONSTRAINT Trainee_Trainer
    FOREIGN KEY (Trainer_ID)
    REFERENCES Trainer (ID)
;

-- Insertions:

-- Table Trainer:
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Valera", '2002-01-01', 12
);
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Sasha", '2001-02-01', 120
);
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Andriy", '1991-02-01', 1120
);
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Illia", '2004-02-01', 1999991
);
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Lera", '2003-08-02', 101932
);
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Clown", '1981-01-01', 1
);
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Zenyk", '2019-01-12', 69
);
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Marichka", '2020-12-01', 0
);
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Voos", '2019-04-18', 1999991
);
insert into Trainer(Name, Date_of_registration, Salary_in_dollars)
values(
	"Anton", '1945-01-01', 10921
);

-- Table Trainee

insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Anton", '1945-01-01', "0979897971", 4
);
insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Clown", '2000-05-02', "1234567890", 3
);
insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Booka", '1945-04-10', "0987654321", 1
);
insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Chrome", '1900-02-01', "0979897971", 10
);
insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Sasha", '1845-01-01', "0979897971", 9
);
insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Illia", '2018-09-11', "0979897971", 2
);
insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Kokojamba", '2020-11-11', "0979897971", 8
);
insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Krokodyl", '2000-12-12', "0979897971", 3
);
insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Aboba", '1948-08-15', "0979897971", 5
);
insert into Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID)
values(
	"Vovan", '2024-12-12', "0979897971", 5
);

-- Table Excercise:
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Dips", 1, null, null
);
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Dips", 15, null, null
);
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Pull-Ups", 15, null, null
);
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Running", null, 1000, null
);
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Running", null, null, 1
);
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Leg-Rises", 127, null, null
);
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Jumps", 150, null, 15
);
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Twerk", null, null, 888
);
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Push-Ups", 105, null, null
);
insert into Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min)
values(
	"Kokojamba", 15, 10, 17
);

-- Table Program

insert into Program(Name, Dificulty_level)
values(
	"Monster", 100000
);
insert into Program(Name, Dificulty_level)
values(
	"Child", 1000
);
insert into Program(Name, Dificulty_level)
values(
	"Parent", 9999
);
insert into Program(Name, Dificulty_level)
values(
	"Kokojamba", 12
);
insert into Program(Name, Dificulty_level)
values(
	"Cockroach", 8996
);
insert into Program(Name, Dificulty_level)
values(
	"Krokodyl", 19
);
insert into Program(Name, Dificulty_level)
values(
	"Denys", 80
);
insert into Program(Name, Dificulty_level)
values(
	"Bebra", 189
);
insert into Program(Name, Dificulty_level)
values(
	"Mom", 17
);
insert into Program(Name, Dificulty_level)
values(
	"Mobster", 167
);

-- Table Program_contains
insert into Program_contains(Excercise_ID, Program_ID)
values(
	1, 1
);insert into Program_contains(Excercise_ID, Program_ID)
values(
	2, 1
);insert into Program_contains(Excercise_ID, Program_ID)
values(
	3, 2
);insert into Program_contains(Excercise_ID, Program_ID)
values(
	10, 1
);insert into Program_contains(Excercise_ID, Program_ID)
values(
	3, 2
);insert into Program_contains(Excercise_ID, Program_ID)
values(
	2, 2
);insert into Program_contains(Excercise_ID, Program_ID)
values(
	6, 6
);insert into Program_contains(Excercise_ID, Program_ID)
values(
	10, 6
);insert into Program_contains(Excercise_ID, Program_ID)
values(
	10, 10
);insert into Program_contains(Excercise_ID, Program_ID)
values(
	3, 7
);

-- Table Set_of_excercises:
insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	1, 1, 1, '2019-01-01', '2020-01-01'
);
insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	1, 2, 3, '2010-01-01', '2030-01-01'
);insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	10, 1, 7, '2011-11-01', '2020-01-01'
);insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	10, 10, 10, '2029-01-01', '2050-01-01'
);insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	1, 1, 1, '2019-01-01', '2020-01-01'
);insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	1, 10, 8, '2019-08-10', '2023-10-01'
);insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	7, 9, 9, '2019-11-11', '2021-01-01'
);insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	10, 7, 3, '2008-10-11', '2020-01-01'
);insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	6, 8, 10, '2019-01-01', '2020-01-01'
);insert into Set_of_excercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end)
values(
	5, 4, 3, '2015-11-01', '2021-01-11'
);

-- Selects:
select * from Trainer;
select * from Trainee;
select * from Excercise;
select * from Program;
select * from Program_contains;
select * from Set_of_excercises;