package com.employ.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.employ.controller.CalcController;
import com.employ.controller.InsertController;
import com.employ.controller.SelectController;
import com.employ.controller.UpdateController;
import com.employ.model.EmployeeVO;

public class EmployeeView {
	private Scanner scan;
	
	
	public EmployeeView() throws SQLException {
		this.scan = new Scanner(System.in);
		boolean isContinue = true;
		while(isContinue) {
			switch(showMenu()){
			case 1: insertPay(); break; // 1. 직원 월급 등록
			case 2: oneEmployeePay(); break; // 2. 직원 월급 출력  (검색)       
			case 3: allEmployeePay(); break; // 3. 직원 월급 출력  (전체 직원)   
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
	private EmployeeVO selectEmployee() {
		SelectController sc = new SelectController();
		System.out.print("검색하실 사원 번호 : "); String empno = this.scan.next();
		EmployeeVO em = sc.selectEmployee(empno); // 검색한 결과가 담긴 직원정보들 
		
		if(em == null) {
			System.out.println("검색하신 사원이 없습니다");
		} else {
			resultMenu();
			System.out.printf("%s\t%s\t%s\t%d\t%,d\t%,d\t%,d\t%,d\t%,d\t%n" ,
					em.getEmpno(), em.getEname(), em.getDeptno(), em.getSal(),
					em.getSd_ho(), em.getSd_family(), em.getSd_night(), 
					em.getTotalPay(), em.getRealPay());  
		}
		return em;
	}

	// 전체 직원 출력
	private void allEmployeePay() {
		SelectController sc = new SelectController();
		List<EmployeeVO> list =  sc.selectAllEmployee(); // select 한 직원 list에 담기
		
		resultMenu();
		if(list == null || list.size() == 0) System.out.println("등록된 직원 없습니다");
		else if(list.size() > 0) {
			resultMenu();
			list.forEach(em -> System.out.printf("%s\t%s\t%s\t%,d\t%,d\t%,d\t%,d\t%,d\t%,d\t%n", 
                    em.getEmpno(), em.getEname(), em.getDeptno(), em.getSal(),
                    em.getSd_ho(), em.getFamily(), em.getSd_night(),
                    em.getTotalPay(), em.getRealPay()));
		}
	}
	

	// 결과 메뉴 출력
	private void resultMenu() {
		System.out.println("                       << 사원관리 프로그램 >>");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("사원번호\t사원이름\t부서명\t기본급\t호급수당\t가족수당\t야간수당\t총금액\t실수령액");
		System.out.println("---------------------------------------------------------------------------");
	}
	

	 // 직원 월급 등록
	private void insertPay() throws SQLException {
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
				break;
			}
			System.out.print("입력 / 출력(I/O) ? : ");
			i_o = scan.next();
			if(i_o.toUpperCase().equals("O")) {
				System.out.println("end");
			}
		} while (i_o.toUpperCase().equals("I"));
		
		
	}
	
	
	
	// 사원 월급 계산
	private void calcPay(EmployeeVO em) throws SQLException {
		boolean result = false;
		CalcController calc = new CalcController(em); // 계산하자.
		UpdateController uc = new UpdateController(em); // DB 등록 컨트롤러
	}
	
	
	private void oneEmployeePay() {
		EmployeeVO em = selectEmployee();
		
	}
	
	
	private int showMenu() {
		System.out.println("┌----------------------------------------┐");
		System.out.println("│           사원 관리 프로그램       │");
		System.out.println("└----------------------------------------┘");
		System.out.println("┌----------------------------------------┐");
		System.out.println("│1. 직원 월급 등록                              │");
		System.out.println("│2. 직원 월급 출력  (검색)                      │");
		System.out.println("│3. 직원 월급 출력  (전체 직원)              │");
		System.out.println("│99. 프로그램 종료                          │");
		System.out.println("└----------------------------------------┘");
		System.out.print("원하시는 메뉴 번호를 선택해 주세요 >> : ");
		return this.scan.nextInt();
	}
	
	
}


