package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 이것도 안 됨
public class JDBCDemo2 {

	public static void main(String[] args) {
		String sql = "SELECT dept.deptno, dname, ROUND(AVG(sal), AS avg_sal), COUNT(sal), SUM(sal)   ";
		sql += "FROM emp JOIN dept ON(emp.deptno = dept.deptno)    ";
		sql += "GROUP BY deptno ORDER BY avg_sal DESC"; // 이런 식으로 하면 속도가 느리다
		
		Connection conn = new DBConnection().getConnection();
		// 객체를 한 번만 쓸 때
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.printf("%d\t%s\t%.2f\t%d%n",
						rs.getInt("dept.deptno"), rs.getString("dname"), 
						rs.getDouble(3), rs.getInt(4), rs.getInt(5));
			}
			
			
		} catch(SQLException e) {
			
		} finally {
			DBClose.dbClose(conn, stmt, rs);
		}
	}

}
