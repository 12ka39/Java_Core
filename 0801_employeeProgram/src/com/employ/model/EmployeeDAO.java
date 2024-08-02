package com.employ.model;

import java.sql.SQLException;


public interface EmployeeDAO {
	boolean createEmployee(EmployeeVO em) throws SQLException;

	EmployeeVO readEmployee(String empno) throws SQLException;
	
	boolean insertEmployee(EmployeeVO em) throws SQLException;
}
