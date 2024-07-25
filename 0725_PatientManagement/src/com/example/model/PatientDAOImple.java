package com.example.model;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

// 인터페이스 상속받은 클래스
public class PatientDAOImple implements PatientDAO {

	private Connection conn;
	
	public PatientDAOImple() { //생성자
		DBConnection dbConn = new DBConnection();
		this.conn = dbConn.getConnection();  //1.2.3

	}
	

	
	@Override // 부모가 정의하지 않은 익셉션을 자식이 익셉션 할 수 없다
	public boolean createPatient(PatientVO p) throws SQLException {
		Statement stmt = this.conn.createStatement();  //4.
		StringBuffer sb = new StringBuffer();
		
		sb.append("INSERT INTO patient "); // t 뒤에 한칸 공백 줘야 함
		sb.append("VALUES (" + p.getNumber() + ", '" + p.getCode() + "', ");
		sb.append(p.getDays() + ", " + p.getAge() + ", '" + p.getDept() + "', ");
		sb.append(p.getOperFee() + ", " + p.getHospitalFee() + ", " + p.getMoney() + ")");
		System.out.println(sb.toString()); // 재정의한 toString
		
		// su는 성공시 1 반환
		int su = stmt.executeUpdate(sb.toString()); //5 selecet 제외한 나머지는 다 executeUpdate
		DBClose.dbClose(this.conn, stmt);

		return (su ==1)? true: false ; // 삼항 연산자
	}
	

	@Override
	public PatientVO readPatient(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientVO> readAllPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePatient(PatientVO p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatient(int number) {
		// TODO Auto-generated method stub
		return false;
	}

}
