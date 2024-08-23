package com.example.demo.guest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
	
	@Autowired
	private GuestDao dao;
	
	// 
	public void writeAdd(Guest g) {
		dao.insert(g);
	}

	
	// 전체 목록 조회
	public ArrayList<Guest> selectAll() {
		return dao.selectAll();
	}

	// 1명 조회
	public Guest getGuest(int num) {
		return dao.select(num);
	}
}
