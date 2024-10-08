package com.example.demo.city;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
	@Autowired
	private CityDao dao;
	
	public City getCity(int id) {
		return dao.select(id);
	}
	
	public void addCity(City city) {
		dao.insert(city);
	}
	
	//전체 검색
	public ArrayList<City> getAll() {
		return dao.selectAll();
	}
	
	//수정
	public void editCity(City city) {
		dao.update(city);
	}
	
	//삭제
	public void delCity(int id) {
		dao.delete(id);
	}

}
