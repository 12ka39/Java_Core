package com.employ.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAOImpl implements EmployeeDAO{
	private Connection conn;

	public EmployeeDAOImpl() {// 생성자
		DBConnection dbConn = new DBConnection();
		this.conn = dbConn.getConnection();
	}
	
	// 사원 등록
	@Override
	public boolean createEmployee(EmployeeVO em) throws SQLException {
		Statement stmt = this.conn.createStatement();
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO emp(empno, ename, sal, sd_night, sd_family) ");
		sb.append("VALUES ('" + em.getEmpno() + "', '" + em.getEname() + "', ");
		sb.append(em.getSal() + ", " + em.getOvertime() + ", " + em.getFamily() + ")");
		System.out.println(sb.toString());
		int su = stmt.executeUpdate(sb.toString());    //5
		DBClose.dbClose(this.conn, stmt);
		return (su == 1) ? true : false;
	}

	
	// 사원 select
	@Override
	public EmployeeVO readEmployee(String empno) throws SQLException {
		String sql = "{ call select_one_employee(?) }";
		
		CallableStatement cstmt = this.conn.prepareCall(sql);
		cstmt.setString(1, empno);
		ResultSet rs = cstmt.executeQuery();
		boolean flag = rs.next();
		EmployeeVO em = null;
		
		if(flag) {
			em = new EmployeeVO(rs.getString("empno"), rs.getString("ename"), 
					rs.getInt("grade"), rs.getInt("overtime"), rs.getInt("family"));
		} else {
			
		}
		return em;
	}

	// 월급 계산 -> DB에 추가
	@Override
	public boolean insertEmployee(EmployeeVO em) throws SQLException { // procedure
		return false;
	}
}
