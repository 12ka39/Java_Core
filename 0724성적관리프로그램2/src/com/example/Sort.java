package com.example;

import java.util.Collections;
import java.util.List;
// 여기 오류..............................
public class Sort {
	List<StudentVO> list;
	
	public Sort(List<StudentVO> list) {
		this.list = list;
	}
	
	public void quickSorting() {
		/* Collections.sort(this.list, new Comparator<StudentVO>() { //매개변수를 익명함수로

			@Override
			public int compare(StudentVO front, StudentVO back) {
				return  back.getTot() - front.getTot(); // 내림차순
			} */ 
		Collections.sort(this.list, (front,  back) ->  back.getTot() - front.getTot()); // 람다함수
				
		}
	}
	
