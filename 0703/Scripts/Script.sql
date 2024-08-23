CREATE TABLE Patient(
	number TINYINT PRIMARY KEY,
	code   CHAR(2)  NOT NULL,
	days   SMALLINT NOT NULL,
	age   TINYINT NOT NULL,
	dept VARCHAR(20),
	operfee INT,
	hospitalfee INT,
	money INT
);