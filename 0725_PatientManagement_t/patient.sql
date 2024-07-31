CREATE TABLE mycompany.patient(
	number         TINYINT  NOT NULL,
	code           CHAR(2)  NOT NULL,
	days           SMALLINT NOT NULL,
	age            TINYINT  NOT NULL,
	dept           VARCHAR(20),
	operfee        INT,
	hospitalfee    INT,
	money          INT,
	CONSTRAINT patient_number_pk PRIMARY KEY(number)
);




/*  환자프로그램 - 모든 환자 가져오는 procedure  */
/* 번호, 진찰부서, 진찰비, 입원비, 진료비 */

Delimiter $$
CREATE PROCEDURE select_all_patient()
BEGIN
	SELECT number, dept, operfee, hospitalfee, money
    FROM patient 
    ORDER BY number DESC;
END
$$
Delimiter ;


/* 환자 한 명 가져오는 프로시저 */


Delimiter $$
CREATE PROCEDURE select_one_patient(IN v_number TINYINT)
BEGIN
	SELECT *
    FROM patient 
    WHERE number = v_number;
END
$$
Delimiter ;
