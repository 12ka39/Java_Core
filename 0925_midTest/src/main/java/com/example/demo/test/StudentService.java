package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	//학생 추가
	public void addStudent(StudentDto dto) {
		dao.save(new Student(dto.getId(), dto.getName(), dto.getGrade()));
	}
	
	
	//전체 학생 목록
	public ArrayList<StudentDto> getList(){
		 List<Student> all = dao.findAll();
		 ArrayList<StudentDto> list = new ArrayList<>();
		 
		 for(Student stu : all) {
			 list.add(new StudentDto(stu.getId(), stu.getName(), stu.getGrade()));
		 }
		 
		 return list;
	}
	
}
