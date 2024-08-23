package com.employ.controller;

import java.sql.SQLException;

import com.employ.model.EmployeeDAO;
import com.employ.model.EmployeeDAOImpl;
import com.employ.model.EmployeeVO;

public class InsertController {
	private EmployeeDAO eDao;

	public InsertController() {
		eDao = new EmployeeDAOImpl();
	}
	
	public boolean insert(EmployeeVO em) {
		boolean result = false;
		
		try {
			//CalcController cc = new CalcController(em); 이건 따로 
			result = eDao.createEmployee(em);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return result;
	}
}
