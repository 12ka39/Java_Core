import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

// IN 파라미터 있는 stored procedure 
public class CallableStatementDemo3 {
	

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1,2,3
		String sql = "{ call insertDept(?, ?, ?)}";   //  불완전한 SQL 문장 - 프로시저 불러와서
		
		CallableStatement cstmt = null;
		
		try {
			
			cstmt = conn.prepareCall(sql); // 4. 
			
			System.out.print("부서 번호 : "); int deptno = scan.nextInt();
			System.out.print("부서 이름 : "); String dname = scan.next(); // nextLine하면 엔터가 따라 들어온다
			System.out.print("부서 위치 : "); String loc = scan.next();
			
			cstmt.setInt(1, deptno);
			cstmt.setString(2, dname);
			cstmt.setString(3, loc); // 완전한 SQL 문장
			cstmt.execute(); // 5. 파라미터 다 집어넣고 execute. 쿼리 실행
			
			System.out.println("새 레코드 삽입 성공");
		} catch (SQLException ex) {
			System.out.println("삽입 실패");
		}

		DBClose.dbClose(conn, null); // 7
	}
}
	
	
	
/* dept_clone 테이블에 값 추가하는 프로시저

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

*/
	 
