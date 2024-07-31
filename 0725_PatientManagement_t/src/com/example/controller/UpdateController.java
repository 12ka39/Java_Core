package com.example.controller;

import java.sql.SQLException;

import com.example.model.PatientDAO;
import com.example.model.PatientDAOImpl;
import com.example.model.PatientVO;

// 입원비 다시 계산
public class UpdateController {
	
	private PatientDAO pDao;

	public UpdateController() {
		this.pDao = new PatientDAOImpl();
	}
	
	public boolean update(PatientVO p) { // 수정된 patineVO 한 줄이 넘어온다
		boolean flag = false;
		try {
			CalcController cc = new CalcController(p);
			this.pDao.updatePatient(p);
			flag = true;
			
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
			flag = false;
		}
		
		return flag;
	}

}
