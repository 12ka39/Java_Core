package com.example;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//이건 익명함수와 List를 이용했다

public class SungjukMgmt { // 메인이 복잡할 수록 좋은 코드는 아님
	public static void main(String[] args) throws FileNotFoundException { // 메인으로 던져진 예외처리는 JVM 가상머신으로 던져짐
		List<StudentVO> list = new ArrayList <StudentVO> (); // 학생 12명 저장하는 수첩
		
		Input input = new Input(list); // 각 클래스에 12명 수첩 던져서 거기에 학생 정보 저장하도록
		input.input();
		
		Calc calc = new Calc(list); 
		calc.calc();
		/*
		Sort sort = new Sort(list);   
		sort.quickSorting(); // 람다함수 이용했다.
		*/
		
		Output output = new Output(list);
		output.output();
		
		System.out.println("Program is over.....!");
	}
}
