package com.example.view;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.example.controller.DeleteController;
import com.example.controller.InsertController;
import com.example.controller.SelectController;
import com.example.controller.UpdateController;
import com.example.model.PatientVO;

// view는 유저에게 보여주는 역할을 한다.
// 에러 메시지를 띄어주거나, 검색 결과를 보여주거나...
public class PatientView {
	private Scanner scan;
	
	public PatientView() {
		this.scan = new Scanner(System.in);
		boolean isContinue = true;
		while(isContinue) {
			switch(showMenu()) {
				case 1: insertMenu();  break; // 환자 등록
				case 2: selectMenu(); // 환자 검색 
				case 3: selectAllMenu(); break; // 환자 목록. 뷰단부터 만들면 DB 코드 완료할 때까지 오류난다
				case 4: updateMenu(); break; // 환자 수정
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
	
	// 4. 환자 수정
	private void updateMenu() {
		SelectController sc = new SelectController();
		System.out.print("검색하실 환자번호 : ");   int number = this.scan.nextInt();
		PatientVO p = sc.selectPatient(number);
		if(p == null) {  //그런 환자 없다면
			System.out.println("검색하신 환자를 찾을 수 없습니다.");
		}else {   //있다면
			System.out.println("환자등록번호 : " + p.getNumber());
			System.out.println("1)환자진료코드 : " + p.getCode());
			System.out.println("2)환자입원일수 : " + p.getDays());
			System.out.println("3)환자나이 : " + p.getAge());
			System.out.print("수정하실 항목의 번호 : ");     int choice = this.scan.nextInt();
			switch(choice) {
				case 1: 
					System.out.print("수정하실 진료코드 : ");  String code = this.scan.next();
					p.setCode(code);   break;
				case 2:
					System.out.print("수정하실 입원일수 : ");  int days = this.scan.nextInt();
					p.setDays(days);   break;
				case 3:
					System.out.print("수정하실 환자나이 : ");  int age = this.scan.nextInt();
					p.setAge(age);      break;
			}
			UpdateController uc = new UpdateController();
			p.setNumber(number);
			boolean flag = uc.update(p);
			if(flag)  System.out.println("환자 정보 수정 성공");
			else System.out.println("환자 정보 수정 실패");
		}
	}
	
	
	
	// 1. 환자 등록
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


	// 2. 환자 검색
	private void selectMenu() {
		SelectController sc = new SelectController();
		System.out.print("검색하실 환자번호 : ");   int number = this.scan.nextInt();
		PatientVO p = sc.selectPatient(number); // 환자가 없으면 null, 있으면 한 row가 나온다
		if(p == null) {  //그런 환자 없다면
			System.out.println("검색하신 환자를 찾을 수 없습니다.");
		}else {   //있다면
			System.out.printf("%d\t%s\t%,d\t%,d\t%,d%n",  p.getNumber(), p.getDept(), 
					p.getOperFee(), p.getHospitalFee(), p.getMoney());
		}
	}	

	//3. 환자 목록
	private void selectAllMenu() { 
		SelectController sc = new SelectController();
		List<PatientVO> list = sc.selectAllPatient();
		System.out.println("번호\t진찰부서\t진찰비\t입원비\t치료비");
		System.out.println("--------------------------------------------------------");
		
		if(list.size() == 0 || list == null) System.out.println("등록된 환자가 없습니다.");
		else if(list.size() > 0) {
			list.forEach(p -> System.out.printf("%d\t%s\t%,d\t%,d\t%,d\t%n",
					p.getNumber(), p.getDept(), p.getOperFee(), p.getHospitalFee(), p.getMoney()));
		}
		
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