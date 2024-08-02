import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

//파라미터 없는 stored procedure -> 자바에서 이런 경우는 거의 없음.. 대부분 파라피터가 필요하다
public class CallableStatementDemo2 {

	public static void main(String[] args) throws SQLException {
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1,2,3
		String sql = "{ call deleteDept()}";  
		
		CallableStatement cstmt = null;
		
		try {
			cstmt = conn.prepareCall(sql);  // 4. 준비된 프로시저 호출
			cstmt.execute(); 					   // 프로시저 실행
			System.out.println("삭제 성공"); // delete from은 데이터만 삭제. 구조는 남아있다. 완전 없앨거면 drop
		} catch (SQLException ex) {
			System.out.println("삭제 실패");
		}
		
		DBClose.dbClose(conn, null); // 7
	}
}

/*

CREATE TABLE dept_clone
AS
SELECT * FROM dept;    // 클론 테이블 만들고, 


//클론 테이블 삭제하는 프로시저 만들었다
DELIMITER //
CREATE PROCEDURE sp_deleteDept()
BEGIN
	DELETE FROM dept_clone;
END
//
DELIMITER ;

CALL sp_deleteDept();  

*/