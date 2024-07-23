package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 좋은 코드는 아님
// 단지 DB의 id

public class JDBCDemo {

	public static void main(String[] args) {
		DBConnection dbconn = new DBConnection();
		Connection conn = dbconn.getConnection(); // 1~3번
		
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement(); // 4
			
			// StringBuffer에 append를 하는 게 속도가 더 빠르다
			StringBuffer sb = new StringBuffer(); // String을 바꾸기 위해 String Buffer 클래스 이용
			sb.append("SELECT empno, ename, sal, d.deptno, dname, loc   "); 
			sb.append("FROM emp e JOIN dept d ON(e.deptno = d.deptno)   ");
			sb.append("WHERE ename = 'SMiTH'");
			
			rs = stmt.executeQuery(sb.toString()); // 5번
			
			
			while(rs.next()) { // 6
				System.out.printf("%d\t%s\t%.1f\t%d\t%s\t%s%n",
						rs.getInt("empno"), rs.getString("ename"), rs.getDouble("sal"),
						rs.getInt("d.deptno"), rs.getString("dname"), rs.getString("loc"));
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} finally {
			DBClose.dbClose(conn, stmt, rs); //7 번
			
		}
		

	}

}
