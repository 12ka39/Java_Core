CREATE TABLE mycompany.Patient(
	number TINYINT PRIMARY KEY,
	code   CHAR(2)  NOT NULL,
	days   SMALLINT NOT NULL,
	age   TINYINT NOT NULL,
	dept VARCHAR(20),
	operfee INT,
	hospitalfee INT,
	money INT
	constraint patient_number_pk PRIMARY key(number)
);

constraint patient_number_pk PRIMARY key(number)