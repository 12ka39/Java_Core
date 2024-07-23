package com.example;

//static에 this 못 씀
// 여기 코드 놓쳤음

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo1 {
	private DBConnection dbconn;
	private Connection conn;
	
	public JDBCDemo1(){
		this.dbconn = new DBConnection();
		this.conn = new Co
		
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your name? : ");
		String name = scan.next().toUpperCase(); // 대문자로	
		
		Statement stmt = null;
		ResultSet rs = null; 
		 
		try {
			stmt =demo.conn.creatStatement(); //4
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT ename, sal, grade  ");
			sb.append("FROM emp, salgrade   ");
			sb.append("WHERE (sal BETWEEN losal AND hisal) AND ename ='" + name + "'  " );
			 																						//       'SMITH'				
			rs = stmt.executeQuery(sb.toString()); //5
			
			while(rs.next()) { // 6
				System.out.printf("%s\t.1f\t%d%n",
						rs.getString("ename"), rs.getDouble("sal"), rs.getInt("grade"));
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
