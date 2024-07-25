
package com.example.controller;

import java.sql.SQLException;

import com.example.model.PatientDAO;
import com.example.model.PatientDAOImple;
import com.example.model.PatientVO;

public class InsertController {
	private PatientDAO pDao; // 인터페이스
	
	public InsertController() {  //Constructor
		pDao = new PatientDAOImple();  // 인터페이스라 자식으로 생성
	}
	
	
	public boolean insert(PatientVO p) { // 뷰가 부른다
		boolean result = false;  // 기본값 false
	
		try {
			CalcController cc = new CalcController(p);
			result = pDao.createPatient(p);
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}
}



