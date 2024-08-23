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



/* 사원 월급 정보 업데이트  */

delimiter //
CREATE PROCEDURE emp_update(
	IN v_deptno VARCHAR(10),
    IN v_sd_ho int,
    IN v_sd_family int,
    In v_sd_night int,
    IN v_totalPay int,
    IN v_realPay int,
    In v_empno VARCHAR(5)
)
BEGIN
	UPDATE emp 
	SET deptno=v_deptno, sd_ho = v_sd_ho, sd_family= v_sd_family,
    sd_night=v_sd_night, totalPay=v_totalPay, realPay=v_realPay
	WHERE empno = v_empno;
END //
delimiter ;


/* 전체 사원 보기 */
CREATE PROCEDURE select_all_employee()
BEGIN
	SELECT * FROM testcompany.emp; 
END
//
delimiter ;