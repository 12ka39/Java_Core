package com.employ.controller;

import java.sql.SQLException;
import java.util.List;

import com.employ.model.EmployeeDAO;
import com.employ.model.EmployeeDAOImpl;
import com.employ.model.EmployeeVO;

public class SelectController {
	private EmployeeDAO eDao;
	
	public SelectController() {
		this.eDao = new EmployeeDAOImpl();
	}
	
	// 사원 1명
	public EmployeeVO selectEmployee(String empno) {
		EmployeeVO em = null;
		try {
			em = this.eDao.readEmployee(empno);
		} catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		return em;
	}

	// 전체 사원
	public List<EmployeeVO> selectAllEmployee(){
		 List<EmployeeVO> list = null;
		 
		 try {
			 list = this.eDao.readAllEmployee();
		 } catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
		 
		return list;
	}
	
}
