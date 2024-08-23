package com.example;

import java.sql.*;

// DB 닫아주기만 하는 클래스

public class DBClose {
	
	// 1) 커넥션만 닫을 때
	public static void dbClose(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// 2) 커넥션과 스테이트먼트만 닫을 떼
	public static void dbClose(Connection conn, Statement stmt) {
			try {
				if(stmt != null)  stmt.close();
				if(conn != null)  conn.close();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	
	
	// 3) 커넥션, ruseltSet, 스테이트먼트 모두 닫을 때.
	public static void dbClose(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null)      rs.close();
			if(stmt != null)  stmt.close();
			if(conn != null)  conn.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}		
	
}
