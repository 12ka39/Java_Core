package com.example.controller;

import java.sql.SQLException;

import com.example.model.PatientDAO;
import com.example.model.PatientDAOImpl;
import com.example.model.PatientVO;


public class InsertController {
	private PatientDAO pDao;
	
	public InsertController() {  //Constructor
		pDao = new PatientDAOImpl(); //DAO 부르자.   부모형 (인터페이스) = 자식형
	}
	public boolean insert(PatientVO p) { // 생성하면 바로 this.calc(); 메소드 실행되면서 계산 값 set으로 넣어줌
		boolean result = false;
		try {
			CalcController cc = new CalcController(p);
			result = pDao.createPatient(p);
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}


/* stored procedure 사용 전
public class InsertController {
	private PatientDAO pDao;
	
	public InsertController() {  //Constructor
		pDao = new PatientDAOImpl(); 
	}
	
	
	public boolean insert(PatientVO p) {
		boolean result = false;
		try {
			CalcController cc = new CalcController(p); 
			result = pDao.createPatient(p); 
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}
}
*/

}