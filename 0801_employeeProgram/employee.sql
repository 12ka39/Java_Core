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



/* 사원 월급 정보 업데이트 -- 이거 문제있나?? 잘 안 됨 */
/* 프로시저 만들기 위한 기본 틀 */
UPDATE emp 
SET deptno='영업부', sd_ho =300000, totalPay=323500, realPay=293500
WHERE empno = 'A123';


delimiter //
CREATE PROCEDURE emp_update(
	IN v_deptno VARCHAR(10),
    IN v_sd_ho int,
    IN v_totalPay int,
    IN v_realPay int,
    In v_empno VARCHAR(5)
)
BEGIN
	UPDATE emp 
	SET deptno='영업부', sd_ho =300000, totalPay=323500, realPay=293500
	WHERE empno = 'A123';
END //
delimiter ;
