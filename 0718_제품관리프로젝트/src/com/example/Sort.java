package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
	List<Product> list;
	
	public Sort(List<Product> list) {  // 생성자
		this.list = list; // 이미 계산이 끝난 리스트
				
	}

	public void quickSort() { // 정렬
		// Collections.sort(this.list, new MyCompare); // 인터페이스 이렇게 자식 만들어서 해도 되지만
		// sort할 때만 할 거니까 익명 객체로 만들자
		
		Collections.sort(this.list, new Comparator<Product>() { // 파라미터로 익명객체 사용

			@Override  // 뭘 기준으로 비교할 건지. 우리는 제품의 이익금으로 비교하겠다
			public int compare(Product front, Product back) {

				return back.getBenefit() - front.getBenefit(); // 내림차순 (뒤에서 - 앞을 빼면 내림차순)
			} 
			
		}); // 익명객체
	}
	
	/*
	class MyCompare implements Comparator<Product>{ //이렇게 구현하는 대신 익명객체로
		
	}
*/
}
