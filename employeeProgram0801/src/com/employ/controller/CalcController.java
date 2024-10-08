package com.employ.controller;

import java.sql.SQLException;

import com.employ.model.EmployeeDAO;
import com.employ.model.EmployeeDAOImpl;
import com.employ.model.EmployeeVO;

public class CalcController {
	private EmployeeDAO eDao;
	
	public CalcController(EmployeeVO em) throws SQLException {
		this.eDao = new EmployeeDAOImpl();
		this.calc(em); // 생성자가 자동으로 calc함수 시작
	}
	
	private EmployeeVO calc(EmployeeVO em) { // 월급 계산
		
		/*
			> 총금액 (호급수당 + 기본급 + 야간수당 + 가족수당
			> 세금은 호급수당의 10%
			> 실수령액 : 총급액 - 세금
		 */
		
		String empno = em.getEmpno();
		String empno_bu = empno.substring(0, 1); // 부서명 코드 추출
		int empno_grade =  Integer.parseInt(empno.substring(1, 2))  ; // 호금수당코드 추출
		
		int sal_number = em.getSal(); // 입력받은 기본급
		int overtime = em.getOvertime(); // 입력받은 야간시간
		int family = em.getFamily();// 입력받은 가족 수
		
		
		String deptno = null; // 부서명 코드
		switch(empno_bu) { 
		case "A" :  deptno = "영업부";  break;
		case "B" :  deptno = "업무부";  break;
		case "C" :  deptno = "홍보부";  break;
		case "D" :  deptno = "인사부";  break;
		case "E" :  deptno = "경리부";  break;
		case "F" :  deptno = "판촉부";  break;
		case "G" :  deptno = "총무부";  break;
		}
		em.setDeptno(deptno);
		
		
		int sd_ho = 0; // 호급수당
		switch(empno_grade) {
			case 1: sd_ho = 900000; break;
			case 2: sd_ho = 400000; break; 
			case 3: sd_ho = 600000; break;
			case 4: sd_ho = 800000; break;
			case 5: sd_ho = 300000; break;
			case 6: sd_ho = 800000; break;
			case 7: sd_ho = 800000; break;
		}
		em.setSd_ho(sd_ho);
		
		
		//기본급
		int sal = 0;
		switch(sal_number) {
			case 1:  sal = 15000; break;
			case 2:  sal = 25000; break;
			case 3:  sal = 35000; break;
			case 4:  sal = 45000; break;
		}
		// em.setSal(sal);
		
		
		// 야간수당
		int sd_night = 0;
		switch(overtime) {
			case 1:  sd_night =  1500; break;
			case 2:  sd_night =  2500; break;
			case 3:  sd_night =  3500; break;
			case 4:  sd_night =  4500; break;
		}
		em.setSd_night(sd_night);
		
		
		// 가족수당
		int sd_family =  family * 7000;
		em.setSd_family(sd_family);

		
		// 총금액(totalPay)  - 호급수당 + 기본급 + 야간수당 + 가족수당
		int totalPay = em.getSd_ho() + sal + em.getSd_night() + em.getSd_family() ;
		em.setTotalPay(totalPay);
				
		// 세금
		double tax = em.getSd_ho() * 0.1;
				
		// 실수령액(realPay)
		int realPay = (int) (totalPay - tax);
		em.setRealPay(realPay);
		
		return em;

	}
	
	
	
	//private void calcPlus(EmployeeVO em) { // 총금액, 실수령액 구하기
		
		
	//}
	


}
