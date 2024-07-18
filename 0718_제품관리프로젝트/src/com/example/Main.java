package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<Product>(); // 기본 10개의 방을 만든다.
		// list는 인터페이스라 생성 불가
		// 지금 리스트가 총 몇 개인지 개수 모름
		
		Input input = new Input(list); // 입력
		input.fileInput();
		
		Calc calc = new Calc(list); // 계산
		calc.calc();
		
		Sort sort = new Sort(list); // 정렬
		sort.quickSort();
		
		Output output = new Output(list); // 출력
		output.list();
		
		System.out.println("Program is over..............");
	}

}
