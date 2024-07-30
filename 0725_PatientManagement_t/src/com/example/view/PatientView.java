package com.example.view;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.example.controller.DeleteController;
import com.example.controller.InsertController;
import com.example.controller.SelectController;
import com.example.model.PatientVO;

public class PatientView {
	private Scanner scan;
	
	public PatientView() {
		this.scan = new Scanner(System.in);
		boolean isContinue = true;
		while(isContinue) {
			switch(showMenu()) {
				case 1: insertMenu();  break;
				case 2:
				case 3:
				case 4:
				case 5: deleteMenu(); break;
				case 99:  
					isContinue = false; 
					break;
				default:   System.out.println("잘못된 번호를 입력하셨습니다.");
				JOptionPane.showMessageDialog(null, "잘못된 번호를 입력하셨습니다."); // 이거 alert 창 꺼야 다음 줄 실행 됨
				showMenu();
			}
		}
		JOptionPane.showMessageDialog(null, "program is over..."); // alert 창이 모든 창 맨 뒤에 뜬다
	}
	
	
	private void deleteMenu() {
		SelectController sc = new SelectController();
		List<PatientVO> list = sc.selectAllPatient();
		System.out.println("번호\t진찰부서\t진찰비\t입원비\t치료비");
		System.out.println("--------------------------------------------------------");
		list.forEach(p -> System.out.printf("%d\t%s\t%,d\t%,d\t%,d\t%n",
					p.getNumber(), p.getDept(), p.getOperFee(), p.getHospitalFee(), p.getMoney()));
		
		System.out.println("삭제할 환자 등록 번호 : ");
		int number = this.scan.nextInt();
		
		DeleteController dc = new DeleteController();
		if(dc.delete(number)) JOptionPane.showMessageDialog(null, number + "번 환자의 정보가 삭제됐습니다.");
		else System.out.println("삭제 실패");
	}


	private void insertMenu() {
		String i_o = null;
		
		do {
			System.out.println("환자 등록 메뉴");   
			System.out.print("환자 등록 번호 : ");  int number = this.scan.nextInt();
			System.out.print("진료 코드 : ");        String code = this.scan.next();
			System.out.print("입원 일수 : ");        int days = this.scan.nextInt();
			System.out.print("환자 나이 : ");        int age = this.scan.nextInt();
			
			PatientVO p = new PatientVO(number, code, days, age);
			InsertController ic = new InsertController();
			
			if(ic.insert(p)) {
				System.out.println("환자 등록 성공");
			}else {
				System.out.println("환자 등록 실패");
			}
			
			System.out.println("입력 / 출력 (I/O)? :");
			i_o = this.scan.next();
		}while (i_o.toUpperCase().equals("I"));
	}
	
	private int showMenu() {
		System.out.println("┌----------------------------------------┐");
		System.out.println("│       새싹 정형외과 환자 관리 프로그램       │");
		System.out.println("└----------------------------------------┘");
		System.out.println("┌----------------------------------------┐");
		System.out.println("│1. 환자 등록                              │");
		System.out.println("│2. 환자 검색                              │");
		System.out.println("│3. 환자 목록                              │");
		System.out.println("│4. 환자 수정                              │");
		System.out.println("│5. 환자 삭제                              │");
		System.out.println("│99. 프로그램 종료                          │");
		System.out.println("└----------------------------------------┘");
		System.out.print("원하시는 메뉴 번호를 선택해 주세요 >> : ");
		return this.scan.nextInt();
	}
	
	
	
}