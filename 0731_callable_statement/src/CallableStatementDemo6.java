import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

/*
부서이름으로 부서위치를 출력하는 Stored Procedure
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
*/

// INOUT 파라미터 있는 stored procedure 
//부서 이름(값이 들어갔다가) -> 부서 위치(나오는 값)를 출력하는~
// 한 파라미터로 값 입력-> 출력이 되기 때문에
// 입력, 출력되는 값의 데이터 유형이 같아야 한다
public class CallableStatementDemo6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DBConnection dbConn = new DBConnection();
		Connection conn = dbConn.getConnection(); // 1,2,3
		String sql = "{ call selectDname(?) }";   //  불완전한 SQL 문장 - 프로시져 불러와서
		
		CallableStatement cstmt = null;
		
		try {
			
			cstmt = conn.prepareCall(sql); // 4.
			
			System.out.print("부서이름 : "); String dname = scan.next(); // RESEARCH

			cstmt.setString(1, dname);   // 들어갈 때
			// INOUT은 동시에 registerOutParameter() 도 사용해야 한다. 
			cstmt.registerOutParameter(1, java.sql.Types.VARCHAR); // 나올 때
			cstmt.execute();
			System.out.printf("%s 의 위치는  %s 입니다. %n",
											dname, cstmt.getString(1)); 
			System.out.println("성공");
		} catch (SQLException ex) {
			System.out.println("실패");
		}

		DBClose.dbClose(conn, null); // 7
	}
}



/* INOUT  - DECLARE 변수 선언이 필요 - 파라미터 있는 stored procedure ---------- 
/* 부서 이름(값이 들어갔다가) -> 부서 위치(나오는 값)를 출력하는 INOUT  Stored Procedure

/* v_name 으로 값을 입력 받아 그 값을 v_str에 넣고, 
그 값을 다시 v_name에 담아서 내보낸다
 /* v_name 에 새 값을 입력하기 위해 임시변수 v_str 가 필요 
 
DELIMITER $$
CREATE PROCEDURE selectDname(
	INOUT v_name VARCHAR(14)
)
BEGIN
	DECLARE v_str VARCHAR(13); /* 임시변수
	SELECT loc INTO v_str // into가 OUT파라미터 값
    FROM dept
    WHERE dname = v_name;   v_name 에 새 값을 입력하기 위해 임시변수 v_str 가 필요 
    SET v_name = v_str;
END $$
DELIMITER ;


SET @t_str := 'RESEARCH';  /* 값 세팅 
CALL selectDname(@t_str); /* 세팅한 채로 프로시저 실행 
SELECT @t_str; /* 값 담아져서 나옴,,  값이 들어갔다가 나오는 거. inout*/