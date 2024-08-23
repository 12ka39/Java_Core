package com.employ.model;

import java.sql.SQLException;
import java.util.List;


public interface EmployeeDAO {
	boolean createEmployee(EmployeeVO em) throws SQLException; // 직원 입력
	void updateEmployee(EmployeeVO em) throws SQLException; // 직원 월급 계산

	EmployeeVO readEmployee(String empno) throws SQLException; // 직원 1명
	List<EmployeeVO> readAllEmployee() throws SQLException; // 전체 직원
	
}
