package com.employ.view;

import java.util.Scanner;

import com.employ.controller.CalcController;
import com.employ.controller.InsertController;
import com.employ.controller.SelectController;
import com.employ.model.EmployeeVO;

public class EmployeeView {
	private Scanner scan;
	
	
	public EmployeeView() {
		this.scan = new Scanner(System.in);
		boolean isContinue = true;
		while(isContinue) {
			switch(showMenu()){
			case 1: insertPay(); break; // 직원 월급 등록
			case 2: printPay(); break; // 직원 월급 출력    
			case 99: 
				isContinue =false;
				break;
			
			default: System.out.println("잘못된 번호를 입력했습니다."); 
			isContinue = false;
			} 
		}
		System.out.println("Program in over");
	}
	
	// 사원 한 명 검색
	private EmployeeVO selectPatient() {
		SelectController sc = new SelectController();
		System.out.print("검색하실 사원 번호 : "); String empno = this.scan.next();
		EmployeeVO em = sc.selectEmployee(empno); // 검색한 결과가 담긴 직원정보들 
		
		if(em == null) {
			System.out.println("검색하신 사원이 없습니다");
		} else {
			System.out.printf("%s\t%s\t%d\t%d\t%d\t%n" ,
					em.getEmpno(), em.getEname(), em.getSal(), em.getOvertime(),
					em.getFamily());  
		}
		return em;
	}



	 // 직원 월급 등록
	private void insertPay() {
		String i_o =null;
		do {
			System.out.println("사원 등록 메뉴");
			System.out.print("1) 사원 번호 :"); String empno = scan.next();
			System.out.print("2) 사원 이름:"); String ename = scan.next();
			System.out.print("3) 기본급 :");  int grade = scan.nextInt();
			System.out.print("4) 야간시간 : "); int overtime = scan.nextInt();
			System.out.print("5) 가족수 : "); int family = scan.nextInt();
			EmployeeVO em = new EmployeeVO(empno, ename, grade, overtime, family);
			InsertController ic = new InsertController();
			if(ic.insert(em)){
				calcPay(em); // 계산
				System.out.println("사원 등록 성공");
			} else {
				System.out.println("사원 등록 실패");
				break;
			}
			System.out.println("입력 / 출력(I/O) ? : ");
			i_o = scan.next();
			if(i_o.toUpperCase().equals("O")) {
				System.out.println("end");
			}
		} while (i_o.toUpperCase().equals("I"));
		
		
	}
	
	
	
	// 사원 월급 계산
	private void calcPay(EmployeeVO em) {
		CalcController calc = new CalcController(em); // 계산하자.
		
		
	}
	
	
	private void printPay() {
		EmployeeVO em = selectPatient();
		
	}
	
	
	private int showMenu() {
		System.out.println("┌----------------------------------------┐");
		System.out.println("│           사원 관리 프로그램       │");
		System.out.println("└----------------------------------------┘");
		System.out.println("┌----------------------------------------┐");
		System.out.println("│1. 직원 월급 등록                              │");
		System.out.println("│2. 직원 월급 출력                        │");
		System.out.println("│99. 프로그램 종료                          │");
		System.out.println("└----------------------------------------┘");
		System.out.print("원하시는 메뉴 번호를 선택해 주세요 >> : ");
		return this.scan.nextInt();
	}
	
	
}


