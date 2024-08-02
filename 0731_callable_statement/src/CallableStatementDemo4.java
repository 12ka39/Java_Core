import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

// 사원 번호를 입력받아 -> 부서 이름과 부서 위치를 출력하시오
// IN ,    OUT 파라미터 같이 있는 stored procedure 
public class CallableStatementDemo4 {
	

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1,2,3
		String sql = "{ call selectEmp(?, ?, ?)}";   //  불완전한 SQL 문장 - 프로시저 불러와서
		
		CallableStatement cstmt = null;
		
		try {
			
			cstmt = conn.prepareCall(sql); // 4.
			
			System.out.print("사원번호 : "); int empno = scan.nextInt(); // 7369 번 입력하자
			cstmt.setInt(1, empno); // 들어가는 IN parameter  - setInt   // 가져오는 건 get
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR); // OUT parameter - registerOutParameter
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute(); // 5. 실행하고
			System.out.printf("부서명 : %s, 부서위치 : %s%n",
					cstmt.getString(2), cstmt.getString(3)); 
			// 결과 get 으로 가져옴
			System.out.println("성공");
		} catch (SQLException ex) {
			System.out.println("실패");
		}

		DBClose.dbClose(conn, null); // 7
	}
}
	
/*
사원 번호를 입력받아서 부서 이름과 부서 위치를 출력하시오
 
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

*/