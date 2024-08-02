/* CallableStatementDemo1 */
/* OUT 프로시저 */ 
  
 DELIMITER //
CREATE PROCEDURE test(
	OUT v_now DATETIME,
    OUT v_version VARCHAR(30)
)
BEGIN
	SELECT NOW(), VERSION() INTO v_now, v_version;
    실행되는 쿼리를 적어야 한다, 그리고 그 결과를 
    변수 v_now, v_version에 담는다 
END
//
DELIMITER ;



/* CallableStatementDemo2 */
/* 파라미터 없는 stored procedure - 클론 테이블 삭제하는 프로시저 만들었다 */

CREATE TABLE dept_clone
AS
SELECT * FROM dept;    /* 클론 테이블 만들고, */ 

DELIMITER //
CREATE PROCEDURE sp_deleteDept()
BEGIN
	DELETE FROM dept_clone;
END
//
DELIMITER ;*/


/* CallableStatementDemo3 */
/* dept_clone 테이블에 값 추가하는 프로시저 */ 

DELIMITER $$
CREATE PROCEDURE insertDept(
	IN v_deptno TINYINT,
    IN v_name VARCHAR(14), 
	IN v_loc VARCHAR(13)
)
BEGIN
	INSERT INTO dept_clone(deptno, dname, loc)
	VALUES (v_deptno, v_name, v_loc);
    COMMIT;
END
$$
DELIMITER ;



/* CallableStatementDemo4 */
/* 사원 번호를 입력받아 -> 부서 이름과 부서 위치를 출력하시오
// IN ,    OUT 파라미터 같이 있는 stored procedure  */
DELIMITER $$
CREATE PROCEDURE selectEmp(
	IN v_empno SMALLINT,
    OUT v_dname VARCHAR(14),
    OUT v_loc VARCHAR(13)
)
BEGIN
	SELECT dname, loc INTO v_dname, v_loc
    FROM emp JOIN dept ON (emp.deptno = dept.deptno)
    WHERE empno = v_empno;
END
$$
DELIMITER ;



/* CallableStatementDemo5 */
/* 여러 행 ROW를 반환하는 PROCEDURE
부서번호로 소속사원의 사원번호, 사원명, 부서명, 부서위치가 다 나오는 경우 (OUT이 여러개) */

DELIMITER $$
CREATE PROCEDURE select_emp_dept(
	IN v_deptno TINYINT
)
BEGIN
	SELECT empno, ename, dname, loc, deptno
	FROM emp NATURAL JOIN dept
    WHERE deptno = v_deptno;
END $$
DELIMITER ;



/* CallableStatementDemo6 */
/* 부서이름으로 부서위치를 출력하는 Stored Procedure */
Delimiter $$
CREATE PROCEDURE selectDname
(
	INOUT v_name  VARCHAR(14)
)
BEGIN
	DECLARE v_str VARCHAR(14);
	SELECT  loc INTO v_str
    FROM dept
    WHERE dname = v_name;
    SET v_name := v_str;
END $$
Delimiter ;
