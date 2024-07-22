// 7단계
 

/*Class.forName("com.mysql.cj.jdbc.Driver");
 * conn = DriverManager.getConnection(url , "root", "mymysql");
 * stmt = conn.createStatement();
 * rs = stmt.executeQuery("SELECT now(), version()");
 * 
 * // JDBC 가장 오리지널 방법 (코드 길다, 요즘은 안 쓴다)
 	1) import 하자. java.sql.*
 * */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		// 2) connector J . jar 를 프로젝트에 추가 후, 
			// MySQL Driver.class를 메모리에 Loading 하자 
			//드라이버는 드라이버 매니저가 관리한다
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 메모리에 올리면 드라이버 매니저가 관리할 수 있다
			//DriverManager.regisget(null); 이렇게도 드라이버를 올릴 수 있다.
			System.out.println("Class Founded");
		} catch (ClassNotFoundException e) {
				System.out.println("Class Not Found");
		}
		
		// 3) 메모리에 로딩된 MySQL Driver를 이용하여 Connection 하자.
			// 드라이버 매니저
		String url = "jdbc:mysql://localhost:3306/mycompany"; // DB명까지 적는다
					    //jdbc 프로토콜 사용
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url , "root", "mymysql"); // DB 연결
			System.out.println("Connection Success");
		} catch (SQLException e) {
			System.out.println("Connection Failure");
		}
		
		
		// 4. Statement 객체 생성 
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		// 5. Statement 객체를 이용하여 SQL 실행하자
		ResultSet rs = null;  //결과를 담아오는 바구니 '데이터셋'을 JDBC에서는 'resultSet'이라고 한다
		try {
			rs = stmt.executeQuery("SELECT now(), version()"); // SELECT => executeQuery
		} catch (SQLException e) {
			System.out.println("Query Syntax Error");
		}  
		
		
		//6. ResultSet 의 결과를 Parsing하자
		try {
			
			rs.next(); // 한 줄을 읽는다.
			String now = rs.getString(1); // now()  JDBC는 인덱스가 1부터 시작한다! 자바에서 유일하게 1로 시작한느 인덱스
														// 왜냐? DB가 더 중요하니까 1
			System.out.println(now);
			String version = rs.getNString(2);
			System.out.println(version); // 드라이버 버전 8.0.38 (mysql 버전 아님)
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
		// 반드시 Close 해야 한다.
		try {
			if (rs!=null) rs.close();
			if(stmt !=null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
