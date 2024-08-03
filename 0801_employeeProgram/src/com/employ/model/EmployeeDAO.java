package com.employ.model;

import java.sql.SQLException;
import java.util.List;


public interface EmployeeDAO {
	boolean createEmployee(EmployeeVO em) throws SQLException;
	void updateEmployee(EmployeeVO em) throws SQLException;

	EmployeeVO readEmployee(String empno) throws SQLException;
	List<EmployeeVO> readAllEmployee() throws SQLException;
	
}
