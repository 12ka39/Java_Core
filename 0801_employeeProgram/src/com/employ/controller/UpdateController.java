package com.employ.controller;

import java.sql.SQLException;

import com.employ.model.EmployeeDAO;
import com.employ.model.EmployeeDAOImpl;
import com.employ.model.EmployeeVO;

public class UpdateController {
	private EmployeeDAO eDao;

	 public UpdateController(EmployeeVO em) {
		 eDao = new EmployeeDAOImpl();
		 this.update(em);
	 }
	 
	 
	 public boolean update(EmployeeVO em) {
		 boolean result = false;
		 try {
			 this.eDao.updateEmployee(em);
			 result = true;
			 
		 } catch(SQLException e) {
			 System.out.println(e.getMessage());
			 result = false;
		 }
		 return result;
		 
	 }
	 
	 
	 
	 
	 
}