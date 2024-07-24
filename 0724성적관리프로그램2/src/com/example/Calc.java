package com.example;

import java.util.List;

public class Calc {
	private List<StudentVO> list; //field
	
	public Calc(List<StudentVO> list) { // 생성자
		this.list = list; // 이 넘어온 array는 input 해서 내용 들어간 배열
	}
	
	void calc() { // 메소드. 보안 때문에 public을 안 쓰고 있다. 패키지에서만 이 메소드 쓰니까
		this.list.forEach(std -> {  // 익명함수  (리스트에는 자체적은 이터러블이 있다)
			int tot = std.getKor() + std.getEng() + std.getMat() + std.getEdp();
			double avg = tot / 4.;
			char grade = (avg >=90)? 'A':
									(avg >=80)? 'B':
										 (avg >=70)? 'C':
											 (avg >=60)? 'D':'F';
			
			std.setTot(tot);   std.setAvg(avg);   std.setGrade(grade);
		});
		
	}
	
}
