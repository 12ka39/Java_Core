import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

// OUT 파라미터 있는 stored procedure
// stored procedure 는 표준이 아니다! DB마다 문법이 다름
public class CallableStatementDemo {

	public static void main(String[] args) throws SQLException {
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1,2,3
		
		// stored procedure 를 자바에서 쓰는 방법
		// 자바에서 결과를 받으려면 DB에서 prodecure가 'out' 파라미터로 넘겨줘야 한다 
		
		String sql = "{call test(?, ?)}";  // 미완성 SQL 문장
		CallableStatement cstmt = conn.prepareCall(sql); // 4. 준비된 프로시저 호출
								// 모든 DB가 stored procedure가 있는 건 아님. 큰 DB에만 있다
		
		// IN         parameter는   Set XXX() 를 사용하고
		// OUT       parameter는   registerOutParameter를 사용한다.
		// INOUT   parameter는   Set XXX() , registerOutParameter를 사용한다.
		

		// 지금 out 파라미터 하는 중이니까 registerOutParameter
		cstmt.registerOutParameter(1, java.sql.Types.DATE); // DB는 인덱스가 1부터 시작한다 
		cstmt.registerOutParameter(2, java.sql.Types.VARCHAR); // 완전한 SQL 문장
		cstmt.execute(); // execute는  execute update, execute query를 단순화 한 거
		// 오라클DB의 경우 executeUpdate()를 사용해야 한다.
		
		System.out.println(cstmt.getDate(1)); // 2024-07-31
		System.out.println(cstmt.getString(2)); // 8.0.37-0ubuntu0.22.04.3
		
		DBClose.dbClose(conn, null); // 7
	}

}



/* OUT 프로시저
  
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

CALL test(@t_now, @t_version); 
/*이걸 자바에서 가져다 쓰자 
/* 시스템 변수 @@    
 * 임시변수     @v    
 * 바인딩 변수 @t       

select @t_now, @t_version;
*/



/*  이건 이 클래스와는 상관x
 파라미터가 없는 stored procedure 
   
DELIMITER //
CREATE PROCEDURE test()
BEGIN
	SELECT NOW(), VERSION(); 
END
//
DELIMITER ;

*/
