package com.employ.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
		sb.append(em.getSal() + ", " + em.getSd_night() + ", " + em.getSd_family() + ")");
		System.out.println(sb.toString());
		int su = stmt.executeUpdate(sb.toString());    //5
		DBClose.dbClose(this.conn, stmt);
		return (su == 1) ? true : false;
	}

	
	// 월급 계산 -> EmployeeVO에 저장된 값 DB에 저장.
	@Override
	public void updateEmployee(EmployeeVO em) throws SQLException { 
		/*  프로시저 대신 이것도 실행되는 코드다
		 * 
		String sql = "UPDATE emp SET deptno=?, sd_ho = ?, sd_family =?, sd_night=?,  totalPay=?, realPay=? WHERE empno = ?";
		PreparedStatement pstmt = this.conn.prepareStatement(sql);  //4.
		pstmt.setString(1, em.getDeptno());   
		pstmt.setInt(2, em.getSd_ho());
		pstmt.setInt(3, em.getSd_family());
		pstmt.setInt(4, em.getSd_night());
		
		pstmt.setInt(5, em.getTotalPay());
		pstmt.setInt(6, em.getRealPay());
		pstmt.setString(7, em.getEmpno());
		pstmt.execute();
		DBClose.dbClose(conn, pstmt);       //7
		*/
		
		// procedure
		String sql = "{call emp_update(?,?,?,?,?,?,?)}";
		CallableStatement cstmt = this.conn.prepareCall(sql);
			cstmt.setString(1, em.getDeptno());
			cstmt.setInt(2, em.getSd_ho());
			cstmt.setInt(3, em.getSd_family());
			cstmt.setInt(4, em.getSd_night());
			
			cstmt.setInt(5, em.getTotalPay());
			cstmt.setInt(6, em.getRealPay());
			cstmt.setString(7, em.getEmpno());
			
			System.out.println(em.getEmpno()); 
			
			cstmt.execute(); 
		
		DBClose.dbClose(conn, cstmt);
	}
	
	
	// 사원 한 명 조회
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
					rs.getString("deptno"), rs.getInt("sal"), rs.getInt("sd_ho"),
					rs.getInt("sd_family"), rs.getInt("sd_night"), 
					rs.getInt("totalPay"), rs.getInt("realPay"));
		} else {
			
		}
		return em;
	}

	

	// 전체 사원 조회
	@Override
	public List<EmployeeVO> readAllEmployee() throws SQLException {
		String sql = "{ call select_all_employee()}"; // procedure
		CallableStatement cstmt = this.conn.prepareCall(sql); // sql 세팅
		ResultSet rs = cstmt.executeQuery(); // sql 실행
		List<EmployeeVO> list = new ArrayList<>();
		boolean flag = rs.next();

		if(!flag) {
		} else {
			do {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String deptno = rs.getString("deptno");
				int sal = rs.getInt("sal");
				int sd_ho = rs.getInt("sd_ho");
				int sd_family = rs.getInt("sd_family");
				int sd_night = rs.getInt("sd_night");
				int totalPay = rs.getInt("totalPay");
				int realPay = rs.getInt("realPay");
				
				EmployeeVO em = new EmployeeVO();
				em.setEmpno(empno); em.setEname(ename);
				em.setDeptno(deptno); em.setSal(sal);
				em.setSd_ho(sd_ho); em.setFamily(sd_family);
				em.setSd_night(sd_night); em.setTotalPay(totalPay);
				em.setRealPay(realPay);
				
				list.add(em);
				
			} while(rs.next());
		}
		System.out.println();
		
		DBClose.dbClose(conn, cstmt, rs);
		return list;
	}
}
