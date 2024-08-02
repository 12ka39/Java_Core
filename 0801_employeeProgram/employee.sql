/* 테이블 생성 */
CREATE TABLE `testcompany`.`emp` (
  `empno` VARCHAR(5) NOT NULL,
  `ename` VARCHAR(15) NULL,
  `deptno` VARCHAR(10) NULL,
  `sal` INT NULL,
  `sd_ho` INT NULL,
  `sd_family` INT NULL,
  `sd_night` INT NULL,
  `totalPay` INT NULL,
  `realPay` INT NULL,
  PRIMARY KEY (`empno`));



insert into emp values('C122', '이미자', 2, 1, 3);
SELECT * FROM testcompany.emp;


/* 사원 한 명 조회 ~ */
DELIMITER //
CREATE PROCEDURE select_one_employee(
	IN v_empno VARCHAR(4)
)
BEGIN
	SELECT * FROM emp WHERE empno = v_empno;
END
//
DELIMITER ;
