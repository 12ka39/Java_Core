import java.util.Scanner;

	public class Input {
		void input(Student std) { // 멤버 메소드
	
	Scanner sc = new Scanner(System.in); // 학생 정보 키보드로 입력
	System.out.print("학번 :"); 
	
	String hakbun = sc.next(); 
	std.setHakbun(hakbun); // 이 두 줄이 번거로우니까
	
	System.out.print("국어 :");  std.setKor(sc.nextInt()); // 이렇게 한 줄로
	System.out.print("영어 :");  std.setEng(sc.nextInt());
	System.out.print("수학 :");  std.setMath(sc.nextInt());
	};
}
