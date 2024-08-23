package com.example.controller;

import java.sql.SQLException;

import com.example.model.PatientDAO;
import com.example.model.PatientDAOImpl;

public class DeleteController {
	private PatientDAO dao;
	
	public DeleteController() {
		this.dao = new PatientDAOImpl();
	}
	
	public boolean delete(int number) {
		boolean isSuccess = false;
		try {
			isSuccess = this.dao.deletePatient(number);
		}catch(SQLException ex) {
			System.out.print(ex.getMessage());
		}
		return isSuccess;
	}
}
