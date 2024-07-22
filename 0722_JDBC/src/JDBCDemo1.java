// 1단계
import java.sql.*;

// 아까보다 코드를 줄여주자
// 그래도 코드 길고, DB정보가 노출되어 있음 -> 보안 문제는 둘째 치고
// 나중에 DB 비번이 바뀌면 코드에 있는 거 하나하나 다 수정해줘야 함. 비효율적

public class JDBCDemo1 {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/mycompany";
	private static final String id = "root";
	private static final String password = "mymysql";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 2단계 드라이버 로딩
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		

		try { 
			// 3단계
			conn = DriverManager.getConnection(url, id, password); 
			
			// 4단계
			stmt = conn.createStatement();
			
			// 5단계 Query 실행하기 : 월급이 1500$ 이상인 직원만 찍으세요. 자바 개발자는 query문을 잘 쓰자.(쿼리 튜닝)
			String sql = "SELECT empno, ename, job, sal      ";
			sql += "FROM emp   ";
			sql += "WHERE sal >= 1500";
			rs = stmt.executeQuery(sql);
			
			
			// 6단계 : ResultSet 파싱하자.
			while(rs.next()){
				int empno = rs.getInt(1); //empno : 이렇게 1번째 해도 되지만, 가독성을 위해 컬럼명을 적어주자
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				double sal = rs.getDouble("sal");
				System.out.printf("%d\t%s\t%s\t%.2f\t%n", empno, ename, job, sal);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 7. close
			try {
				if (rs!=null) rs.close();
				if(stmt !=null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
