package com.example.controller;

import java.sql.SQLException;

import com.example.model.PatientDAO;
import com.example.model.PatientDAOImpl;

// 컨트롤러는 view 와 dao를 연결해준다.    뷰 - 컨트롤러 - dao
public class DeleteController {
	private PatientDAO dao;
	
	
	public DeleteController() { // 생성자
		this.dao = new PatientDAOImpl(); //DAO 부르자.   부모형 (인터페이스) = 자식형
	}

	public boolean delete(int number) {
		boolean isSucess = false;
		try {
			isSucess = this.dao.deletePatient(number);
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return isSucess;
	}

}
