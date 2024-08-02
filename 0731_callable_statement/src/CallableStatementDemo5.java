import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

/*
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
*/

// 여러 행 ROW를 반환하는 PROCEDURE
// 부서번호로 소속사원의 사원번호, 사원명, 부서명, 부서위치가 다 나오는 경우 (OUT이 여러개)
public class CallableStatementDemo5 {
	

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1,2,3
		String sql = "{ call select_emp_dept(?)}";   //  불완전한 SQL 문장 - 프로시저 불러와서
		
		CallableStatement cstmt = null;
		ResultSet rs = null; 
		
		try {
			
			cstmt = conn.prepareCall(sql); // 4.
			
			System.out.print("부서번호 : "); int deptno = scan.nextInt(); // 10, 20, 30, 40 중에 입력
			
			cstmt.setInt(1, deptno);   // 완전한 SQL 문장
			rs = cstmt.executeQuery(); // 	ResultSet으로 반환을 받을 때만 executeQuery()
			// sql 겸색결과 돌려서 결과가 있으면 true가 뜸 
			boolean flag = rs.next(); // 데이터가 없으면 false
			
			if(!flag) { // 레코드가 한 개도 없다면.  !flag =  ! false = true  (if의 조건이 참이면 실행)
				System.out.println("조건에 맞는 결과값이 없습니다");
			} else { // 한 개라도 있다면
				do {
					System.out.printf("%d\t%s\t%s\t%s%n",
							rs.getInt("empno"), rs.getString("ename"), rs.getString("dname"), rs.getString("loc"));
				} while (rs.next());
			}
			
		} catch (SQLException ex) {
			System.out.println("실패");
		}

		DBClose.dbClose(conn, null); // 7
	}
}




/**********************여러 개의 레코드가 나올 때 *******************************

부서번호로 소속사원의 사원번호, 사원명, 부서명, 부서위치가 다 나오는 경우 (OUT이 여러개)


SELECT empno, ename, dname, loc, deptno
FROM emp NATURAL JOIN dept
WHERE deptno = 10;



내츄럴 조인 - 두 테이블의 공통 컬럼 찾아냄 
내츄럴 조인 아니고 join만 쓰면 on 이 있어야 한다

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

DROP PROCEDURE select_emp_dept;

CALL select_emp_dept(20);


**/